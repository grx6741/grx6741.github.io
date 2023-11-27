mat = [
        [1, 1, 2, 6],
        [0, 2, 1, 4],
        [2, 1, 1, 7]
        ]

def add(arr1, arr2):
    return [arr1[i] + arr2[i] for i in range(len(arr1))]

def mult(arr, k):
    return [arr[i] * k for i in range(len(arr))]

def dot(arr1, arr2):
    return [arr1[i] * arr2[i] for i in range(len(arr1))]

def compute(arr1, arr2, i):
    return add(mult(arr1, arr2[i]), mult(arr2, -arr1[i]))

for j in range(len(mat)):
    for i in range(len(mat)):
        if i > j:
            mat[i] = compute(mat[i], mat[j], j)

ans = [0 for i in range(len(mat))]
for j in range(len(mat)-1, -1, -1):
    other_sum = sum(dot(mat[j][:-1], ans)) - ans[j] * mat[j][j]
    ans[j] = (mat[j][-1] - other_sum) / mat[j][j]

[print(row) for row in mat]
print(ans)
