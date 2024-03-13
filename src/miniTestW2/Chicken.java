package miniTestW2;

public class Chicken implements Bird, Pig {
    @Override
    public void fly() {
        System.out.println("Tôi có thể bay nè.");
    }

    @Override
    public void eat() {
        System.out.println("Tôi ăn cám");
    }

    @Override
    public void sleep() {

    }

    public static void main(String[] args) {
        Bird bird = new Chicken();
        Pig pig = new Chicken();

        bird.fly();
        pig.eat();
    }
}
