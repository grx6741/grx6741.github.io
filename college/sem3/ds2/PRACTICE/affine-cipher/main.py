msg = "cat sat on a mat"
a = 7
b = 2

def encrypt(char, a, b):
    return chr(ord("a") + ((a * (ord(char) - ord("a")) + b) % 26)) if char != " " else " "

def decrypt(char, a, b):
    inv = pow(a, -1, 26)
    return chr(ord("a") + (inv * (ord(char) - ord("a") - b) % 26)) if char != " " else " "

encrypted = "".join([encrypt(char, a, b) for char in msg])
decrypted = "".join([decrypt(char, a, b) for char in encrypted])

print(encrypted, decrypted, sep="\n")
