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

    public Account(String accountNumber, String ownerName, double balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public double getBalance() {
        return balance;
    }

    public void deposit(double money){
        if (money <= 0){
            throw new IllegalArgumentException("입금액은 0보다 커야 합니다");

        }
        balance += money;
        System.out.println(money + "원이 입금되었습니다. 현재 잔액: " + balance + "원");

    }
    public void withdraw(double money) throws InsufficientBalanceException {
        if (money <= 0){
            throw new IllegalArgumentException("출금 액은 양수여야합니다.");
        }
        if (money > balance) {
            throw new InsufficientBalanceException("잔액이 부족");
        }
        balance -= money;
        System.out.printf(money+"원이 출금 되었습니다. 현재 잔약: "+ balance +"원");
    }
    @Override
    public String toString() {
        return "계좌번호: " + accountNumber + ", 소유자: " + ownerName + ", 잔액: " + balance + "원";
    }
}
