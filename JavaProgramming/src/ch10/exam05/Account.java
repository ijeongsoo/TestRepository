package ch10.exam05;

public class Account {
	private long balance;
	
	public void deposit(int money){
		balance+=money;
	}
	
	public void withdraw(int money) throws BalanceINsufficientException{
		if(balance < money){
			//throw new BalanceINsufficientException();
			throw new BalanceINsufficientException("ÀÜ°í ºÎÁ·");
		}
		balance-=money;
	}

	public long getBalance() {
		return balance;
	}
	
	
}
