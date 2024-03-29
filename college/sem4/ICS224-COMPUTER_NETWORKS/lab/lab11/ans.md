# ICS 224 COMPUTER NETWORKS

## Lab 11

### Gowrish I 2022BCS0155

- Run the first.cc program by copying it to the scratch folder under the name myfirst.cc

```console
At time +2s client sent 512 bytes to 10.1.1.2 port 9
At time +2.00287s server received 512 bytes from 10.1.1.1 port 49153
At time +2.00287s server sent 512 bytes to 10.1.1.1 port 49153
At time +2.00573s client received 512 bytes from 10.1.1.2 port 9
```

- Find the theoretical transmit time (Tt) for a packet of size 1024 bytes to arrive at the receiver, if the link speed is 5 Mbps and the propagation delay is  2ms?

```cpp
// At Packet Size 1024 bytes
echoClient.SetAttribute("PacketSize", UintegerValue(1024));
```

```console
At time +2s client sent 1024 bytes to 10.1.1.2 port 9
At time +2.00369s server received 1024 bytes from 10.1.1.1 port 49153
At time +2.00369s server sent 1024 bytes to 10.1.1.1 port 49153
At time +2.00737s client received 1024 bytes from 10.1.1.2 port 9
```

```
Total delay = 2.00369s - 2s = 3.69ms
Tt  = Total delay - Propagation delay
    = 3.69ms - 2ms
    = 1.69ms
```

- Find the theoretical transmit time (Tt) for a packet of size 1024 bytes to arrive at the receiver, if the link speed is 5 Mbps and the propagation delay is  5ms? Verify and present the terminal  results to show if  Tt  is same/different for Q2. Consider the L3 header to be 20 bytes long and include it in the calculations

```cpp
pointToPoint.SetChannelAttribute("Delay", StringValue("5ms"));
```

```console
At time +2s client sent 1024 bytes to 10.1.1.2 port 9
At time +2.00669s server received 1024 bytes from 10.1.1.1 port 49153
At time +2.00669s server sent 1024 bytes to 10.1.1.1 port 49153
At time +2.01337s client received 1024 bytes from 10.1.1.2 port 9
```

```
Total delay = 2.00669s - 2s = 6.69ms
Tt  = Total delay - Propagation delay
    = 6.69ms - 5ms
    = 1.69ms -> Same as Q2
```

```cpp
// Packet Size 1024 bytes + 20 bytes header = 1044 bytes
echoClient.SetAttribute("PacketSize", UintegerValue(1044));
```

```console
At time +2s client sent 1044 bytes to 10.1.1.2 port 9
At time +2.00672s server received 1044 bytes from 10.1.1.1 port 49153
At time +2.00672s server sent 1044 bytes to 10.1.1.1 port 49153
At time +2.01344s client received 1044 bytes from 10.1.1.2 port 9
```

```
Total delay = 2.00672s - 2s = 6.72ms
Tt  = Total delay - Propagation delay
    = 6.72ms - 5ms
    = 1.72ms
```

- If the packet of size is  1024 bytes (excluding the header) and the link speed is 10 Mbps and the propagation delay is  5ms, Compare the  observed total delay (Tt +TPD + ?) with the theoretical delay and give your inferences on the difference between the two values? Consider the L3 header to be 20 bytes long and include it in the calculations

```
Tt  = Packet Size / Bandwidth
    = 1024 bytes / 10 Mbps
    = 0.8192ms

Total theoretical delay = Tt + Tp
                        = 0.8192ms + 5ms
                        = 5.8192ms
```

```console
// Observed Results
At time +2s client sent 1024 bytes to 10.1.1.2 port 9
At time +2.00584s server received 1024 bytes from 10.1.1.1 port 49153
At time +2.00584s server sent 1024 bytes to 10.1.1.1 port 49153
At time +2.01169s client received 1024 bytes from 10.1.1.2 port 9
```

```
Total delay = 2.00584s - 2s
            = 5.84ms
```

| Theoretical | Observed|
--------------|----------
| 5.8192ms | 5.84ms |

- Calculate the link utilization (achievable throughput) for Q4, based on the values in Q4. Assume that the transmitted echo packet and the reply represent the data+ Ack frames for the Data Link Layer. Consider the L3 header to be 20 bytes long.

```
Throughput = Actual datas sent / Actual Transmit Delay
           = 1024 bytes / 0.84ms
           = 9.75Mbps
```

```cpp
// Packet Size 1024 bytes + 20 bytes header = 1044 bytes
echoClient.SetAttribute("PacketSize", UintegerValue(1044));
```

```console
At time +2s client sent 1044 bytes to 10.1.1.2 port 9
At time +2.00586s server received 1044 bytes from 10.1.1.1 port 49153
At time +2.00586s server sent 1044 bytes to 10.1.1.1 port 49153
At time +2.01172s client received 1044 bytes from 10.1.1.2 port 9
```

```
Throughput = Actual datas sent / Actual Transmit Delay
           = 1044 bytes / 0.86ms
           = 9.71Mbps
```
