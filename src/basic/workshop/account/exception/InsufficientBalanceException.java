package basic.workshop.account.exception;

/**
 * Account 의 잔액 부족할 떄 사용되는 사용자정의 exception클래스
 */
public class InsufficientBalanceException extends Exception {
    private int currentBalance;

    public InsufficientBalanceException(String errMessage, int currentBalance) {
        // 부모 클래스의 생성자를 호출한다
        super(errMessage);
        this.currentBalance = currentBalance;
    }

    public int getCurrentBalance() {
        return this.currentBalance;
    }

}
