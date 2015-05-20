package ch.makery.address.model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Data {
	
	private final DoubleProperty totalGrossIncome;
	private final DoubleProperty totalMonthlyDebt;
	private final DoubleProperty mortgageInterestRate;
	private final DoubleProperty term;
	private final DoubleProperty downPayment;
	
	public Data() {
		this.totalGrossIncome = new SimpleDoubleProperty(0);
		this.totalMonthlyDebt = new SimpleDoubleProperty(0);
		this.mortgageInterestRate = new SimpleDoubleProperty(0);
		this.term = new SimpleDoubleProperty(0);
		this.downPayment = new SimpleDoubleProperty(0);
	}
	
	public void setTotalGrossIncome(double grossIncome) {
		this.totalGrossIncome.set(grossIncome);
	}
	
	public double getTotalGrossIncome() {
		return totalGrossIncome.get();
	}
	
	public DoubleProperty totalGrossIncomeProperty() {
		return totalGrossIncome;
	}
	
	
	public void totalMonthlyDebt(double monthlyDebt) {
		this.totalMonthlyDebt.set(monthlyDebt);
	}
	
	public double getTotalMonthlyDebt() {
		return totalMonthlyDebt.get();
	}
	
	public DoubleProperty totalMonthlyDebtProperty() {
		return totalMonthlyDebt;
	}
	
	
	public void setMortgageInterestRate(double interestRate) {
		this.mortgageInterestRate.set(interestRate);
	}
	
	public double getMortgageInterestRate() {
		return mortgageInterestRate.get();
	}
	
	public DoubleProperty mortgageInterestRateProperty() {
		return mortgageInterestRate;
	}
	
	
	public void setTerm(double term) {
		this.term.set(term);
	}
	
	public double getTerm() {
		return term.get();
	}
	
	public DoubleProperty termProperty() {
		return term;
	}
	
	
	public void setDownPayment(double downPayment) {
		this.downPayment.set(downPayment);
	}
	
	public double getDownPayment() {
		return downPayment.get();
	}
	
	public DoubleProperty downPaymentProperty() {
		return downPayment;
	}
}
