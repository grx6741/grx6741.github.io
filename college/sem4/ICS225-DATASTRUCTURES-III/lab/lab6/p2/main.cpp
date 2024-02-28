#include <iostream>
using namespace std;

struct Node {
    int data;
    Node *left, *right;
    bool leftThread, rightThread;
};

Node* createNode(int data) {
    Node* newNode = new Node();
    newNode->data = data;
    newNode->left = nullptr;
    newNode->right = nullptr;
    newNode->leftThread = false;
    newNode->rightThread = false;
    return newNode;
}

Node* inOrderSuccessor(Node* node) {
    if (node->rightThread || node->right == nullptr)
        return node->right;
    
    node = node->right;
    while (!node->leftThread && node->left != nullptr)
        node = node->left;
    return node;
}

void inOrder(Node* root) {
    Node* current = root;
    while (current->left != nullptr)
        current = current->left;

    while (current != nullptr) {
        cout << current->data << " ";
        current = inOrderSuccessor(current);
    }
    cout << endl;
}

void insert(Node* &root, int key) {
    if (root == nullptr) {
        root = createNode(key);
        return;
    }

    Node* current = root;
    while (true) {
        if (key < current->data) {
            if (!current->leftThread && current->left != nullptr)
                current = current->left;
            else {
                Node* newNode = createNode(key);
                newNode->left = current->left;
                newNode->right = current;
                newNode->leftThread = current->leftThread;
                newNode->rightThread = true;
                current->left = newNode;
                current->leftThread = false;
                return;
            }
        } else {
            if (!current->rightThread && current->right != nullptr)
                current = current->right;
            else {
                Node* newNode = createNode(key);
                newNode->left = current;
                newNode->right = current->right;
                newNode->leftThread = true;
                newNode->rightThread = current->rightThread;
                current->right = newNode;
                current->rightThread = false;
                return;
            }
        }
    }
}

int main() {
    Node* root = nullptr;

    insert(root, 50);
    insert(root, 105);
    insert(root, 145);
    insert(root, 165);
    insert(root, 175);
    insert(root, 205);
    insert(root, 305);

    insert(root, 155);

    cout << "(numbers)---";
    inOrder(root);

    return 0;
}
