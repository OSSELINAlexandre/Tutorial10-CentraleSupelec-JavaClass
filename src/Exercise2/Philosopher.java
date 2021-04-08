package Exercise2;



public class Philosopher extends Thread {

	private String name;
	private Chopstick rightChopstick;
	private Chopstick leftChopstick;
	private Integer apetite;
	private DiningPhilosophers theDinnerConditions;
	private int finalAmount;

	public Philosopher(DiningPhilosophers theDinnerConditions, String name, Chopstick left, Chopstick right,
			Integer Apetite) {
		super();
		this.name = name;
		this.rightChopstick = right;
		this.leftChopstick = left;
		this.theDinnerConditions = theDinnerConditions;
		this.apetite = Apetite;
		this.theDinnerConditions.addAPhilo(this);
	}

	@Override
	public String toString() {
		return "Philosopher : " + name;
	}

	public String getTheName() { // Couldn't call it getName, because already a method call like that in Thread.
		return name;
	}

	public Chopstick getRightChopstick() {
		return rightChopstick;
	}

	public Chopstick getLeftChopstick() {
		return leftChopstick;
	}

	@Override
	public void run() {

		System.out.println("Lauching it ! ");

		while (theDinnerConditions.getAmountFood() > 0) {

//			try {
//				Thread.sleep((long) (Math.random() * 1000 * theDinnerConditions.getThinkingTime()));
//				System.out.println("Philosopher " + name + " is thinking !");
//
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//It is possible to comment out these lines if you want the tests to be accelerated.							

	
			
			if (!theDinnerConditions.getFedPhilosopher().contains(this) || theDinnerConditions.getFedPhilosopher() == null) {
//I had to set a OR theDinnerConditions.getFedPhilosopher() == null; because of the theDinnerConditions.getFedPhilosopher().clear()
//in the end of this program isn't an atomic instruction. Which means that sometimes (less than 1% of the time)
// the thread was checking a condition for a list that didn't exist because the given list was in the process of being cleared by clear().				
//this led to a message error in the Test console, even though the Test was passing just fined. 
//Therefore, the client could have seen an error message, even though the program was doing fined in 99% of test cases.
//Because the FedPhilosopher()is intialize in the constructor and the setter does not exist, we do not have any fear that a program set
// the list to null before the execution of our thread. 				
				
				
				if (leftChopstick.isFree()) {

					leftChopstick.Reserved();

					if (rightChopstick.isFree()) {

						rightChopstick.Reserved();

						System.out.println("Philosopher " + name + " has two chopsticks !");

						theDinnerConditions.getaPhilosopherEatingAtTheTime().lock();
// A lock here guarantee that there is not two threads asserting that there is
// enough food for them in the same moment :
// In other words, that Philosopher 1 and Philosopher 2 both want to eat 3 units
// while there is only 3 left,
// both understanding that there is still enough food available, (which is true)
// but could lead to
// Thread interferences : one philosopher would said he ate 0.
// Putting a lock here synchronized the block of code
						if (theDinnerConditions.getAmountFood() == 0) {
							theDinnerConditions.getaPhilosopherEatingAtTheTime().unlock();
							
							
// This final call to 'unlock' is necessary, because otherwise, a thread could
// be blocked in loop and the program would never finish itself.
							
							
							break;
						}

						theDinnerConditions.getFedPhilosopher().add(this);
						int randomAmount = ((int) ((Math.random() * this.apetite) + 1));

						if (theDinnerConditions.getAmountFood() >= randomAmount) {

							theDinnerConditions.setAmountFood(theDinnerConditions.getAmountFood() - randomAmount);

							theDinnerConditions.getaPhilosopherEatingAtTheTime().unlock();

//							try {
//								Thread.sleep((long) (Math.random() * 1000 * theDinnerConditions.getEatingTime()));
//							} catch (InterruptedException e) {
//								e.printStackTrace();
//							}
//It is possible to comment out these lines if you want the tests to be accelerated.						

							System.out.println("----------------Philosopher " + name + " finished eating "
									+ randomAmount + "!----------------");

						} else {

//							try {
//								Thread.sleep((long) (Math.random() * 1000 * theDinnerConditions.getEatingTime()));
//							} catch (InterruptedException e) {
//								e.printStackTrace();
//							}
//It is possible to comment out these lines if you want the tests to be accelerated.							

							System.out.println("Last bite ! Philosopher " + name + " finished eating "
									+ theDinnerConditions.getAmountFood() + "!----------------");
							theDinnerConditions.setAmountFood(0);

							theDinnerConditions.getaPhilosopherEatingAtTheTime().unlock();
							System.out.println("There is no more food avaible.");
						}

						rightChopstick.Unreserved();

					}
					leftChopstick.Unreserved();
				}

				if (theDinnerConditions.getFedPhilosopher().size() == theDinnerConditions.getDinningPhilosophers()
						.size()) {
					theDinnerConditions.getFedPhilosopher().clear();


				}

			}

		}

		System.out.println("Finished Meal by Philosophers.");
		returnTheFinalAmount(theDinnerConditions.getAmountFood()); // Final method to simplify the test of important
																	// size
	}

	public void returnTheFinalAmount(int amount) {
		this.finalAmount = amount;
	}

	public int getTheFinalAmount() {
		return finalAmount;
	}

}
