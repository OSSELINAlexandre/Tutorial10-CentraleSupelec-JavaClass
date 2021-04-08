package Question7;

import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.RepeatedTest;


class SecondVersionOfTest {

	@RepeatedTest(3)
	void test_multiple_Food_Amount() throws Exception {
		
		int occurences = 10;
		int something = 9000;
		int finalActual = 0;
		for(int i = 0 ; i < occurences ; i ++) {
			

		DiningPhilosophers dinningPhi = new DiningPhilosophers(something, 5, 7);
		Chopstick n1 = new Chopstick();
		Chopstick n2 = new Chopstick();
		Chopstick n3 = new Chopstick();
		Chopstick n4 = new Chopstick();
		Chopstick n5 = new Chopstick();


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
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		int actual = Socrate.getAlreadyEaten() + Platon.getAlreadyEaten() + Peterson.getAlreadyEaten() + Scruton.getAlreadyEaten() + Aquin.getAlreadyEaten();
		finalActual += actual;
		System.out.println(actual + " VS " + something);

		
		Peterson.join();
		Socrate.join();
		Scruton.join();
		Platon.join();
		Aquin.join();
		}
		
		
		assertEquals(finalActual, occurences * something);
	
	}

}
