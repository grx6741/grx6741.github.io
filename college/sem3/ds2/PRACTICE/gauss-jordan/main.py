mat = [
        [1, 1, 2, 6],
        [0, 2, 1, 4],
        [2, 1, 1, 7]
        ]

def add(arr1, arr2):
    return [arr1[i] + arr2[i] for i in range(len(arr1))]

def mult(arr, k):
    return [arr[i] * k for i in range(len(arr))]

def compute(arr1, arr2, i):
    return add(mult(arr1, arr2[i]), mult(arr2, -arr1[i]))

for j in range(3):
    for i in range(3):
        if i == j:
            continue
        mat[i] = compute(mat[i], mat[j], j)

ans = ["x", "y", "z"]
for i in range(3):
    print(ans[i] + ": ", mat[i][-1] / mat[i][i])
