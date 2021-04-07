package Exercise2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//I ran all these test by commenting out the times of thinking and eating of each philosophers

class PhilosopherTest {

	private DiningPhilosophers theDinner;
	private Chopstick n1;
	private Chopstick n2;
	private Chopstick n3;
	private Chopstick n4;
	private Chopstick n5;
	private Chopstick n6;
	private Chopstick n7;
	private Chopstick n8;
	private Chopstick n9;
	private Chopstick n10;
	
	@BeforeEach
	public void dinningPhilosopherTest() {
		
		theDinner = new DiningPhilosophers(30, 5, 5);
		n1 = new Chopstick();
		n2 = new Chopstick();
		n3 = new Chopstick();
		n4 = new Chopstick();
		n5 = new Chopstick();
		n6 = new Chopstick();
		n7 = new Chopstick();
		n8 = new Chopstick();
		n9 = new Chopstick();
		n10 = new Chopstick();
	}
	
	
	@Test
	void testOfTenPhilosopher() {
		
		int Hunger = 5;
		Philosopher Socrate = new Philosopher(theDinner, "Socrate", n1, n2, Hunger);
		Philosopher Platon = new Philosopher(theDinner, "Platon", n2, n3, Hunger);
		Philosopher Scruton = new Philosopher(theDinner, "Scruton", n3, n4, Hunger);
		Philosopher Aquin = new Philosopher(theDinner, "Aquin", n4, n5, Hunger);
		Philosopher Peterson = new Philosopher(theDinner, "Peterson", n5, n6, Hunger);
		Philosopher Nietzsche = new Philosopher(theDinner, "Nietzsche", n6, n7, Hunger);
		Philosopher Jung = new Philosopher(theDinner, "Jung", n7, n8, Hunger);
		Philosopher Kant = new Philosopher(theDinner, "Kant", n8, n9, Hunger);
		Philosopher Sowell = new Philosopher(theDinner, "T.Sowell", n9, n10, Hunger);
		Philosopher Hugo = new Philosopher(theDinner, "Hugo", n10, n1, Hunger);
		
		Socrate.start();
		Platon.start();
		Scruton.start();
		Aquin.start();
		Nietzsche.start();
		Peterson.start();
		Jung.start();
		Kant.start();
		Sowell.start();
		Hugo.start();
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(theDinner.getAmountFood(), 0);
	}

	
	@Test
	void testOf100Dinners() {

		
		ArrayList<Integer> test100 = new ArrayList<Integer>();
		for(int i = 0 ; i < 100; i ++) {
			//Ne serait-ce pas un sens de l'éternel retour ? 
			int randomAmountOfFood =((int) ((Math.random() * 130)));
			DiningPhilosophers anInstanceOfDinner = new DiningPhilosophers(randomAmountOfFood, 0 , 0);

			int Hunger = 5;
			Philosopher Socrate = new Philosopher(anInstanceOfDinner, "Socrate", n1, n2, Hunger);
			Philosopher Platon = new Philosopher(anInstanceOfDinner, "Platon", n2, n3, Hunger);
			Philosopher Scruton = new Philosopher(anInstanceOfDinner, "Scruton", n3, n4, Hunger);
			Philosopher Aquin = new Philosopher(anInstanceOfDinner, "Aquin", n4, n5, Hunger);
			Philosopher Peterson = new Philosopher(anInstanceOfDinner, "Peterson", n5, n6, Hunger);
			Philosopher Nietzsche = new Philosopher(anInstanceOfDinner, "Nietzsche", n6, n7, Hunger);
			Philosopher Jung = new Philosopher(anInstanceOfDinner, "Jung", n7, n8, Hunger);
			Philosopher Kant = new Philosopher(anInstanceOfDinner, "Kant", n8, n9, Hunger);
			Philosopher Sowell = new Philosopher(anInstanceOfDinner, "T.Sowell", n9, n10, Hunger);
			Philosopher Hugo = new Philosopher(anInstanceOfDinner, "Hugo", n10, n1, Hunger);
			Socrate.start();
			Platon.start();
			Scruton.start();
			Aquin.start();
			Nietzsche.start();
			Peterson.start();
			Jung.start();
			Kant.start();
			Sowell.start();
			Hugo.start();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			test100.add(Socrate.getTheFinalAmount());
			test100.add(Platon.getTheFinalAmount());
			test100.add(Scruton.getTheFinalAmount());
			test100.add(Aquin.getTheFinalAmount());
			test100.add(Nietzsche.getTheFinalAmount());
			test100.add(Peterson.getTheFinalAmount());
			test100.add(Jung.getTheFinalAmount());
			test100.add(Kant.getTheFinalAmount());
			test100.add(Sowell.getTheFinalAmount());
			test100.add(Hugo.getTheFinalAmount());
		}
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		Integer actual = 0;
		for(Integer a : test100) {
			actual += a;
		}
		assertEquals(actual, 0);
		
	}
}
