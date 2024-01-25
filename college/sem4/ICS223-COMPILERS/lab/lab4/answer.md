# Lab-3: Cisco Packet Tracer: Establishing network connections using Hub, Switch

- Name: Gowrish I  
- Roll No.: 2022BCS0155
- Batch Name: Batch - 2, Set - 4
- IP Address: `192.168.10.91`
- MAC Address: `f4:39:09:2b:41:9c`
- Date: `Thursday 25 January 2024 02:45:19 PM IST`

## Exercise 1

### Aim
To establish a connection between devices through copper straight-through wire using a Hub
(Hub-PT). Observe the working of the Hub using ping packets and by running the Packet tracer in
Simulation mode. (Send ping packets using the Traffic generator from PC-A)

## Requirements
1) Cisco Packet Tracer 8.2.1
2) Three Windows PC or Linux PC, Each PC must Have One NIC cards.
3) RJ-45 Sockets – Copper straight-through Wire.
4) Class C IP Address using Static IP configuration.

## Physical Connections
![image](https://github.com/grx6741/grx6741.github.io/assets/73749042/c82ae169-6ca9-49cb-89f6-4022943a1d43)

## Observation
- PC-A
```console
C:\>ipconfig

FastEthernet0 Connection:(default port)

   Connection-specific DNS Suffix..: 
   Link-local IPv6 Address.........: FE80::202:4AFF:FE80:AE41
   IPv6 Address....................: ::
   IPv4 Address....................: 192.168.1.1
   Subnet Mask.....................: 255.255.255.0
   Default Gateway.................: ::
                                     192.168.1.1

Bluetooth Connection:

   Connection-specific DNS Suffix..: 
   Link-local IPv6 Address.........: ::
   IPv6 Address....................: ::
   IPv4 Address....................: 0.0.0.0
   Subnet Mask.....................: 0.0.0.0
   Default Gateway.................: ::
                                     0.0.0.0
```
- PC-B
```console
C:\>ipconfig

FastEthernet0 Connection:(default port)

   Connection-specific DNS Suffix..: 
   Link-local IPv6 Address.........: FE80::202:4AFF:FE80:AE41
   IPv6 Address....................: ::
   IPv4 Address....................: 192.168.1.2
   Subnet Mask.....................: 255.255.255.0
   Default Gateway.................: ::
                                     192.168.1.1

Bluetooth Connection:

   Connection-specific DNS Suffix..: 
   Link-local IPv6 Address.........: ::
   IPv6 Address....................: ::
   IPv4 Address....................: 0.0.0.0
   Subnet Mask.....................: 0.0.0.0
   Default Gateway.................: ::
                                     0.0.0.0
```
- PC-C
```console
C:\>ipconfig

FastEthernet0 Connection:(default port)

   Connection-specific DNS Suffix..: 
   Link-local IPv6 Address.........: FE80::202:4AFF:FE80:AE41
   IPv6 Address....................: ::
   IPv4 Address....................: 192.168.1.3
   Subnet Mask.....................: 255.255.255.0
   Default Gateway.................: ::
                                     192.168.1.1

Bluetooth Connection:

   Connection-specific DNS Suffix..: 
   Link-local IPv6 Address.........: ::
   IPv6 Address....................: ::
   IPv4 Address....................: 0.0.0.0
   Subnet Mask.....................: 0.0.0.0
   Default Gateway.................: ::
                                     0.0.0.0
```

![Screencast from 25-01-24 03 23 23 PM IST](https://github.com/grx6741/grx6741.github.io/assets/73749042/a4a9b7d6-4257-417d-9153-c65a0682b5a0)

## Inferences
A hub recieves a packet from one device and sends it to every device.
