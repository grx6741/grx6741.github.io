from math import ceil

msg = "GEEKSFORGEEKS".lower()
key = "AYUSH".lower()

key_length = ceil(len(msg) / len(key))

key = (key * key_length)[:len(msg)]

def encrypt(char, a=1, b=0):
    return chr(ord("a") + ((a * (ord(char) - ord("a")) + b) % 26)) if char != " " else " "

def decrypt(char, a=1, b=0):
    inv = pow(a, -1, 26)
    return chr(ord("a") + (inv * (ord(char) - ord("a") - b) % 26)) if char != " " else " "

encrypted_msg = "".join([encrypt(msg[i], b = ord(key[i]) - ord("a")) for i in range(len(msg))])
decrypted_msg = "".join([decrypt(encrypted_msg[i], b = ord(key[i]) - ord("a")) for i in range(len(encrypted_msg))])
print(encrypted_msg.upper(), decrypted_msg.upper())


