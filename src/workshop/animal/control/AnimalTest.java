package workshop.animal.control;

import workshop.animal.entity.Animal;
import workshop.animal.entity.Cat;
import workshop.animal.entity.Pet;

public class AnimalTest {
    public static void main(String[] args) {
        Cat cat1= new Cat();
        Pet cat2= new Cat();
        Animal cat3= new Cat();

        cat1.setName("라이");
        System.out.println(cat1.getName());
        cat1.play();
        cat1.eat();
        cat1.walk();
    }

}
