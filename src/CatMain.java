public class CatMain {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Cat1", 2, 5);
        Cat cat2 = new Cat("Cat2", 3, 7);

        cat1.goEat();
        cat2.goSleep();

        System.out.println(cat1 + "\n" + cat2);
    }
}
