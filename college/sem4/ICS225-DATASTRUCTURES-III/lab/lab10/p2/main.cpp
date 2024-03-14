#include <iostream>
#include <queue>
#include <vector>

class graph {
public:
    std::vector<std::vector<int>> neighbours;
    std::vector<int> indegrees;

    graph(int size) {
        neighbours = std::vector<std::vector<int>>(size + 1);
        indegrees = std::vector<int>(size + 1, 0);
    }

    void add_edge(int n1, int n2) {
        neighbours[n1].push_back(n2);
        indegrees[n2]++;
    }

    std::vector<int> get_neighbours(int n1) {
        return neighbours[n1];
    }

    void print() {
        for (int i = 0; i < neighbours.size(); i++) {
            std::vector<int> a = neighbours[i];
            std::cout << "[" << i << "]\t";
            for (int b : a) {
                std::cout << b << " ";
            }
            std::cout << std::endl;
        }
    }

    std::queue<int> indeg_0s() {
        std::queue<int> q;
        for (int i = 0; i < indegrees.size(); i++) {
            if (indegrees[i] == 0 && i != 0) {
                q.push(i);
            }
        }
        return q;
    }
};

int main() {
    graph g(8);
    g.add_edge(1, 3);
    g.add_edge(1, 4);
    g.add_edge(1, 5);
    g.add_edge(2, 3);
    g.add_edge(2, 8);
    g.add_edge(3, 6);
    g.add_edge(4, 6);
    g.add_edge(4, 8);
    g.add_edge(5, 8);
    g.add_edge(6, 7);
    g.add_edge(7, 8);

    std::queue<int> zeroes = g.indeg_0s();

    while (zeroes.size()) {
        int curr = zeroes.front();
        zeroes.pop();
        std::cout << curr << " ";

        std::vector<int> ns = g.get_neighbours(curr);

        g.indegrees[curr] = -1;
        for (int n : ns) {
            g.indegrees[n]--;
            if (g.indegrees[n] == 0)
                zeroes.push(n);
        }
    }
}
