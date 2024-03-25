
class Head:
    def __init__(self, degree: int, val: int):
        self.val = val
        self.degree = degree

h1 = [Head(0, 12), Head(1, 7), Head(2, 15)]
h2 = [Head(0, 18), Head(1, 3), Head(4,  6)]

h12 = h1 + h2
h12.sort(key = lambda ha : ha.degree )

[print(h.degree, h.val) for h in h12]
print()

i = 0
while i < len(h12) - 1:
    if h12[i].degree == h12[i+1].degree:
        if i + 2 < len(h12) and h12[i+1].degree == h12[i+2].degree:
            i += 1
            continue

        max_head_i = max(i, i+1, key=lambda i: h12[i].val)
        min_head_i = min(i, i+1, key=lambda i: h12[i].val)
        h12[min_head_i].degree += 1
        h12.pop(max_head_i)
    else:
        i += 1

for h in h12:
    print(h.degree)

for h in h12:
    print(h.val , end=" ")
