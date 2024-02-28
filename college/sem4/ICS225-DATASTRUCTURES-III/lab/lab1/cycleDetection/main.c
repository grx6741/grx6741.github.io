#include <stdio.h>
#include <stdint.h>
#include <stdlib.h>
#include <stdbool.h>
#include <assert.h>

typedef struct {
    uint32_t nodes_count;
    int** adjacency_mat;
    bool directional;
} Graph;

Graph* create_graph(uint32_t count, bool directional) {
    Graph* g = (Graph*)malloc(sizeof(Graph));
    g->nodes_count = count;

    int** nodes_row = (int**)malloc(sizeof(int*) * count);

    for (int i = 0; i < count; i++) {
        nodes_row[i] = (int*)malloc(sizeof(int*) * count);
        for (int j = 0; j < count; j++) {
            nodes_row[i][j] = 0;
        }
    }

    g->adjacency_mat = nodes_row;
    g->directional = directional;
    return g;
}

void print_graph(Graph* g) {
    int n = g->nodes_count;

    printf("\t");
    for (int i = 0; i < n; i++) {
        printf("%d\t", i);
    }
    printf("\n");

    for (int i = 0; i < n; i++) {
        printf("%d: ", i);
        for (int j = 0; j < n; j++) {
            printf("\t%d", g->adjacency_mat[i][j]);
        }
        printf("\n");
    }
}

void add_node(Graph* g, int node1, int node2) {
    g->adjacency_mat[node1][node2] = 1;
    if (!g->directional)
        g->adjacency_mat[node2][node1] = 1;
}

int get_neighbours(Graph* g, int node, int** neighbours) {
    int n = g->nodes_count;
    int count = 0;
    for (int i = 0; i < n; i++) {
        if (g->adjacency_mat[node][i])
            count++;
    }
    *neighbours = (int*)malloc(sizeof(int*) * count);

    int j = 0;
    for (int i = 0; i < n; i++) {
        if (g->adjacency_mat[node][i]) {
            (*neighbours)[j] = i;
            j++;
        }
    }

    return count;
}

typedef struct {
    int* vals;
    int top;
    int max_size;
} Stack;

Stack* create_stack(int max_size) {
    Stack* s = (Stack*) malloc(sizeof(Stack));
    s->top = -1;
    s->max_size = max_size;
    s->vals = (int*)malloc(sizeof(int) * max_size);

    return s;
}

bool push_stack(Stack* s, int node) {
    if (s->top + 1 < s->max_size) {
        s->top++;
        s->vals[s->top] = node;
        return true;
    }
    return false;
}

bool pop_stack(Stack* s, int* node) {
    if (s->top > -2) {
        *node = s->vals[s->top];
        s->top--;
        return true;
    }
    return false;
}

void print_stack(Stack* s) {
    if (s->top < 0) return;
    for (int i = 0; i < s->top + 1; i++) {
        printf("%d, ", s->vals[i]);
    }
    printf("\n");
}

int get_size_stack(Stack* s) {
    return s->top + 1;
}

int dfs(Graph* g, int start, int** trace_back) {
    Stack* s = create_stack(g->nodes_count);

    bool visited_nodes[g->nodes_count];
    int prev_node[g->nodes_count];

    for (int i = 0; i < g->nodes_count; i++) {
        prev_node[i] = -1;
    }

    push_stack(s, start);
    while (get_size_stack(s) > 0) {
        int node;
        pop_stack(s, &node);
        // printf("%d ", node);
        if (!visited_nodes[node]) {
            visited_nodes[node] = true;
            int* neighbours;
            int neighbours_count = get_neighbours(g, node, &neighbours);
            for (int i = 0; i < neighbours_count; i++) {
                if (prev_node[node] != neighbours[i])
                    prev_node[neighbours[i]] = node;
                push_stack(s, neighbours[i]);
            }
        } else {
            int curr = node;
            int count = 0;
            // printf("%d ", curr);
            do {
                curr = prev_node[curr];
                count++;
                // printf("%d ", curr);
            } while (curr != node);

            *trace_back = (int*) malloc(sizeof(int) * count);

            curr = node;
            int j = 0;
            (*trace_back)[j++] = curr;
            do {
                curr = prev_node[curr];
                (*trace_back)[j++] = curr;
            } while (curr != node);
            return count;
        }
    }
    return -1;
}

int main() {
    Graph* g = create_graph(5, false);

    add_node(g, 0, 1);
    add_node(g, 0, 2);
    add_node(g, 2, 3);
    add_node(g, 2, 4);
    add_node(g, 3, 4);

    int* trace_back;
    int count = dfs(g, 0, &trace_back);

    for (int i = 0; i < count; i++) {
        printf("%d", trace_back[i]);
    }
    printf("%d\n", trace_back[0]);
}
