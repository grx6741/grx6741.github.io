import math

data = list(map(int, "10011011100"))
powers_of_2 = [2**i for i in range(10)]

for i in range(len(data)):
    if i in powers_of_2 or i == 0:
        data.insert(i, 0)

i = 1
while i < len(data):
    n = math.floor(math.log2(i))
    for j, num in enumerate(data):
        if (j >> n) & 1:
            data[i] ^= num
    i *= 2

for i in range(len(data)):
    data[0] ^= data[i]

data[3] = not data[3]
data[6] = not data[6]

# Reciever side

all_ones = [i for i, num in enumerate(data) if num]
error = 0
for num in all_ones:
    error ^= num

if len(all_ones) % 2 == 0 and error != 0:
    print("2 bit error")
elif len(all_ones) % 2 != 0:
    print(f"Error @ {error + 1}")
    data[error] = int(not data[error])
    print(f"Corrected: {''.join(list(map(str, data)))}")
else:
    print("No Error Detected")
