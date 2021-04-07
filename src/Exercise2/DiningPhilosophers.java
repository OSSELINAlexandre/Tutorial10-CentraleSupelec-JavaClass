package Exercise2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {

	private int thinkingTime;
	private int eatingTime;
	private int amountFood;
	private ArrayList<Philosopher> dinningPhilosophers;
	private ArrayList<Philosopher> fedPhilosopher;
	private Boolean aPhilosopherIsHelpingHimself;
	private Lock aPhilosopherEatingAtTheTime;

	public DiningPhilosophers(int amountFood, int thinkingTime, int eatingTime) {
		this.thinkingTime = thinkingTime;
		this.eatingTime = eatingTime;
		this.amountFood = amountFood;
		this.dinningPhilosophers = new ArrayList<>();
		this.fedPhilosopher = new ArrayList<>(); //Act like a set of visited nodes.
		this.aPhilosopherIsHelpingHimself = false;
		this.aPhilosopherEatingAtTheTime = new ReentrantLock();
	}

	public void addAPhilo(Philosopher a) {

		dinningPhilosophers.add(a);
	}
	


	public Lock getaPhilosopherEatingAtTheTime() {
		return aPhilosopherEatingAtTheTime;
	}

	public Boolean getaPhilosopherIsHelpingHimself() {
		return aPhilosopherIsHelpingHimself;
	}

	public void setaPhilosopherIsHelpingHimself(Boolean aPhilosopherIsHelpingHimself) {
		this.aPhilosopherIsHelpingHimself = aPhilosopherIsHelpingHimself;
	}

	public ArrayList<Philosopher> getDinningPhilosophers() {
		return dinningPhilosophers;
	}

	public void setDinningPhilosophers(ArrayList<Philosopher> dinningPhilosophers) {
		this.dinningPhilosophers = dinningPhilosophers;
	}

	public ArrayList<Philosopher> getFedPhilosopher() {
		return fedPhilosopher;
	}

	public void setFedPhilosopher(ArrayList<Philosopher> fedPhilosopher) {
		this.fedPhilosopher = fedPhilosopher;
	}

	public ArrayList<Philosopher> getSmart() {
		return dinningPhilosophers;
	}

	public int getThinkingTime() {
		return thinkingTime;
	}

	public void setThinkingTime(int thinkingTime) {
		this.thinkingTime = thinkingTime;
	}

	public int getEatingTime() {
		return eatingTime;
	}

	public void setEatingTime(int eatingTime) {
		this.eatingTime = eatingTime;
	}

	public int getAmountFood() {
		return amountFood;
	}

	public void setAmountFood(int amountFood) {
		this.amountFood = amountFood;
	}

	public static void main(String[] args) {

		ArrayList<Chopstick> theLot = new ArrayList<>();
		DiningPhilosophers dinningPhi = new DiningPhilosophers(20, 5, 7);
		Chopstick n1 = new Chopstick();
		Chopstick n2 = new Chopstick();
		Chopstick n3 = new Chopstick();
		Chopstick n4 = new Chopstick();
		Chopstick n5 = new Chopstick();
		theLot.add(n5);
		theLot.add(n4);
		theLot.add(n3);
		theLot.add(n2);
		theLot.add(n1);

		Philosopher Socrate = new Philosopher(dinningPhi, "Socrate", n1, n2, 10);
		Philosopher Platon = new Philosopher(dinningPhi, "Platon", n2, n3, 10);
		Philosopher Scruton = new Philosopher(dinningPhi, "Scruton", n3, n4, 10);
		Philosopher Aquin = new Philosopher(dinningPhi, "Aquin", n4, n5, 10);
		Philosopher Peterson = new Philosopher(dinningPhi, "Peterson", n5, n1, 10);

		Peterson.start();
		Socrate.start();
		Scruton.start();
		Platon.start();
		Aquin.start();


	}

}

// Q1 done;
//
//Q2 : When we delete the different times of thinking or eating, a thread tend to have a dominance once he got into the loop and tend to be the only one able to run the runnable
//It seems as if they were a fraction of second in which another thread could get the dominance in the runnable. So it is far from being fair. 
//
//Q3 : To avoid this situation, it is possible to create an equivalent 'visited node' arrayList to check if one philosopher has eaten or not. 
//
//
//
//Q6 : if the amount of food is limited, multiple issues could arise, but mostly Thread Interferences
//A simple ay to deal with these situation is to create lock whenever a block of code needs synchronization.		
//A second issue could be in the logic of the program : there could be no fairess between Philosophers. 		
//There is also problems regarding the atomicity of transactions (see the code).		
//		 
//

