#include <iostream>

using namespace std;

struct Node 
{
    int data;
    struct Node *left, *right;
    bool rightThread;  
};

Node* leftMost(Node* n){
    if (n == nullptr)
        return nullptr;
 
    while (n->left != nullptr)
        n = n->left;
 
    return n;
}

Node* createNode(int data) {
    Node* newNode = new Node();
    newNode->data = data;
    newNode->left = nullptr;
    newNode->right = nullptr;
    newNode->rightThread = false;
    return newNode;
}

void addNode(Node* &root, int data) {
    if (root == nullptr)
        root = createNode(data);
    else {
        Node* current = root;
        while (true) {
            if (data < current->data) {
                if (current->left == nullptr) {
                    current->left = createNode(data);
                    break;
                } else {
                    current = current->left;
                }
            } else {
                if (current->right == nullptr) {
                    current->right = createNode(data);
                    current->rightThread = true;
                    break;
                } else {
                    current = current->right;
                }
            }
        }
    }
}

void inOrder(Node* root){
    Node* cur = leftMost(root);
    while (cur != nullptr) {
        cout << cur->data << " ";
 
        if (cur->rightThread)
            cur = cur->right;
        else
            cur = leftMost(cur->right);
    }
}

int main() {
    Node* root = nullptr;
    addNode(root, 1);
    addNode(root, 2);
    addNode(root, 3);
    addNode(root, 4);
    addNode(root, 5);
    addNode(root, 6);
    addNode(root, 7);
    addNode(root, 8);
    addNode(root, 9);
    addNode(root, 10);

    inOrder(root);
    cout << endl;

    return 0;
}
