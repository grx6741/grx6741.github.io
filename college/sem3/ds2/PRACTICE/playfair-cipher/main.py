from string import ascii_lowercase
import numpy as np

msg = "instruments"
key = "monarchy"

def preprocess(word):
    bogus = list("yxz")
    i = 0
    words_split_in_2 = []
    while i < len(word):
        temp = ""
        if i == len(word) - 1:
            temp = f"{word[i]}{bogus.pop()}"
        elif word[i] == word[i+1]:
            temp = word[i] + bogus.pop()
        else:
            temp = word[i] + word[i+1]
        if temp:
            words_split_in_2.append(temp)
        i += 2
    return words_split_in_2

twins = preprocess(msg)

lower_letters = list(ascii_lowercase)
lower_letters.remove('j')
lower_letters = "".join(lower_letters)

letter_hash = {c : False for c in lower_letters}

matrix = [["" for _ in range(5)] for j in range(5)]

i = 0
for x in range(5):
    for y in range(5):
        if i < len(key):
            matrix[x][y] = key[i]
            letter_hash[key[i]] = True
        else:
            for c in lower_letters:
                if not letter_hash[c]:
                    matrix[x][y] = c
                    letter_hash[c] = True
                    break
        i += 1



def get(mat, char):
    for i in range(len(mat)):
        if char in mat[i]:
            return [i, mat[i].index(char)]
    return [-1, -1]

ans = ""
for twin in twins:
    pos1 = get(matrix, twin[0])
    pos2 = get(matrix, twin[1])

    print(twin)
    print(pos1, pos2)

    if pos1[0] == pos2[0]:
        pos1[1] = (pos1[1] + 1) % 5
        pos2[1] = (pos2[1] + 1) % 5
        print("Same row")
    elif pos1[1] == pos2[1]:
        pos1[0] = (pos1[0] + 1) % 5
        pos2[0] = (pos2[0] + 1) % 5
        print("Same col")
    else:
        new_pos1 = [pos1[0], pos2[1]]
        new_pos2 = [pos2[0], pos1[1]]
        pos1 = new_pos1
        pos2 = new_pos2
        print("neither")
    print(pos1, pos2)
    ans += matrix[pos1[0]][pos1[1]] + matrix[pos2[0]][pos2[1]]

print(ans)
