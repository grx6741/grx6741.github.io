#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

#define MAX_STATES 100
#define MAX_NAME_LENGTH 100

typedef struct Node {
    char name[MAX_NAME_LENGTH];
    bool is_start;
    bool is_final;
    bool reachable;
    struct Node *A;
    struct Node *B;
} Node;

typedef struct DFA {
    Node *nodes[MAX_STATES];
    bool start_found;
    int num_nodes;
} DFA;

Node *create_node(const char *name, bool is_start, bool is_final) {
    Node *node = malloc(sizeof(Node));
    if (node == NULL) {
        perror("Memory allocation error");
        exit(EXIT_FAILURE);
    }
    strncpy(node->name, name, MAX_NAME_LENGTH - 1);
    node->name[MAX_NAME_LENGTH - 1] = '\0';
    node->is_start = is_start;
    node->is_final = is_final;
    node->reachable = false;
    node->A = NULL;
    node->B = NULL;
    return node;
}

void add_transition_A(Node *node, Node *A) {
    node->A = A;
    A->reachable = true;
}

void add_transition_B(Node *node, Node *B) {
    node->B = B;
    B->reachable = true;
}

void add_node(DFA *dfa, const char *name, bool is_start, bool is_final) {
    if (is_start && dfa->start_found) {
        printf("Start symbol already given\n");
        return;
    }
    dfa->start_found = true;
    Node *node = create_node(name, is_start, is_final);
    dfa->nodes[dfa->num_nodes++] = node;
}

Node *get_node(DFA *dfa, const char *name) {
    for (int i = 0; i < dfa->num_nodes; i++) {
        if (strcmp(dfa->nodes[i]->name, name) == 0)
            return dfa->nodes[i];
    }
    return NULL;
}

void remove_unreachable(DFA *dfa) {
    for (int i = 0; i < dfa->num_nodes; i++) {
        if (!dfa->nodes[i]->reachable) {
            free(dfa->nodes[i]);
            dfa->nodes[i] = NULL;
        }
    }
    int j = 0;
    for (int i = 0; i < dfa->num_nodes; i++) {
        if (dfa->nodes[i] != NULL) {
            dfa->nodes[j++] = dfa->nodes[i];
        }
    }
    dfa->num_nodes = j;
}

bool check_trans_closure(Node **groups, int num_groups, Node *node1, Node *node2) {
    // Implementation needed
}

Node **split_groups(Node **groups, int *num_groups, Node *node1, Node *node2) {
    // Implementation needed
}

Node ***find_equivalence(Node **groups, int *num_groups) {
    // Implementation needed
}

void print_minimised(DFA *dfa, Node **groups, int num_groups) {
    // Implementation needed
}

void minimised(DFA *dfa) {
    // Implementation needed
}

void free_dfa(DFA *dfa) {
    for (int i = 0; i < dfa->num_nodes; i++) {
        free(dfa->nodes[i]);
    }
}

int main() {
    int total_states, final_states, transitions;
    scanf("%d%d%d", &total_states, &final_states, &transitions);

    DFA dfa;
    dfa.start_found = false;
    dfa.num_nodes = 0;

    for (int i = 0; i < total_states; i++) {
        char name[MAX_NAME_LENGTH];
        bool is_start, is_final;
        scanf("%s %d %d", name, &is_start, &is_final);
        add_node(&dfa, name, is_start, is_final);
    }

    for (int i = 0; i < transitions; i++) {
        char q1[MAX_NAME_LENGTH], q2[MAX_NAME_LENGTH], alpha;
        scanf("%s %s %c", q1, q2, &alpha);

        Node *node1 = get_node(&dfa, q1);
        Node *node2 = get_node(&dfa, q2);
        if (node1 && node2) {
            if (alpha == 'a')
                add_transition_A(node1, node2);
            else if (alpha == 'b')
                add_transition_B(node1, node2);
            else
                printf("Input not stated or Input doesn't belong to {a, b}\n");
        }
    }

    minimised(&dfa);
    free_dfa(&dfa);

    return 0;
}

