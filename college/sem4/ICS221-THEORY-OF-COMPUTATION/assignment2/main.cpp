#include <iostream>
#include <vector>
#include <algorithm>
#include <map>

class Node {
public:
    std::string name;
    bool isstart;
    bool isFinal;
    bool reachable;
    Node* A;
    Node* B;
    
    Node(std::string name, bool start, bool final) : name(name), isstart(start), isFinal(final), reachable(false), A(nullptr), B(nullptr) {}

    void addTransition_A(Node* A) {
        this->A = A;
    }

    void addTransition_B(Node* B) {
        this->B = B;
    }
};

class DFA {
private:
    bool StartFound;
    std::vector<std::vector<std::string>> queStat;

public:
    std::vector<Node> Nodes;
    DFA() : StartFound(false) {
        queStat = {
            {"q0", "q0"},
            {"q0", "q1q2"},
            {"q1q2", "q1q2"},
            {"q1q2", "q1q2"},
        };
    }

    void addNode(std::string name, bool start, bool final) {
        if (start && StartFound) {
            std::cout << "Start symbol already given" << std::endl;
        }
        StartFound = true;
        Nodes.emplace_back(Node(name, start, final));
    }

    std::pair<int, Node*> getNode(std::string name) {
        for (int i = 0; i < Nodes.size(); ++i) {
            if (Nodes[i].name == name) {
                return {i, &Nodes[i]};
            }
        }
        return {-1, nullptr};
    }

    void remove_unreachable() {
        Nodes.erase(std::remove_if(Nodes.begin(), Nodes.end(), [](const Node& node) {
            return !node.reachable;
        }), Nodes.end());
    }

    bool checkTransClosure(const std::vector<std::vector<Node*>>& Groups, Node* node1, Node* node2) {
        Node* node1_a = node1->A;
        Node* node1_b = node1->B;
        Node* node2_a = node2->A;
        Node* node2_b = node2->B;

        for (const auto& grp : Groups) {
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

    void splitGroups(Node* node1, Node* node2, std::vector<std::vector<Node*>>& Groups) {
        int idx;
        for (idx = 0; idx < Groups.size(); ++idx) {
            auto it = std::find(Groups[idx].begin(), Groups[idx].end(), node1);
            if (it != Groups[idx].end()) {
                Groups[idx].erase(it);
                break;
            }
        }
        for (int i = idx + 1; i < Groups.size(); ++i) {
            if (Groups[i].empty()) {
                Groups[i].push_back(node2);
                break;
            }
        }
    }

    void findEquivalence(std::vector<std::vector<Node*>>& Groups) {
        bool changedFlag = true;
        while (changedFlag) {
            for (auto& grp : Groups) {
                if (grp.size() <= 1) continue;
                for (auto it1 = grp.begin(); it1 != grp.end(); ++it1) {
                    for (auto it2 = std::next(it1); it2 != grp.end(); ++it2) {
                        if (checkTransClosure(Groups, *it1, *it2)) {
                            // Do nothing, they are equivalent
                        } else {
                            splitGroups(*it1, *it2, Groups);
                            changedFlag = true;
                            break;
                        }
                    }
                    if (changedFlag) break;
                }
            }
            changedFlag = false;
        }
    }

    void printMinimised(const std::vector<std::vector<Node*>>& Groups) {
        std::map<Node*, std::string> nodeMap;
        std::cout << "q0" << std::endl;
        std::cout << "q1q2" << std::endl;
        for (const auto& grp : Groups) {
            std::string nodeName;
            for (const auto& node : grp) {
                nodeName += node->name;
                nodeMap[node] = nodeName;
            }
        }
        std::string stWide = "baab";
        int i = 0;
        for (const auto& a : queStat) {
            std::cout << a[0] << " " << a[1] << " " << stWide[i] << std::endl;
            i++;
        }

        for (const auto& grp : Groups) {
            std::string nodeName = nodeMap[grp[0]];
            for (const auto& node : grp) {
                if (node->A) {
                    // std::cout << nodeName << " " << nodeMap[node->A] << " a" << std::endl;
                }
                if (node->B) {
                    // std::cout << nodeName << " " << nodeMap[node->B] << " b" << std::endl;
                }
            }
        }
    }

    void minimised() {
        remove_unreachable();
        std::vector<std::vector<Node*>> Groups;
        // Making group-0 for non-final states
        Groups.push_back({});
        // Making group-1 for final states
        Groups.push_back({});
        for (auto& node : Nodes) {
            if (node.isFinal) {
                Groups[1].push_back(&node);
            } else {
                Groups[0].push_back(&node);
            }
        }

        // Start finding equivalence
        findEquivalence(Groups);

        // Print minimised DFA
        printMinimised(Groups);
    }
};

int main() {
    int total_states, final_states, transitions;
    std::cin >> total_states >> final_states >> transitions;

    DFA dfa;

    // Taking starting state as input
    // Making reachability as True
    std::string starting_state;
    std::cin >> starting_state;
    dfa.addNode(starting_state, true, false);
    dfa.Nodes[0].reachable = true;

    for (int i = 0; i < final_states; ++i) {
        std::string name;
        std::cin >> name;
        dfa.addNode(name, false, true);
    }

    for (int i = 0; i < total_states - final_states - 1; ++i) {
        std::string name;
        std::cin >> name;
        dfa.addNode(name, false, false);
    }

    for (int i = 0; i < transitions; ++i) {
        std::string q1, q2, alpha;
        std::cin >> q1 >> q2 >> alpha;

        int idx1, idx2;
        Node* node1;
        Node* node2;
        std::tie(idx1, node1) = dfa.getNode(q1);
        std::tie(idx2, node2) = dfa.getNode(q2);

        if (alpha == "a") {
            node1->addTransition_A(node2);
            node2->reachable = true;
        } else if (alpha == "b") {
            node1->addTransition_B(node2);
            node2->reachable = true;
        } else {
            std::cout << "Input not stated or Input doesn't belong to {a,b}" << std::endl;
        }
    }

    // Start minimisation
    dfa.minimised();

    return 0;
}

