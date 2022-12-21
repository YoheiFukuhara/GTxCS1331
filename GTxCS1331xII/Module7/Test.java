public class Test {
    public static void main(String[] args) {
        Canine pixy;
        pixy = new Poodle("pixy", 4, "aaa", "bbb");
        pixy.bark();
        ((Poodle)pixy).enterDogShow();

        Dog dg = new Dog("name", 1);
        //Dog dg;
        //dg = new Poodle("pixy", 4, "aaa", "bbb");
        ((Poodle)dg).enterDogShow();
    }
}