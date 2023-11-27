from math import ceil

msg = "Geeks for Geeks"
key = "HACK"

cols = len(key)
rows = ceil(len(msg) / cols)

matrix = [["" for i in range(cols)] for j in range(rows)]

i = 0
for x in range(rows):
    for y in range(cols):
        if i >= len(msg):
            matrix[x][y] = "_"
        else:
            matrix[x][y] = msg[i]
        i += 1
[print(row) for row in matrix]
sorted_key = list(key)
sorted_key.sort()

for char in sorted_key:
    i = key.index(char)
    print("".join([row[i] for row in matrix]), end="")

print()
