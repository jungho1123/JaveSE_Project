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

}
