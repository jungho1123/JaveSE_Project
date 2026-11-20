package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;
//출금 한도 관리 기능
public class CheckingAccount extends Account {
    private double withdrawalLimit;

    public CheckingAccount(String accountNumber, double balance, String ownerName, double withdrawalLimit) {
        super(accountNumber, balance, ownerName);
        this.withdrawalLimit = withdrawalLimit;
    }

    public double getWithdrawalLimit() {
        return withdrawalLimit;
    }
    @Override
    public void  withdraw(double amount) throws InsufficientBalanceException{
        if (amount > withdrawalLimit) {
            throw new WithdrawalLimitExceededException("출금 한도 초과 한도: "+withdrawalLimit);
        }
        super.withdraw(amount);
    }

    @Override
    public String toString() {
        return super.toString()+"CheckingAccount{" + "withdrawalLimit=" + withdrawalLimit + '}';}
}