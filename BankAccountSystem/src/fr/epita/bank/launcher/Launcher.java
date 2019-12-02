package fr.epita.bank.launcher;

import fr.epita.bank.datamodel.Savings;

public class Launcher {
	
	public static void main(String[] args) {
		Savings savings = new Savings();
		
		double interrests = savings.computeInterestForCurrentMonth();
		System.out.println(interrests);
		
		savings.withDraw(-300);
		double finalBalance = savings.getBalance();
		System.out.println(finalBalance);
		
	}

}
