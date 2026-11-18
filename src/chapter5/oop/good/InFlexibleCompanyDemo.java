package chapter5.oop.good;

import java.util.ArrayList;

public class InFlexibleCompanyDemo {
    public static void main(String[] args) {
        
//        MereClerk mereClerk1 = new MereClerk("철수", 100);
//        MereClerk mereClerk2 = new MereClerk("영희", 100);
//        Manager manager = new Manager("홍길동", 200);
//
//
//
//        System.out.println("현재 월급입니다.");
//
//        System.out.println(mereClerk1.getName() + "의 현재 월급은 " + mereClerk1.getSalary() + " 만원 입니다.");
//        System.out.println(mereClerk2.getName() + "의 현재 월급은 " + mereClerk2.getSalary() + " 만원 입니다.");
//        System.out.println(manager.getName() + "의 현재 월급은 " + manager.getSalary() + " 만원 입니다.");
//
//        System.out.println("");
//
//
//        System.out.println("올린 후의 월급입니다.");
//
//        mereClerk1.manageSalary(10);
//        System.out.println(mereClerk1.getName() + "의 현재 월급은 " + mereClerk1.getSalary() + " 만원 입니다.");
//
//        mereClerk2.manageSalary(10);
//        System.out.println(mereClerk2.getName() + "의 현재 월급은 " + mereClerk2.getSalary() + " 만원 입니다.");
//
//        manager.manageSalary(10);
//        System.out.println(manager.getName() + "의 현재 월급은 " + manager.getSalary() + " 만원 입니다.");
        Employee mereClerk1=new MereClerk("철수",100);
        Employee mereClerk2=new MereClerk("영희",100);

        Employee manager= new Manager("홀길동",200,"인사부");
        Manager manager2=new Manager("둘리",250,"개발부");

        System.out.println(manager.getName() + manager.getSalary());
        Manager m=(Manager)manager;
        m.getDepartment();

        System.out.println(manager2.getName()+manager2.getSalary()+manager2.getDepartment());

        Employee[] emps= new Employee[3];

        emps[0] = new MereClerk("철수",100);
        emps[1]= new MereClerk("영희",100);
        emps[2]= new Manager("둘디",250,"개발부");


        for (Employee emp : emps) {
            System.out.println("현재 월급입니다.");
            System.out.println(emp.getName() + "의 현재 월급은 " + emp.getSalary() + " 만원 입니다.");
        }
   }
}

