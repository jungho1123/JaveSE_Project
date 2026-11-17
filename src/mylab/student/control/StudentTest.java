package mylab.student.control;

import mylab.student.entity.Student;
import mylab.student.exception.InvaildGradeException;

public class StudentTest {
    public static void main(String[] args) {
        Student student= new Student("1","김민수","컴공",3);
        try {
            student.setGrade(5);
        } catch (InvaildGradeException e) {
            System.out.println(e.getMessage());
        }

    }
}
