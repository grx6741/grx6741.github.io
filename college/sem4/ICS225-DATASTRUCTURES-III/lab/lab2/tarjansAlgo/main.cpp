#include <iostream>
#include <vector>
#include <stack>
#include <climits>

template<int T>
class Graph {
public:
    std::vector<std::vector<int>> nodes;
    std::vector<int> indices;
    std::vector<int> lowlinks;
    std::vector<bool> onStack;
    int indexCounter;

    Graph() {
        this->nodes = std::vector<std::vector<int>>(T);
        this->indices = std::vector<int>( T, INT_MAX);
        this->lowlinks = std::vector<int>(T, INT_MAX);
        this->onStack = std::vector<bool>(T, false);

        indexCounter = 0;
    }

    void addNode(int parent, int child) {
        this->nodes[parent].push_back(child);
    }

    std::vector<int> getNeighbours(int node) {
        return this->nodes[node];
    }

    void printNode() {
        for (int i = 0; i < this->nodes.size(); i++) {
            std::cout << i << ": ";
            for (int j = 0; j < this->nodes[i].size(); j++) {
                std::cout << this->nodes[i][j] << " ";
            }
            std::cout << std::endl;
        }
    }

    void tarjan() {
        std::stack<int> S;
        this->indexCounter = 0;
        for (int v = 0; v < T; v++) {
            if (indices[v] == INT_MAX) {
                this->strongConnect(v, S);
            }
        }
    }

private:
    void strongConnect(int v, std::stack<int>& S) {
        indices[v] = indexCounter;
        lowlinks[v] = indexCounter;

        indexCounter++;

        S.push(v);
        onStack[v] = true;

        std::vector<int> neighbours = this->getNeighbours(v);

        for (int w : neighbours) {
            if (indices[w] == INT_MAX) {
                this->strongConnect(w, S);
                lowlinks[v] = std::min(lowlinks[v], lowlinks[w]);
            } else if (onStack[w]) {
                lowlinks[v] = std::min(lowlinks[v], indices[w]);
            }
        }

        if (lowlinks[v] == indices[v]) {
            std::vector<int> scc;
            int w = S.top();
            S.pop();
            do {
                onStack[w] = false;
                scc.push_back(w);
                w = S.top();
                S.pop();
            } while (w != v);
            scc.push_back(w);

            for (int i = 0; i < scc.size(); i++) {
                std::cout << scc[i] << " ";
            }
            std::cout << std::endl;
        }
    }
};

int main() {
    Graph<8> g;

    g.addNode(0, 1);
    g.addNode(0, 2);
    g.addNode(1, 3);
    g.addNode(2, 5);
    g.addNode(2, 6);
    g.addNode(3, 4);
    g.addNode(4, 1);
    g.addNode(5, 1);
    g.addNode(5, 7);
    g.addNode(6, 5);
    g.addNode(7, 2);

    g.printNode();

    std::cout << "\"SCCs in given graph\"" << std::endl;
    g.tarjan();

}
