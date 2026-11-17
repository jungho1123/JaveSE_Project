package basic.workshop.account.control;

import basic.workshop.account.entity.Account;
import basic.workshop.account.exception.InsufficientBalanceException;


public class AccountTest {

    public static void main(String[] args) {
//        Account account = new Account("A1100", "221-22-3477", 100000);
//
//        //        account.setCustId("A1100");
//        //        account.setAcctId("221-22-3477");
//        //
//        //        account.deposit(100000);
//
//        System.out.println(account);
//
//        account.deposit(10000);
//        System.out.println("입금 후 잔액: " + account.getBalance());
//
//        try {
//            account.withdraw(20000);
//            System.out.println("출금 후 잔액: " + account.getBalance());
//
//            // 잔액 부족 상황 테스트
//            account.withdraw(200000);
//
//        } catch (InsufficientBalanceException e) {
//
//            System.out.println(
//                    e.getMessage() + e.getCurrentBalance()
//            );
//        }
//    }
        try{
            Account account = new Account("A1100", "221-22-3477", 100000);
            System.out.println(account);

            Account account1= new Account("a1104", "493602",10000);
            System.out.println(account1);

            account1.withdraw(10000);
            account1.withdraw(100000);
        }catch (InsufficientBalanceException e)
        {
            System.out.println(e.getMessage()+e.getCurrentBalance());
        }
    }
}