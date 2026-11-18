package workshop.animal.entity;

public class Fish extends Animal implements Pet{

    private String name;
    public Fish (String name){
        super(0);
        this.name=name;
    }
    public void eat(){
        System.out.println("물고기가 밥을먹어요");
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void play() {
        System.out.println("물고기가 헤엄쳐요");

    }
}
