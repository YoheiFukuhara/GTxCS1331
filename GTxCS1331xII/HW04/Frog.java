public class Frog {
    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;
    private static String species = "Rare Pepe";

    public Frog(String name) {
        this(name, 5, 5);
    }
    public Frog(String name, double ageInYears, double tongueSpeed) {
        this.name = name;
        this.age = (int)(ageInYears * 12);
        this.tongueSpeed = tongueSpeed;
    }
    public Frog(String name, int age, double tongueSpeed) {
        this.name = name;
        this.age = age;
        this.tongueSpeed = tongueSpeed;
    }
    public void grow() {
        grow(1);
    }
    public void grow(int month) {
        double oldTongueSpeed =this.tongueSpeed;
        if (this.age >= 30) {
            this.tongueSpeed -= month;
        } else if ((this.age + month) <= 12) {
            this.tongueSpeed += month;
        } else if ((this.age + month) <= 30) {
            if (this.age < 12) {
                this.tongueSpeed += (12 - this.age);
            }
        } else {
            this.tongueSpeed -= this.age + month - 30;
            if (this.age < 12) {
                this.tongueSpeed += (12 - this.age);
            }
        }
        if (oldTongueSpeed > 5 && this.tongueSpeed < 5) {
            this.tongueSpeed = 5;
        }
        this.age += month;
        this.isFroglet = (this.age > 1 && this.age < 7) ? true : false;
    }
    public void eat(Fly fly) {
        if (!fly.isDead()) {
            if (this.tongueSpeed > fly.getSpeed()) {
                if (fly.getMass() >= (this.age * 0.5)) {
                    this.grow(1);
                }
                fly.setMass(0);
            } else {
                fly.grow(1);
            }
        }
    }
    public static String getSpecies() {
        return species;
    }
    public static void setSpecies(String newSpecies) {
        species = newSpecies;
    }
    public String toString() {
        if (isFroglet) {
            return String.format("My name is %s and I’m a rare froglet! I’m %d months old and my tongue has a speed of %.2f.", this.name, this.age, this.tongueSpeed);
        } else {
            return String.format("My name is %s and I’m a rare frog. I’m %d months old and my tongue has a speed of %.2f.", this.name, this.age, this.tongueSpeed);
        }
    }
    public static void main(String[] args) {
        Frog frog1 = new Frog("aaa", 1, 3.2);
        System.out.println(frog1);
        frog1.grow();
        System.out.println(frog1);
        frog1.grow(20);
        System.out.println(frog1);
        frog1.grow(10);
        System.out.println(frog1);
        frog1.grow(100);
        System.out.println(frog1);
    }
}