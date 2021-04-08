# Dinning Philosopher


Imagine your N favorite philosopher having a dinner together. They are sitting around a round table and N chopsticks are displayed : in order to eat, a philosopher have to wait for the chopsticks on his right and on his left to be available (in other words, he cannot eat while his direct neighbors are eating). Their purpose is to think, eat, and think again. 

## The Runnable

The runnable in this exercise is the DinningPhilosophers class. It is defined by a limited amount of food in its middle. This class (the dinners condition) also sets the time spent by philosopher thinking and eating.

## The Threads

A thread is a Philosopher. You can define a Philosopher as follows. First, she spent a random time thinking. Then, he wakes up and is hungry. She tries to get the chopsticks on his right and on his left. She then takes a random amount of food from the table, spend a random time eating, give away his chopsticks, and start again this loop.

The program stop when the amount of food in the middle is equal to zero.
Each Philosopher has a different appetite, a different time of thinking and a different time of eating. 



## Main intersets of the tutorial

It teaches you how to deal with multi threading, thread interleaving and interference, lock mechanism and atomic transaction. 

- Multi-Threading : multiple Philosophers are engaged in the program
- Thread Interleaving : the Philosopher is acting on the attributes of the runnable
- Atomic transaction : the speed of execution of each line of code is sometimes not equal, leading to potential errors (see .clear() method for the visited nodes). 
- Lock Mechanism : to secure the modification of attributes, and have fairness in the distribution of food.


Question 7 is in a different package : it requires to get fairness in the outcome of food repartition. (if there are 100 units of food in the middle, and 5 Philosophers, each one should get 20 units). 
