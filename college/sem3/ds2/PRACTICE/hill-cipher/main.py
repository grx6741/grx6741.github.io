import numpy as np

msg = "ACT"
key = "GYBNQKURP"

msg_array = np.array([ord(c) - ord("A") for c in msg]).reshape((len(msg), 1))
key_matrix = np.array([ord(c) - ord("A") for c in key]).reshape((len(msg), len(msg)))

print(msg_array)
print(key_matrix)

prod = (key_matrix.dot(msg_array) % 26)
enc_key = prod.reshape((1, len(msg)))[0]
encrypted_msg = "".join([chr(ord("A") + enc_key[i]) for i in range(len(enc_key))])

print(encrypted_msg)

det = np.linalg.det(key_matrix)
inverse = np.linalg.inv(key_matrix) * det * pow(int(det), -1, 26) % 26
dec_prod = inverse.dot(prod)
dec_key = dec_prod.reshape((1, len(msg)))[0]
dec_key = [int(round(a, 2)) % 26 for a in dec_key]
decrypted_msg = "".join([chr(ord("A") + int(dec_key[i])) for i in range(len(dec_key))])

print(decrypted_msg)
