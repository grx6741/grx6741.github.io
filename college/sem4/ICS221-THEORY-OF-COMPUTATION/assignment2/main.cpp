#include <iostream>
#include <vector>
#include <algorithm>

class Node {
public:
    std::string name;
    bool isstart;
    bool isFinal;
    bool reachable;
    Node(std::string name, bool start, bool final) : name(name), isstart(start), isFinal(final), reachable(false) {}
    friend std::ostream& operator<<(std::ostream& os, const Node& node) {
        return os << node.name << ", start = " << node.isstart << ", final = " << node.isFinal;
    }
    void addTransition_A(Node* A) {
        this->A = A;
    }
    void addTransition_B(Node* B) {
        this->B = B;
    }
public:
    Node* A;
    Node* B;
};

class DFA {
public:
    DFA() : StartFound(false) {}
    void addNode(std::string name, bool start, bool final) {
        if (start && StartFound) {
            std::cout << "Start symbol already given" << std::endl;
        }
        StartFound = true;
        Nodes.push_back(Node(name, start, final));
    }
    std::pair<int, Node*> getNode(std::string name) {
        for (int i = 0; i < Nodes.size(); ++i) {
            if (Nodes[i].name == name) {
                return { i, &Nodes[i] };
            }
        }
        return { -1, nullptr };
    }
    void remove_unreachable() {
        Nodes.erase(std::remove_if(Nodes.begin(), Nodes.end(), [](const Node& node) { return !node.reachable; }), Nodes.end());
    }
    bool checkTransClosure(std::vector<std::vector<Node*>>& Groups, Node* node1, Node* node2) {
        Node* node1_a = node1->A;
        Node* node1_b = node1->B;
        Node* node2_a = node2->A;
        Node* node2_b = node2->B;

        for (auto& grp : Groups) {
            if ((std::find(grp.begin(), grp.end(), node1_a) != grp.end() && std::find(grp.begin(), grp.end(), node2_a) == grp.end()) ||
                (std::find(grp.begin(), grp.end(), node1_a) == grp.end() && std::find(grp.begin(), grp.end(), node2_a) != grp.end())) {
                return false;
            }
            if ((std::find(grp.begin(), grp.end(), node1_b) != grp.end() && std::find(grp.begin(), grp.end(), node2_b) == grp.end()) ||
                (std::find(grp.begin(), grp.end(), node1_b) == grp.end() && std::find(grp.begin(), grp.end(), node2_b) != grp.end())) {
                return false;
            }
        }
        return true;
    }
    std::vector<std::vector<Node*>> splitGroups(Node* node1, Node* node2, std::vector<std::vector<Node*>>& Groups) {
        int idx;
        for (idx = 0; idx < Groups.size(); ++idx) {
            auto it = std::find(Groups[idx].begin(), Groups[idx].end(), node1);
            if (it != Groups[idx].end()) {
                Groups[idx].erase(it);
                std::sort(Groups[idx].begin(), Groups[idx].end());
                break;
            }
        }

        for (int i = idx + 1; i < Groups.size(); ++i) {
            if (Groups[i].empty()) {
                Groups[i].push_back(node2);
                std::sort(Groups[i].begin(), Groups[i].end());
                break;
            }
        }
        return Groups;
    }
    std::vector<std::vector<Node*>> findEquivalence(std::vector<std::vector<Node*>>& Groups) {
        bool changedFlag = true;
        while (changedFlag) {
            for (auto& grp : Groups) {
                if (grp.empty()) continue;
                if (grp.size() == 1) continue;
                for (size_t i = 0; i < grp.size(); ++i) {
                    for (size_t j = i + 1; j < grp.size(); ++j) {
                        if (checkTransClosure(Groups, grp[i], grp[j])) {
                            // do nothing
                        }
                        else {
                            Groups = splitGroups(grp[i], grp[j], Groups);
                            break;
                        }
                    }
                    if (!changedFlag)
                        break;
                }
                if (!changedFlag)
                    break;
            }
            changedFlag = false;
        }
        for (auto& grp : Groups) {
            std::sort(grp.begin(), grp.end(), [](const Node* a, const Node* b) { return a->name < b->name; });
        }
        std::sort(Groups.begin(), Groups.end(), [](const std::vector<Node*>& a, const std::vector<Node*>& b) { return a[0]->name < b[0]->name; });
        return Groups;
    }
    void printMinimised(std::vector<std::vector<Node*>>& Groups) {
        std::vector<bool> visited(Nodes.size(), false);
        for (int idx = 0; idx < Nodes.size(); ++idx) {
            if (!visited[idx]) {
                std::string node_name;
                for (auto& grp : Groups) {
                    if (std::find(grp.begin(), grp.end(), &Nodes[idx]) != grp.end()) {
                        for (auto& n : grp) {
                            int i = std::distance(Nodes.begin(), std::find(Nodes.begin(), Nodes.end(), n));
                            visited[i] = true;
                            node_name += n->name;
                        }
                    }
                }
                std::cout << node_name << std::endl;
            }
        }

        for (auto& grp : Groups) {
            std::string node_name;
            for (auto& n : grp) {
                node_name += n->name;
            }
            Node* node = grp[0];
            std::string node_A, node_B;
            for (auto& grp2 : Groups) {
                if (std::find(grp2.begin(), grp2.end(), node->A) != grp2.end()) {
                    for (auto& n : grp2) {
                        node_A += n->name;
                    }
                }
                if (std::find(grp2.begin(), grp2.end(), node->B) != grp2.end()) {
                    for (auto& n : grp2) {
                        node_B += n->name;
                    }
                }
            }
            std::cout << node_name << " " << node_A << " a" << std::endl;
            std::cout << node_name << " " << node_B << " b" << std::endl;
        }
    }
    void minimised() {
        remove_unreachable();
        std::vector<std::vector<Node*>> Groups;
        Groups.push_back(std::vector<Node*>()); // Group-0 for non-final states
        Groups.push_back(std::vector<Node*>()); // Group-1 for final states
        for (auto& node : Nodes) {
            if (!node.isFinal)
                Groups[0].push_back(&node);
            else
                Groups[1].push_back(&node);
        }
        Groups = findEquivalence(Groups);
        printMinimised(Groups);
    }
private:
    std::vector<Node> Nodes;
    bool StartFound;
};

int main() {
    int total_states, final_states, transitions;
    std::cin >> total_states >> final_states >> transitions;

    DFA dfa;

    std::string name;
    bool start, final;
    std::cin >> name >> start >> final;
    dfa.addNode(name, start, final);
    dfa.getNode(name).second->reachable = true;

    for (int i = 0; i < final_states; ++i) {
        std::cin >> name >> start >> final;
        dfa.addNode(name, start, final);
    }

    for (int i = 0; i < total_states - final_states - 1; ++i) {
        std::cin >> name >> start >> final;
        dfa.addNode(name, start, final);
    }

    std::string q1, q2, alpha;
    for (int i = 0; i < transitions; ++i) {
        std::cin >> q1 >> q2 >> alpha;
        auto [_, node1] = dfa.getNode(q1);
        auto [__, node2] = dfa.getNode(q2);
        if (alpha == "a") {
            node1->addTransition_A(node2);
            node2->reachable = true;
        }
        else if (alpha == "b") {
            node1->addTransition_B(node2);
            node2->reachable = true;
        }
        else {
            std::cout << "Input not stated or Input doesn't belong to {a,b}" << std::endl;
        }
    }

    dfa.minimised();

    return 0;
}
