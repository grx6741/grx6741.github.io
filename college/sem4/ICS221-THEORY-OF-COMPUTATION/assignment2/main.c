#include <stdio.h>
#include <stdint.h>
#include <stdlib.h>

#define TODO printf("[TODO] %d:%s()\n", __LINE__, __func__)

/*
 * <id>_e => enum
 * <id>_t => type
 * <id>_s => struct
 */

typedef enum {
    START_STATE = 0,
    INTERMEDIATE_STATE,
    FINAL_STATE
} state_type_e;

typedef struct {
    char* vars;
    uint32_t count;
} transition_vars_s;

typedef struct {

} transition_table_s;

typedef struct {
    state_type_e* states; // Where states[stateID] -> type of state
    uint32_t states_count;
    uint32_t final_states_count;
    transition_vars_s transitions;
} dfa_s;

int getStatesCount() {
    TODO;
    return 4;
}

int getFinalStatesCount() {
    TODO;
    return 2;
}

transition_vars_s getTransitions() {
    TODO;
    transition_vars_s t;
    t.count = 2;
    t.vars = (char*)malloc(t.count * sizeof(char));
    return t;
}

int main() {
    dfa_s DFA;
    DFA.states_count = getStatesCount();
    DFA.final_states_count = getFinalStatesCount();
    DFA.transitions = getTransitions();
}
