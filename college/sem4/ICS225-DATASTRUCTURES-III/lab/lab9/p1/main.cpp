#include <iostream>
#include <vector>

enum mode {
    LEFT = 0,
    RIGHT
};

struct node {
    int data;
    node* left;
    node* right;

    node(int val) : data{val} {}
    node() {}

    static node* zig(node* p) {
        node* x = p->left;
        p->left = x->right;
        x->right = p;
        return x;
    }
    static node* zag(node* p) {
        node* x = p->right;
        p->right = x->left;
        x->left = p;
        return x;
    }

    static node* zigzig(node* g) {
        return zig(zig(g));
    }
    static node* zagzag(node* g) {
        return zag(zag(g));
    }
    static node* zagzig(node* g) {
        node* p = g->right;
        g->right = zig(p);
        return zag(g);
    }
    static node* zigzag(node* g) {
        node* p = g->left;
        g->left = zag(p);
        return zig(g);
    }

    static node* insert(node* root, int val) {
        if (root == nullptr) {
            root = new node;
            root->data = val;
            return root;
        }
        if (val > root->data) 
            root->right = insert(root->right, val);
        else 
            root->left = insert(root->left, val);
        return root;
    }

    static void inorder(node* root) {
        if (root == nullptr) return;
        inorder(root->left);
        std::cout << root->data << " ";
        inorder(root->right);
    }

    static node* find(node* g, int val) {
        if (g == nullptr) return nullptr;
        mode d1, d2;

        node* p;
        if (val > g->data) {
            p = g->right;
            d1 = RIGHT;
        } else {
            p = g->left;
            d1 = LEFT;
        }
        if (p == nullptr) return nullptr;

        if (p->data != val) {
            node* x;
            if (val > p->data) {
                x = p->right;
                d2 = RIGHT;
            } else {
                x = p->left;
                d2 = LEFT;
            }
            if (x == nullptr) return nullptr;

            if (x->data != val)
                x = node::find(x, val);

            if (d1 == LEFT && d2 == LEFT) {
                g = node::zigzig(g);
            } else if (d1 == RIGHT && d2 == RIGHT) {
                g = node::zagzag(g);
            } else if (d1 == LEFT && d2 == RIGHT) {
                g = node::zigzag(g);
            } else if (d1 == RIGHT && d2 == LEFT) {
                g = node::zagzig(g);
            }
        } else {
            if (d1 == LEFT) {
                g = node::zig(g);
            } else if (d1 == RIGHT) {
                g = node::zag(g);
            }
        }
        return g;
    }
};

int main() {
    node* root = new node;
    root->data = 6;
    std::vector<int> inputs = {1, 9, 4, 7, 2};

    for (int a : inputs) 
        node::insert(root, a);

    node::insert(root, 5);

    node::inorder(root);
    std::cout << std::endl;

    root = node::find(root, 5);
}
