package chapter5.oop.good;

public abstract class Employee {
    private String name;
    protected double salary;

    // 추상이 붙는 순간 스스로 객체 생성이 안된다.
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return this.name;
    }

    public double getSalary() {
        return this.salary;
    }

    //abstract method (추상메서드 : body가 없고 , 선언만 한 메서드)
    public abstract void manageSalary(double rate);
}
