#include <iostream>
#include <vector>

template<typename T>
class Graph {
    private:
        std::vector<T> adjacency;
    public:
        Graph(int n) {
            this->adjacency = std::vector<T>(n);
        }

        void addNode(T from, T to) {
            this->adjacency[from] = to;
        }

        void print() {
            for (T from : this->adjacency) {

            }
        }
};

int main() {
    std::cout << "Hello World" << std::endl;
    Graph<int> g(10);
    g.addNode(5, 10);
}
