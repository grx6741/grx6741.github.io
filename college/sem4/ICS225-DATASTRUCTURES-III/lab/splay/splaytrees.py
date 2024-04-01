from enum import Enum
from copy import copy
from typing import List


class Movement(Enum):
    LEFT = 0
    RIGHT = 1

class Node:
    def __init__(self, val: int):
        self.val: int = val
        self.left: Node | None = None
        self.right: Node | None = None

    def insert(self, val):
        if val < self.val:
            if self.left:
                self.left.insert(val)
            else:
                self.left = Node(val)
        else:
            if self.right:
                self.right.insert(val)
            else:
                self.right = Node(val)

    def inorder(self):
        if self.left:
            self.left.inorder()
        print(self.val, end=" ")
        if self.right:
            self.right.inorder()

class Splay:
    @staticmethod
    def zig(p: Node | None, x: Node | None) -> Node | None:
        if not p or not x: return
        p.left = x.right
        x.right = p
        return x

    @staticmethod
    def zag(p: Node | None, x: Node | None) -> Node | None:
        if not p or not x: return
        p.right = x.left
        x.left = p
        return x

    @staticmethod
    def zigzig(g: Node | None, p: Node | None, x: Node | None) -> Node | None:
        return Splay.zig(Splay.zig(g, p), x)

    @staticmethod
    def zagzag(g: Node | None, p: Node | None, x: Node | None) -> Node | None:
        return Splay.zag(Splay.zag(g, p), x)

    @staticmethod
    def zigzag(g: Node | None, p: Node | None, x: Node | None) -> Node | None:
        if not g or not p or not x: return
        g.left = Splay.zag(p, x)
        return Splay.zig(g, x)

    @staticmethod
    def zagzig(g: Node | None, p: Node | None, x: Node | None) -> Node | None:
        if not g or not p or not x: return
        g.right = Splay.zig(p, x)
        return Splay.zag(g, x)

    @staticmethod
    def insert(root: Node | None, val) -> Node | None:
        if not root: return
        root.insert(val)

        root = Splay.find(root, val)
        return root

    @staticmethod
    def split(root: Node | None, k: int) -> None | List[Node | None]:
        root = Splay.find(root, k)
        if not root: return

        return [root.left, root.right]

    @staticmethod
    def join(left: Node | None, right: Node | None) -> Node | None:
        if not left:
            return right

        max = copy(left)
        while max.right:
            max = max.right

        left = Splay.find(left, max.val)
        if not left: return

        left.right = right
        return left

    @staticmethod
    def delete(root: Node | None, val) -> Node | None:
        if not root: return

        root = Splay.find(root, val)
        if not root: return
        root = Splay.join(root.left, root.right)

        return root

    @staticmethod
    def find(root: Node | None, val: int, i = 0) -> Node | None:
        i += 1
        if not root: return
        d1: Movement = Movement.LEFT
        d2: Movement = Movement.LEFT
        if root.val == val:
            return root
        
        g = root
        if g.val < val:
            p = g.right
            d1 = Movement.RIGHT
        else:
            p = g.left
            d1 = Movement.LEFT
        if not p: return


        if p.val == val:
            if d1 == Movement.LEFT:
                g = Splay.zig(g, p)
                return g
            else:
                g = Splay.zag(g, p)
                return g

        if p.val < val:
            x = p.right
            d2 = Movement.RIGHT
        else:
            x = p.left
            d2 = Movement.LEFT
        if not x: return

        if p.val != val and x.val != val:
            x = Splay.find(x, val, i)
            if not x: return

        if x.val == val:
            if d1 == Movement.LEFT:
                if d2 == Movement.LEFT:
                    g = Splay.zigzig(g, p, x)
                    return g
                else:
                    g = Splay.zigzag(g, p, x)
                    return g
            else:
                if d2 == Movement.LEFT:
                    g = Splay.zagzig(g, p, x)
                    return g
                else:
                    g = Splay.zagzag(g, p, x)
                    return g

tree = Node(22)
vals = [10, 30, 6, 18, 27, 9, 15, 19, 12, 14]
for val in vals:
    tree.insert(val)

tree.inorder()
print()

# Put these here only
# tree = Splay.delete(tree, 22) -> To delete
# tree = Splay.find(tree, 22) -> To bring it to top
# tree = Splay.insert(tree, 69) -> To Insert and bring it to top

if tree: tree.inorder()
print()

if tree: print(tree.val)
