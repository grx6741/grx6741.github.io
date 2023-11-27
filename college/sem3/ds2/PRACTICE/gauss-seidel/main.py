from typing import List

def my_sum(arr: List[int]) -> int:
    return sum(list(map(abs, arr)))

def verify(mat: List[List[int]]) -> bool:
    for i in range(len(mat)):
        if my_sum(mat[i][:-1]) - abs(mat[i][i]) > abs(mat[i][i]):
            return False
    return True

def dot(arr1: List[int], arr2: List[int]) -> List[int]:
    return [arr1[i] * arr2[i] for i in range(len(arr1))]

def subtract(arr1: List[int], arr2: List[int]) -> List[int]:
    return [arr1[i] - arr2[i] for i in range(len(arr1))]

def div(arr1: List[int], arr2: List[int]) -> List[int]:
    return [arr1[i] / arr2[i] for i in range(len(arr1))]

def avg(arr1: List[int]) -> int:
    return my_sum(arr1) / len(arr1)

mat = [
        [12, 3, -5, 1],
        [1, 5, 3, 28],
        [3, 7, 13, 76]
        ]

if not verify(mat):
    print("Does not converge")
    exit()

# guess = [0 for _ in range(len(mat))]
guess = [1, 0, 1]
avg_error = 1
while avg_error > 1e-5:
    new_guess = guess.copy()
    for i in range(len(mat)):
        other_sum = sum(dot(mat[i][:-1], new_guess)) - mat[i][i] * new_guess[i]
        new_guess[i] = (mat[i][-1] - other_sum) / mat[i][i]

    avg_error = avg(div(subtract(new_guess, guess), new_guess))
    guess = new_guess
    print(guess, avg_error)

print([round(a, 2) for a in guess])
