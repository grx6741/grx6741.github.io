# CPU Scheduling

## Process

![Process Image](https://media.geeksforgeeks.org/wp-content/uploads/memoryLayoutC.jpg)

A process is an instance of a computer program that is being executed
by one or more threads.

## Objectives of Process Scheduling algorithms

- Utilization of CPU should be high
- Allocation of CPU should be fair
- More number of processes should be finished in a time unit (High Throughput)
- Minimum turn around time.
- Fast Response time

> Arrival Time $\to$ Time at which process arrives in the ready queue
>
> Completion Time $\to$ Time at which process completes its execution
>
> Burst Time $\to$ Time required by a process for CPU execution
>
> Turn Around Time $\to$ Difference between Arrival time and Completion Time
>
> Waiting Time $\to$ Difference between Turn time and Burst time

```text
Turn Around time = Completion time - Arrival time
Waiting time = Turn Around time - Burst time
```


