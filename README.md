# Virtual Memory Manager

## Description

A Virtual Memory Simulator developed in Java for the Operating Systems Analysis and Application course at UNISINOS (University of Vale do Rio dos Sinos).
The project implements fundamental memory management concepts, including:

- Virtual Memory
- Main Memory
- Paging
- Page Table
- Memory Management Unit (MMU)
- Page Fault Handling
- FIFO Page Replacement Algorithm
- Multithreading

## Architecture

The simulation is composed of:

- Master Node
- Worker Nodes
- Pods
- Producer Thread
- Consumer Thread
- Shared Blocking Queue

         Process
            |
            v
         MMU
            |
            v
         Page Table
            |
            v
         Main Memory
            |
            v
         FIFO Queue

## Sample Output
```bash
======================================
PROCESS 1
--------------------------------------
Virtual Address  : 213527
Page Number      : 26
Offset           : 535
Frame            : 5
Physical Address : 41495
Status           : PAGE FAULT

FIFO QUEUE: [28] -> [127] -> [64] -> [63] -> [58] -> [26] -> X

MAIN MEMORY:
FRAME     PAGE      
0         28        
1         127       
2         64        
3         63        
4         58        
5         26        
6         -         
7         -
```

## Running

Requirements:

- Java 17+
- Maven 3.9+

Compile:

```bash
mvn clean package
java -jar target/pod-scheduler-simulator.jar