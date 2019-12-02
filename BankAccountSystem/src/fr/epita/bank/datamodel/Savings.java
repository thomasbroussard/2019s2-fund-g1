package fr.epita.bank.datamodel;

public class Savings extends Account {
	
	double interrestRate;

	public double computeInterestForCurrentMonth() {
		return this.interrestRate * this.getBalance() ;
	
	}
	
	public void withDraw(double amount) {
		this.setBalance(this.getBalance() - amount);
		return;
	}
	
	
}
