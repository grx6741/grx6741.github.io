#include <iostream>
#include <vector>

enum class Movement { LEFT, RIGHT };

class Node {
public:
    int val;
    Node* left;
    Node* right;

    Node(int val) : val(val), left(nullptr), right(nullptr) {}

    ~Node() {
        delete left;
        delete right;
    }

    void insert(int val) {
        if (val < this->val) {
            if (left) {
                left->insert(val);
            } else {
                left = new Node(val);
            }
        } else {
            if (right) {
                right->insert(val);
            } else {
                right = new Node(val);
            }
        }
    }

    void inorder() {
        if (left) {
            left->inorder();
        }
        std::cout << val << " ";
        if (right) {
            right->inorder();
        }
    }
};

class Splay {
public:
    static Node* zig(Node* p, Node* x) {
        if (!p || !x) return nullptr;
        p->left = x->right;
        x->right = p;
        return x;
    }

    static Node* zag(Node* p, Node* x) {
        if (!p || !x) return nullptr;
        p->right = x->left;
        x->left = p;
        return x;
    }

    static Node* zigzig(Node* g, Node* p, Node* x) {
        return zig(zig(g, p), x);
    }

    static Node* zagzag(Node* g, Node* p, Node* x) {
        return zag(zag(g, p), x);
    }

    static Node* zigzag(Node* g, Node* p, Node* x) {
        if (!g || !p || !x) return nullptr;
        g->left = zag(p, x);
        return zig(g, x);
    }

    static Node* zagzig(Node* g, Node* p, Node* x) {
        if (!g || !p || !x) return nullptr;
        g->right = zig(p, x);
        return zag(g, x);
    }

    static Node* insert(Node* root, int val) {
        if (!root) return nullptr;
        root->insert(val);
        root = find(root, val);
        return root;
    }

    static std::vector<Node*> split(Node* root, int k) {
        root = find(root, k);
        if (!root) return {};
        return {root->left, root->right};
    }

    static Node* join(Node* left, Node* right) {
        if (!left) return right;
        Node* max = left;
        while (max->right) {
            max = max->right;
        }
        left = find(left, max->val);
        if (!left) return nullptr;
        left->right = right;
        return left;
    }

    static Node* delete_node(Node* root, int val) {
        if (!root) return nullptr;
        root = find(root, val);
        if (!root) return nullptr;
        root = join(root->left, root->right);
        return root;
    }

    static Node* find(Node* root, int val, int i = 0) {
        i++;
        if (!root) return nullptr;
        Movement d1 = Movement::LEFT;
        Movement d2 = Movement::LEFT;
        if (root->val == val) {
            return root;
        }
        Node* g = root;
        Node* p;
        if (g->val < val) {
            p = g->right;
            d1 = Movement::RIGHT;
        } else {
            p = g->left;
            d1 = Movement::LEFT;
        }
        if (!p) return nullptr;
        if (p->val == val) {
            if (d1 == Movement::LEFT) {
                g = zig(g, p);
                return g;
            } else {
                g = zag(g, p);
                return g;
            }
        }
        Node* x;
        if (p->val < val) {
            x = p->right;
            d2 = Movement::RIGHT;
        } else {
            x = p->left;
            d2 = Movement::LEFT;
        }

        if (!x) return nullptr;

        if (p->val != val && x->val != val) {
            x = find(x, val, i);
            if (!x) return nullptr;
        }

        if (x->val == val) {
            if (d1 == Movement::LEFT) {
                if (d2 == Movement::LEFT) {
                    g = zigzig(g, p, x);
                    return g;
                } else {
                    g = zigzag(g, p, x);
                    return g;
                }
            } else {
                if (d2 == Movement::LEFT) {
                    g = zagzig(g, p, x);
                    return g;
                } else {
                    g = zagzag(g, p, x);
                    return g;
                }
            }
        }
        return nullptr;
    }
};

int main() {
    Node* tree = new Node(22);
    std::vector<int> vals = {10, 30, 6, 18, 27, 9, 15, 19, 12, 14};
    for (int val : vals) {
        tree = Splay::insert(tree, val);
    }

    tree->inorder();
    std::cout << std::endl;

    // tree = Splay::delete_node(tree, 22); // To delete
    tree = Splay::find(tree, 22); // To bring it to top
    // tree = Splay::insert(tree, 69); // To Insert and bring it to top

    if (tree) tree->inorder();
    std::cout << std::endl;

    if (tree) std::cout << tree->val << std::endl;

    delete tree;

    return 0;
}
