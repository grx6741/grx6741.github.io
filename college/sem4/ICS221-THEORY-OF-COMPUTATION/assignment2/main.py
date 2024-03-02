from itertools import combinations

class Node:
    def __init__(self, name: str, start: bool, final: bool):
        self.name = name
        self.is_start = start
        self.is_final = final
        self.reachable = False

    def __repr__(self):
        return f"{self.name}, start = {self.is_start}, final = {self.is_final}"

    def add_transition_a(self, a):
        self.a = a

    def add_transition_b(self, b):
        self.b = b


class DFA:
    def __init__(self):
        self.nodes = []
        self.start_found = False

    def add_node(self, name, start, final):
        if start and self.start_found:
            print("Start symbol already given")

        self.start_found = True
        self.nodes.append(Node(name, start, final))

    def get_node(self, name):
        for i, node in enumerate(self.nodes):
            if node.name == name:
                return i, node

    # remove non reachable states while iterating
    def remove_unreachable(self):
        self.nodes = [node for node in self.nodes if node.reachable]

    # checking transition closure
    def check_trans_closure(self, groups, node1, node2) -> bool:
        node1_a = node1.a
        node1_b = node1.b

        node2_a = node2.a
        node2_b = node2.b

        for grp in groups:
            if (node1_a in grp and node2_a not in grp) or (node1_a not in grp and node2_a in grp):
                return False
            if (node1_b in grp and node2_b not in grp) or (node1_b not in grp and node2_b in grp):
                return False
        return True

    # split the grp nodes
    def split_groups(self, node1, node2, groups):
        for idx, grp in enumerate(groups):
            if node1 in grp and node2 in groups:
                grp.remove(node2)
                grp.sort()
                break

        for i in range(idx + 1, len(groups)):
            if not len(groups[i]):
                groups[i].append(node2)
                groups[i].sort()

        return groups

    # equivalence loop
    def find_equivalence(self, groups):
        changed_flag = True
        while changed_flag:
            for grp in groups:
                if not len(grp):
                    continue
                if len(grp) == 1:
                    continue
                for node1, node2 in combinations(grp, 2):
                    if self.check_trans_closure(groups, node1, node2):
                        pass
                    else:
                        # split the groups
                        groups = self.split_groups(node1, node2, groups)
                        continue
                changed_flag = False
        # sorting Groups recursively
        for grp in groups:
            grp.sort(key=lambda x: x.name)
        groups.sort(key=lambda x: x[0].name)

        return groups

    # print function
    def print_minimised(self, groups):
        # printing names
        visited = [False] * len(self.nodes)
        for idx, node in enumerate(self.nodes):
            if not visited[idx]:
                # visited[idx] = True
                for grp in groups:
                    if node in grp:
                        node_name = []
                        for n in grp:
                            i = self.nodes.index(n)
                            visited[i] = True
                            node_name.append(n.name)

                print("".join(node_name))

        # printing transitions
        for grp in groups:
            node_name = "".join([n.name for n in grp])
            node = grp[0]
            for grp2 in groups:
                if node.a in grp2:
                    node_A = "".join([n.name for n in grp2])
                if node.b in grp2:
                    node_B = "".join([n.name for n in grp2])
            print(f"{node_name} {node_A} a")
            print(f"{node_name} {node_B} b")

    # main minimisation function
    def minimised(self):
        self.remove_unreachable()
        groups = []
        # making group-0 for non-final states
        groups.append([node for node in self.nodes if not node.is_final])
        # making group-1 for final states
        groups.append([node for node in self.nodes if node.is_final])

        # start finding equivalence
        groups = self.find_equivalence(groups)

        # print minimised DFA
        self.print_minimised(groups)


# driver code
if __name__ == "__main__":
    total_states = int(input())
    final_states = int(input())
    transitions = int(input())

    dfa = DFA()

    # taking starting state as input
    # making reachability as True
    dfa.add_node(input(), True, False)
    dfa.nodes[0].reachable = True

    for _ in range(final_states):
        dfa.add_node(input(), False, True)

    for _ in range(total_states - final_states - 1):
        dfa.add_node(input(), False, False)

    for _ in range(transitions):
        trans = input().split()
        q1 = trans[0]
        q2 = trans[1]
        alpha = trans[-1]

        _, node1 = dfa.get_node(q1)
        _, node2 = dfa.get_node(q2)

        if alpha == "a":
            node1.add_transition_a(node2)
            node2.reachable = True
        elif alpha == 'b':
            node1.add_transition_b(node2)
            node2.reachable = True
        else:
            print("Input not stated or Input doesn't belong ot {a,b}")

    # start minimisation
    dfa.minimised()

