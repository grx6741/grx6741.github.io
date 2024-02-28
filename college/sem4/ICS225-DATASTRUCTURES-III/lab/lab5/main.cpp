#include <iostream>
#include <climits>
#include <vector>

using namespace std;

class knapsack {
public:
    int no_of_weights;
    int max_capacity;
    vector<int> weights;
    vector<int> costs;

    knapsack(int n, int m) {
        weights = vector<int>(n);
        costs = vector<int>(n);

        no_of_weights = n;
        max_capacity = m;

        for (int i = 0; i < no_of_weights; i++) {
            cin >> weights[i];
        }

        for (int i = 0; i < no_of_weights; i++) {
            cin >> costs[i];
        }
    }

    void calculate_u_and_c(int& u, int& c, vector<int> exclude) {
        int curr_weight = 0;
        int upper = 0;
        int cost = 0;
        for (int i = 0; i < weights.size(); i++) {
            if (exclude.find
            int rem_weight = max_capacity - curr_weight;
            if (rem_weight >= weights[i]) {
                curr_weight += weights[i];
                upper += costs[i];
            } else {
                cost = upper + (costs[i] / weights[i]) * rem_weight;
            }
        }

        u = upper;
        c = cost;
    }
};


int main() {
    int no_of_weights, max_capacity;
    cin >> no_of_weights >> max_capacity;

    knapsack ks(no_of_weights, max_capacity);

    int upper = INT_MAX;

    for (int i = 0; i < no_of_weights) {
        int u, c;
        ks.calculate_u_and_c(u, c, -1);
    }

    cout << u << " " << c << endl;
}
