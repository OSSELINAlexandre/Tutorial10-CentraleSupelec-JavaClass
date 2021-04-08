package Question7;


public class Philosopher extends Thread {

	private String name;
	private Chopstick rightChopstick;
	private Chopstick leftChopstick;
	private Integer apetite;
	private DiningPhilosophers theDinnerConditions;
	private int finalAmount;
	private Integer maxAmountPossibleToEat;
	private Integer alreadyEaten;
	private Boolean threadIsFinished;

	public Philosopher(DiningPhilosophers theDinnerConditions, String name, Chopstick left, Chopstick right,
			Integer Apetite) {
		super();
		this.name = name;
		this.rightChopstick = right;
		this.leftChopstick = left;
		this.theDinnerConditions = theDinnerConditions;
		this.apetite = Apetite;
		this.alreadyEaten = 0;
		this.maxAmountPossibleToEat = 0;
		this.threadIsFinished = false;
		this.theDinnerConditions.addAPhilo(this);
	}

	@Override
	public String toString() {
		return "Philosopher : " + name;
	}


	public int getMaxAmountPossibleToEat() {
		return maxAmountPossibleToEat;
	}

	public int getAlreadyEaten() {
		return alreadyEaten;
	}

	public String getTheName() { 
		return name;
	}

	public Chopstick getRightChopstick() {
		return rightChopstick;
	}

	public Chopstick getLeftChopstick() {
		return leftChopstick;
	}
	

	public Boolean getThreadIsFinished() {
		return threadIsFinished;
	}


	@Override
	public void run() {
		
		maxAmountPossibleToEat = (int) (theDinnerConditions.getAmountFood() / theDinnerConditions.getDinningPhilosophers().size());

			while (alreadyEaten != maxAmountPossibleToEat ) {

			if (!theDinnerConditions.getFedPhilosopher().contains(this) || theDinnerConditions.getFedPhilosopher() == null
					
				|| !threadIsFinished	) {	
				//This last condition is usefull in the case that if all other threads 
// finished, and it still requires one iteration of this current thread in order to have a
// alreadyEaten = maxAmountPossibleToEat;
				
				
				if (leftChopstick.isFree()) {

					leftChopstick.Reserved();

					if (rightChopstick.isFree()) {

						rightChopstick.Reserved();

						theDinnerConditions.getaPhilosopherEatingAtTheTime().lock();

						if (alreadyEaten == maxAmountPossibleToEat ) {
							theDinnerConditions.getaPhilosopherEatingAtTheTime().unlock();

							break;
						}

						theDinnerConditions.getFedPhilosopher().add(this);
						int randomAmount = ((int) ((Math.random() * this.apetite) + 1));

						if ((alreadyEaten + randomAmount) < maxAmountPossibleToEat) {
					
							alreadyEaten += randomAmount;
	
							theDinnerConditions.getaPhilosopherEatingAtTheTime().unlock();

						} else {

							alreadyEaten = maxAmountPossibleToEat;
							theDinnerConditions.getaPhilosopherEatingAtTheTime().unlock();
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
		returnTheFinalAmount(theDinnerConditions.getAmountFood()); 														
		this.threadIsFinished = true;
	}

	public void returnTheFinalAmount(int amount) {
		this.finalAmount = amount;
	}

	public int getTheFinalAmount() {
		return finalAmount;
	}

}
