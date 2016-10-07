package base;

import java.util.Date; //Importing Date as a data field

public class Account {

	private int id = 0; //id set as default to 0
	private double balance = 0; //balance set as default to 0
	private double annualInterestRate = 0; //Should apply to all accounts as Rate and default 0
	private Date dateCreated;
	
	//Establish Account Constructor
	public Account(){
		super();
	}
	
	public Account(int idInput, double balanceInput){
		super();
		this.id = idInput;
		this.balance = balanceInput;
	}
	//Accessors and Mutators
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public Date getDateCreated() {
		return dateCreated;
	}
	//Methods
	public double getMonthlyInterestRate(){ //Divides annual rate by 12 for monthly rates
		return (annualInterestRate / 12);
	}
	public double withdraw(double requested) throws InsufficientFundsException { //Withdraws money/ chance to spring exception
		if (requested <= balance){
			balance -= requested;
			return balance;
		}
		else {
			double exception = requested - balance;
			throw new InsufficientFundsException(exception);
		}
		
	}
	public double deposit(double money){ //Deposits money/ does not except $0 or less
		if (money > 0){
			balance += money;
			return balance;
		}
		else return balance;
	}
	
}
