# LAB 4

## Cisco Packet Tracer (Cisco-PT): Establishing network connections using Router and Switch

- Name: Gowrish I
- Roll No: 2022BCS0155
- Batch Name: Set 4 Batch 2
- IP Address: 172.16.195.225
- MAC Address: 6c:94:66:99:70:78

### Exercise 1

#### Aim

To establish a connection between devices using switch and Router. Observe the working of the Hub using ping packets and by running the Packet tracer in Simulation mode. (Send ping packets using the Traffic generator from PC-A)

#### Requirements
- Cisco Packet Tracer 8.2.1
- Windows PCs must have One NIC cards. Routers, Switches
- RJ-45 Sockets – Copper straight-through, cross-over Wire.
- Class A & C IP Address using Static IP configuration.

#### Observation

- Physical Connection

#### Output

- `ping` from PC-A to all other PC

```console
C:\>ping 192.168.1.3

Pinging 192.168.1.3 with 32 bytes of data:

Reply from 192.168.1.3: bytes=32 time<1ms TTL=128
Reply from 192.168.1.3: bytes=32 time<1ms TTL=128
Reply from 192.168.1.3: bytes=32 time<1ms TTL=128
Reply from 192.168.1.3: bytes=32 time<1ms TTL=128

Ping statistics for 192.168.1.3:
    Packets: Sent = 4, Received = 4, Lost = 0 (0% loss),
Approximate round trip times in milli-seconds:
    Minimum = 0ms, Maximum = 0ms, Average = 0ms

C:\>ping 192.168.2.2

Pinging 192.168.2.2 with 32 bytes of data:

Reply from 192.168.2.2: bytes=32 time=11ms TTL=127
Reply from 192.168.2.2: bytes=32 time<1ms TTL=127
Reply from 192.168.2.2: bytes=32 time<1ms TTL=127
Reply from 192.168.2.2: bytes=32 time<1ms TTL=127

Ping statistics for 192.168.2.2:
    Packets: Sent = 4, Received = 4, Lost = 0 (0% loss),
Approximate round trip times in milli-seconds:
    Minimum = 0ms, Maximum = 11ms, Average = 2ms

C:\>ping 192.168.2.3

Pinging 192.168.2.3 with 32 bytes of data:

Reply from 192.168.2.3: bytes=32 time<1ms TTL=127
Reply from 192.168.2.3: bytes=32 time=1ms TTL=127
Reply from 192.168.2.3: bytes=32 time=1ms TTL=127
Reply from 192.168.2.3: bytes=32 time<1ms TTL=127

Ping statistics for 192.168.2.3:
    Packets: Sent = 4, Received = 4, Lost = 0 (0% loss),
Approximate round trip times in milli-seconds:
    Minimum = 0ms, Maximum = 1ms, Average = 0ms

C:\>
```

- `arp -a` from PC-A
```console
C:\>arp -a
  Internet Address      Physical Address      Type
  192.168.1.1           0030.a390.5077        dynamic
  192.168.1.3           00d0.ff12.a4b6        dynamic

C:\>
```


### Exercise 2

#### Aim

To establish a connection between two different networks connected between each other through switches and Routers.

#### Requirements
- Cisco Packet Tracer 8.2.1
- Windows PCs must have One NIC cards. Routers, Switches
- RJ-45 Sockets – Copper straight-through, cross-over Wire.
- Class A & C IP Address using Static IP configuration.

### Observation

- Physical Connection

#### Output
- `arp -a` from PC-A
```console
C:\>arp -a
  Internet Address      Physical Address      Type
  192.168.1.1           0030.a390.5077        dynamic
  192.168.1.3           00d0.ff12.a4b6        dynamic

C:\>
```
- `ping` from PC-A to all other PC

```console
C:\>ping 192.168.1.3

Pinging 192.168.1.3 with 32 bytes of data:

Reply from 192.168.1.3: bytes=32 time=2ms TTL=128
Reply from 192.168.1.3: bytes=32 time<1ms TTL=128
Reply from 192.168.1.3: bytes=32 time<1ms TTL=128
Reply from 192.168.1.3: bytes=32 time<1ms TTL=128

Ping statistics for 192.168.1.3:
    Packets: Sent = 4, Received = 4, Lost = 0 (0% loss),
Approximate round trip times in milli-seconds:
    Minimum = 0ms, Maximum = 2ms, Average = 0ms

C:\>ping 192.168.2.2

Pinging 192.168.2.2 with 32 bytes of data:

Reply from 192.168.2.2: bytes=32 time<1ms TTL=127
Reply from 192.168.2.2: bytes=32 time<1ms TTL=127
Reply from 192.168.2.2: bytes=32 time<1ms TTL=127
Reply from 192.168.2.2: bytes=32 time<1ms TTL=127

Ping statistics for 192.168.2.2:
    Packets: Sent = 4, Received = 4, Lost = 0 (0% loss),
Approximate round trip times in milli-seconds:
    Minimum = 0ms, Maximum = 0ms, Average = 0ms

C:\>ping 192.168.2.3

Pinging 192.168.2.3 with 32 bytes of data:

Reply from 192.168.2.3: bytes=32 time<1ms TTL=127
Reply from 192.168.2.3: bytes=32 time=1ms TTL=127
Reply from 192.168.2.3: bytes=32 time=12ms TTL=127
Reply from 192.168.2.3: bytes=32 time<1ms TTL=127

Ping statistics for 192.168.2.3:
    Packets: Sent = 4, Received = 4, Lost = 0 (0% loss),
Approximate round trip times in milli-seconds:
    Minimum = 0ms, Maximum = 12ms, Average = 3ms
```
