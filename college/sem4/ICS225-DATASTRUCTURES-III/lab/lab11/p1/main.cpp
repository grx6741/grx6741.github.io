#include <iostream>
#include <vector>
#include <algorithm>

class Head {
public:
    int degree;
    int val;
    
    Head(int d, int v) : degree(d), val(v) {}
};

bool compareDegrees(const Head& h1, const Head& h2) {
    return h1.degree < h2.degree;
}

int main() {
    std::vector<Head> h1 = {Head(0, 12), Head(1, 7), Head(2, 15)};
    std::vector<Head> h2 = {Head(0, 18), Head(1, 3), Head(4, 6)};

    std::vector<Head> h12;
    h12.reserve(h1.size() + h2.size());
    h12.insert(h12.end(), h1.begin(), h1.end());
    h12.insert(h12.end(), h2.begin(), h2.end());

    std::sort(h12.begin(), h12.end(), compareDegrees);

    // for (const auto& h : h12) {
    //     std::cout << h.degree << " " << h.val << std::endl;
    // }
    // std::cout << std::endl;

    int i = 0;
    while (i < h12.size() - 1) {
        if (h12[i].degree == h12[i + 1].degree) {
            if (i + 2 < h12.size() && h12[i + 1].degree == h12[i + 2].degree) {
                i += 1;
                continue;
            }

            int max_head_i = (h12[i].val > h12[i + 1].val) ? i : (i + 1);
            int min_head_i = (h12[i].val < h12[i + 1].val) ? i : (i + 1);
            h12[min_head_i].degree += 1;
            h12.erase(h12.begin() + max_head_i);
        } else {
            i += 1;
        }
    }

    for (const auto& h : h12) {
        std::cout << h.degree << std::endl;
    }

    for (const auto& h : h12) {
        std::cout << h.val << " ";
    }

    return 0;
}
