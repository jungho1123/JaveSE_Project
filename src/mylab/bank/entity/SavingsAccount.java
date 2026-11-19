package mylab.bank.entity;

// SavingsAccount.java - 저축 계좌 클래스
public class SavingsAccount extends Account{

    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, String ownerName, double interestRate) {
        super(accountNumber, balance, ownerName);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }
    public void applyInterestRate(){
        double interest=getBalance()*interestRate;
        deposit(interest);
        System.out.println("이자"+interest+"원이 입금됨 현재잔액: "+ getBalance());
    }

    @Override
    public String toString() {
        return super.toString()+"SavingsAccount{" + "interestRate=" + (interestRate*100)+'%' + '}';
    }
}