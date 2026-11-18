package workshop.animal.entity;

public class Cat extends Animal implements Pet {
    private String catName;
    public Cat(String catName) {
        super(4);
        this.catName=catName;
    }
    public Cat(){
        this("");
    }


    @Override
    public void eat() {
        System.out.println("고양이가 밥을 먹어요.");
    }

    @Override
    public String getName() {
        return catName;
    }

    @Override
    public void setName(String name) {
        this.catName=name;


    }

    @Override
    public void play() {
        System.out.println("야옹?");

    }
}
