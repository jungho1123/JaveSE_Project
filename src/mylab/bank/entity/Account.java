package mylab.bank.entity;

import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

/**
 * Account 클래스
 * 패키지: mylab.bank.entity
 * 설명: 모든 계좌의 기본이 되는 추상 클래스
 * 주요 기능:
 * 기본적인 계좌 정보(계좌번호, 소유자, 잔액) 관리
 * 입금(deposit)과 출금(withdraw) 기능 제공
 * 데이터: 계좌번호(accountNumber), 계좌소유자 이름(ownerName), 현재 잔액(balance)
 */
public class Account {
    private String accountNumber;
    private String ownerName;
    private double balance;


    public Account(String accountNumber, double balance, String ownerName) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.ownerName = ownerName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getOwnerName() {
        return ownerName;
    }
    public void deposit(double amount){
        if(amount <= 0){
            throw new IllegalArgumentException(" 입금액은 양수");
        }
        this.balance += amount;
        System.out.println(amount+"원이 입금되었습니다. 현재 잔액"+balance);
    }
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount <= 0){
            throw new IllegalArgumentException("출금액은 양수");
        }
        if (this.balance<amount){
            throw new InsufficientBalanceException("잔액이 부족합니다");
        }
        this.balance -= amount;
        System.out.println(amount+"원이 출금 되었습니다 현재 잔액"+balance);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}
