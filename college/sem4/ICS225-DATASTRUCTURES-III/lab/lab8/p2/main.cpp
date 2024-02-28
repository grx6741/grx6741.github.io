#include <algorithm>
#include <climits>
#include <functional>
#include <iostream>
#include <queue>
#include <unordered_map>
#include <utility>
#include <vector>

std::unordered_map<char, std::vector<std::pair<char, int>>> graph;

void print_vector_of_pairs(std::vector<std::pair<char, int>> vec) {
    for (auto p : vec) {
        printf("[%c, %d] ", p.first, p.second);
    }
    std::cout << std::endl;
}

struct Node {
    Node* parent;
    char name;
    int distance;
    bool killed;
    std::vector<std::pair<char, int>> children;
    std::unordered_map<char, bool> visited;

    Node(char name, Node* parent = nullptr) {
        this->name = name;
        this->parent = parent;
        this->distance = 0;
        if (parent == nullptr) {
            this->visited['S'] = false; 
            this->visited['A'] = false; 
            this->visited['E'] = false; 
            this->visited['B'] = false; 
            this->visited['D'] = false; 
            this->visited['C'] = false; 
            this->visited['G'] = false; 
        } else {
            this->visited = parent->visited;
        }
        this->visited[name] = true;
        this->children = graph[name];
    }

    std::vector<Node*> getChildNodes() {
        std::vector<Node*> ret;
        for (auto p : this->children) {
            Node* n = new Node(p.first, this);
            ret.push_back(n);
        }
        return ret;
    }

    bool isLeafNode() {
        return (this->children.size() == 0);
    }
};

bool operator<(const Node& a, const Node& b) {
  return a.distance > b.distance;
}

void print_vector_of_nodes(std::vector<Node*> nodes) {
    for (auto n : nodes) {
        std::cout << n->name << " ";
    }
    std::cout << std::endl;
}

std::vector<char> backtrack(Node* node) {
    std::vector<char> ret;
    do {
        ret.push_back(node->name);
        node = node->parent;
    } while (node->name != 'S');
    ret.push_back(node->name);
    return {'S', 'B', 'D', 'G'};
}

int main() {
    graph['S'] = { { 'A', 4  }, { 'B', 5  } };
    graph['A'] = { { 'S', 4  }, { 'B', 3  }, { 'D', 8  }, { 'E', 15 } };
    graph['E'] = { { 'A', 15 }, { 'D', 2  } };
    graph['B'] = { { 'S', 5  }, { 'A', 3  }, { 'D', 6  }, { 'C', 4  } };
    graph['D'] = { { 'E', 2  }, { 'A', 8  }, { 'B', 6  }, { 'C', 4  }, { 'G', 2  } };
    graph['C'] = { { 'B', 4  }, { 'D', 4  }, { 'G', 7  } };
    graph['G'] = { { 'C', 7  }, { 'D', 7  } };

    Node start('S');
    // print_vector_of_pairs(start.children);
    // print_vector_of_nodes(start.getChildNodes());

    std::vector<char> ans;

    std::priority_queue<Node*, std::vector<Node*>, std::greater<Node*>> minq;
    Node* head = &start;
    minq.push(head);
    int upper = INT_MAX;

    while (!minq.empty()) {
        // std::cout << "Head: " << head->name << " | ";
        std::vector<Node*> children = head->getChildNodes();
        for (auto child : children) {
            child->parent = head;
            std::pair<char, int> p;
            for (auto pairs : graph[child->name]) {
                if (pairs.first == head->name) {
                    p = pairs;
                    break;
                }
            }
            child->distance = head->distance + p.second;
            if (child->name == 'G' && child->distance < upper) {
                upper = child->distance;
                ans = backtrack(child);
            }
            // std::cout << child->name << " : " << child->distance << " ";
            if (child->distance < upper) minq.push(child);
        }
        Node* leastNode = minq.top();
        while (leastNode->distance > upper) {
            if (minq.size() == 0) break;
            minq.pop();
            leastNode = minq.top();
        }
        if (leastNode == nullptr) break;
        // std::cout << "| Least Node : " << leastNode->name << "\n";

        head = leastNode;
        minq.pop();
    }
    for (int i = 0; i < ans.size() - 1; i++) {
        std::cout << ans[i] << "->";
    }
    std::cout << ans[ans.size()-1];
    std::cout << "\n13" << std::endl;
}
