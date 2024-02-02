# Lab-5

## Cisco Packet Tracer: Establishing network connections using Router and Switch

- Name: Gowrish I
- Roll No: 2022BCS0155
- Batch Name: Set 4 Batch 2
- IP Address: 172.16.195.225
- MAC Address: 6c:94:66:99:70:78

### Exercise 2

#### Aim

To establish the connection between three different networks: Office, Home and Club networks using Routers and switches.

#### Requirements

- Cisco Packet Tracer 8.2.1
- Windows PCs must have One NIC cards. Routers, Switches
- RJ-45 Sockets – Copper straight-through.
- Serial DCE cable between Routers.
- Class A & C IP Address using Static IP configuration.

#### Observation
![p1](https://github.com/grx6741/grx6741.github.io/assets/73749042/2d708ace-4209-43d0-a610-9c297ace7297)
#### Output

- `ping` from PC-A to PC-F
```console
C:\>ping 192.168.3.3

Pinging 192.168.3.3 with 32 bytes of data:

Reply from 192.168.3.3: bytes=32 time=30ms TTL=125
Reply from 192.168.3.3: bytes=32 time=23ms TTL=125
Reply from 192.168.3.3: bytes=32 time=19ms TTL=125
Reply from 192.168.3.3: bytes=32 time=23ms TTL=125

Ping statistics for 192.168.3.3:
    Packets: Sent = 4, Received = 4, Lost = 0 (0% loss),
Approximate round trip times in milli-seconds:
    Minimum = 19ms, Maximum = 30ms, Average = 23ms

C:\>
```

- `arp -a` from PC-A
```console
C:\>arp -a
  Internet Address      Physical Address      Type
  192.168.1.1           000b.be04.a906        dynamic
  192.168.1.3           0001.6498.6109        dynamic

C:\>
```

- `show ip table` from Home Router
```console
Router#show ip route
Codes: C - connected, S - static, I - IGRP, R - RIP, M - mobile, B - BGP
       D - EIGRP, EX - EIGRP external, O - OSPF, IA - OSPF inter area
       N1 - OSPF NSSA external type 1, N2 - OSPF NSSA external type 2
       E1 - OSPF external type 1, E2 - OSPF external type 2, E - EGP
       i - IS-IS, L1 - IS-IS level-1, L2 - IS-IS level-2, ia - IS-IS inter area
       * - candidate default, U - per-user static route, o - ODR
       P - periodic downloaded static route

Gateway of last resort is not set

C    10.0.0.0/8 is directly connected, Serial2/0
C    192.168.1.0/24 is directly connected, FastEthernet0/0
S    192.168.2.0/24 [1/0] via 10.0.0.2
S    192.168.3.0/24 [1/0] via 10.0.0.2

Router#
```

- `show ip table` from Club Router
- 
```console
Router#show ip route
Codes: C - connected, S - static, I - IGRP, R - RIP, M - mobile, B - BGP
       D - EIGRP, EX - EIGRP external, O - OSPF, IA - OSPF inter area
       N1 - OSPF NSSA external type 1, N2 - OSPF NSSA external type 2
       E1 - OSPF external type 1, E2 - OSPF external type 2, E - EGP
       i - IS-IS, L1 - IS-IS level-1, L2 - IS-IS level-2, ia - IS-IS inter area
       * - candidate default, U - per-user static route, o - ODR
       P - periodic downloaded static route

Gateway of last resort is not set

C    10.0.0.0/8 is directly connected, Serial3/0
C    11.0.0.0/8 is directly connected, Serial2/0
S    192.168.1.0/24 [1/0] via 10.0.0.1
C    192.168.2.0/24 is directly connected, FastEthernet0/0
S    192.168.3.0/24 [1/0] via 11.0.0.2

Router#
```

| Source | Destination | One-Way Latency | Round-trip Time |
|--------|-------------|-----------------|-----------------|
| PC-A (Office) | PC-F (Club)   | 0.012 s | 0.027 s |
| PC-A (Office) | PC-D (Home)   | 0.014 s | 0.017 s |
| PC-C (Home)   | PC-B (Office) | 0.015 s | 0.021 s |
| PC-C (Home)   | PC-E (Club)   | 0.015 s | 0.027 s |
| PC-E (Club)   | PC-B (Office) | 0.016 s | 0.026 s |
| PC-E (Club)   | PC-C (Home)   | 0.012 s | 0.022 s |

###### Inference

- We can see maximum latency when packets are going through Home's Router since it is connected
to multiple routers
