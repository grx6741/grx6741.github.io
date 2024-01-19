import numpy as np

A = np.array([
    [1, 1, 1],
    [4, 3, -1],
    [3, 5, 3]
    ])

C = np.array([ 1, 6, 4 ])
L = np.identity(len(A))
U = np.array(A)

for i in range(len(A)):
    for j in range(len(A)):
        if i > j:
            k = U[i][j] / U[j][j]
            L[i][j] = k
            U[i] = U[i] - k * U[j]


x = np.zeros(len(A))

for j in range(len(A)):
    other_sum = x.dot(L[j])
    x[j] = ((C[j] - other_sum) / L[j][j])

z = np.zeros(len(A))

for j in range(len(A) - 1, -1, -1):
    other_sum = z.dot(U[j])
    z[j] = ((x[j] - other_sum) / U[j][j])

print(z)
