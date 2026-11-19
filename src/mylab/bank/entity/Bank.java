package mylab.bank.entity;

import java.util.ArrayList;
import java.util.List;

import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

public class Bank {
    private List<Account> accounts;
    private int nextAccountNumber;
    public Bank() {
        accounts = new ArrayList<>();
        nextAccountNumber = 1000;
    }
    public String createSavingsAccount(String ownerName,double initialBalance,double interestRate){
        String accountNumber = getNextAccountNumber();
        SavingsAccount account= new SavingsAccount(accountNumber,initialBalance,ownerName,interestRate);
        accounts.add(account);
        System.out.println("Savings account created successfully"+ account);
        return accountNumber;
    }

    public String createCheckingAccount(String ownerName,double initialBalance,double withdrawalLimit){
        String accountNumber = getNextAccountNumber();
        CheckingAccount account = new CheckingAccount(accountNumber,initialBalance,ownerName,withdrawalLimit);
        accounts.add(account);
        System.out.println("Checking account created successfully"+ account);
        return accountNumber;
    }
    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        } throw  new AccountNotFoundException("게좌번호"+accountNumber+"없음");
    }
    public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
        Account account = findAccount(accountNumber);
        account.deposit(amount);
    }
    public void withdraw(String accountNumber, double amount) throws AccountNotFoundException ,InsufficientBalanceException {
        Account account = findAccount(accountNumber);
        account.withdraw(amount);
    }
    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) throws AccountNotFoundException, InsufficientBalanceException {
        if (fromAccountNumber.equals(toAccountNumber)){
            throw new IllegalArgumentException("송금 계좌와 수신계좌가 똑같아");

        }
        Account fromAccount = findAccount(fromAccountNumber);
        Account toAccount = findAccount(toAccountNumber);
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
        System.out.println(amount+"원이"+ fromAccountNumber +"에서" + toAccountNumber+"으로 송금되었다");
    }
    public void printAllAccounts(){
        for (Account account : accounts) {
            System.out.println(account);
        }
        System.out.println("=====================");
    }
    public String getNextAccountNumber() {
        return "AC" + (nextAccountNumber++);
    }




    }


