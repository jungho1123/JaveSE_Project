package basic.workshop.account.entity;

import basic.workshop.account.exception.InsufficientBalanceException;

public class Account extends Object {
    private String custId;
    private String acctId;
    private int balance;


    public Account(String custId, String acctId, int balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("입금액은 0보다커야함");
        }
        this.balance = balance;
        this.custId = custId;
        this.acctId = acctId;

    }

    public Account(String acctId, String custId) {
        this.acctId = acctId;
        this.custId = custId;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getAcctId() {
        return acctId;
    }

    public void setAcctId(String acctId) {
        this.acctId = acctId;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("입금액은 0보다 커야함");
        }
        this.balance += amount;

    }

    public void withdraw(int amount) throws InsufficientBalanceException {
        if (amount <= 0) {
            throw new IllegalArgumentException("출금액은 0보다 커야함");
        }
        if (amount > this.balance) {
            throw new InsufficientBalanceException ("잔액이 부족합니다. 현재 잔액은: ", this.balance);
        }
        this.balance -= amount;
    }

    @Override
    public String toString() {
        return "Account{" + "custId='" + custId + '\'' + ", acctId='" + acctId + '\'' + ", balance=" + balance + '}';
    }

}
