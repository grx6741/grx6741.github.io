# Lab-7

## Cisco Packet Tracer: Establishing network connections using Router and Switch

- Name: Gowrish I
- Roll No: 2022BCS0155
- Batch Name: Set 4 Batch 2
- IP Address: `192.168.10.79`
- MAC Address: `f4:39:09:2b:bd:2a`

## Exercice 1

### Aim
To use a DHCP server to allot IP address to two different group of PCs under two
different subnetworks using Routers and switches. One set of PCs belong to Network 2 of the
DHCP server and the other belong to a Network 1 (PCs alone). Also establish a connection to
a webserver (belonging to the same subnet of the DHCP server) from the PC of Network 1.

### Requirements

- Cisco Packet Tracer 8.2.1
- Windows PCs must have One NIC cards. Routers, Switches
- RJ-45 Sockets – Copper straight-through.
- Serial DCE cable between Routers.
- Class A & C IP Address using Static IP configuration.

### Physical Connection

Network 1
- ![Layout1](https://github.com/grx6741/grx6741.github.io/assets/73749042/fc85cd9d-976e-44ba-8d8c-7e3d61c146a9)

Network 2
  ![layout2](https://github.com/grx6741/grx6741.github.io/assets/73749042/1552309d-0fdb-4a54-947b-236ee73db0ee)

### Output
- Ping from `PC-A` to `PC-B`
  ```console
  C:\>ping 10.0.0.20
  
  Pinging 10.0.0.20 with 32 bytes of data:
  
  Request timed out.
  Reply from 10.0.0.20: bytes=32 time<1ms TTL=127
  Reply from 10.0.0.20: bytes=32 time<1ms TTL=127
  Reply from 10.0.0.20: bytes=32 time<1ms TTL=127
  
  Ping statistics for 10.0.0.20:
      Packets: Sent = 4, Received = 3, Lost = 1 (25% loss),
  Approximate round trip times in milli-seconds:
      Minimum = 0ms, Maximum = 0ms, Average = 0ms
  
  C:\>
  ```

- Allotted IP Addresses
  - PC-A
    
  ![image](https://github.com/grx6741/grx6741.github.io/assets/73749042/195a00e8-e8b4-4fec-9a81-2373b3094f1b)
  
  - PC-B
  - 
  ![image](https://github.com/grx6741/grx6741.github.io/assets/73749042/8589f0d2-c72c-496b-9075-61a3d6f9fa88)
  - PC-C
  ![image](https://github.com/grx6741/grx6741.github.io/assets/73749042/8b675546-0ea9-4e3a-97e8-62a8f9e50f37)
  - PC-D 
  ![image](https://github.com/grx6741/grx6741.github.io/assets/73749042/20192d11-159b-4928-a74c-a1a01b813664)
- Server Pool Entries ![image](https://github.com/grx6741/grx6741.github.io/assets/73749042/8e17d6dc-13fb-4196-a2a9-c6bd31d6a9d0)
- DNS Table ![image](https://github.com/grx6741/grx6741.github.io/assets/73749042/3dba8cf5-9467-4f5d-ada6-8a25b5409c37)
- Website from PC-A ![image](https://github.com/grx6741/grx6741.github.io/assets/73749042/57d1524d-cf21-4b73-a053-3c7cb60156fe)



