package Question7;

public class Chopstick {
	
	private boolean free;
	
	public Chopstick() {
		
		this.free = true;
	}
	
	
	public boolean isFree() {
		return free;
	}


	public void Reserved() {
		this.free = false; 
	}
	
	public void Unreserved() {
		this.free = true;
	}

}
