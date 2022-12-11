public class Fly {
    private double mass;
    private double speed;
    public Fly() {
        this(5);
    }
    public Fly(double mass) {
        this(mass, 10);
    }
    public Fly(double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }
    public double getMass() {
        return this.mass;
    }
    public double getSpeed() {
        return this.speed;
    }
    public void setMass(double mass) {
        this.mass = mass;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    public void grow(int increasedMass) {
        if (this.mass >= 20) {
            this.speed -= (increasedMass * 0.5);
        } else if ((this.mass + increasedMass) <= 20){
            this.speed += increasedMass;
        } else {
            this.speed = this.speed + (20 - this.mass) - ((increasedMass + this.mass - 20) * 0.5);
        }
        this.mass += increasedMass;
    }
    public boolean isDead() {
        if (this.mass == 0) {
            return true;
        } else {
            return false;
        }
    }
    public String toString() {
        if (this.mass == 0) {
            return "I’m dead, but I used to be a fly with a speed of " + this.speed + ".";
        } else {
            return "I’m a speedy fly with " + this.speed + " speed and " + this.mass + " mass.";
        }
    }
    public static void main(String[] args) {
        Fly fly1 = new Fly(0, 1);
        System.out.println("fly1 Dead?  " + fly1.isDead());
        System.out.println(fly1.toString());
        Fly fly2 = new Fly();
        System.out.println(fly2.toString());
        fly2.grow(10);
        System.out.println(fly2.toString());
        fly2.grow(10);
        System.out.println(fly2.toString());
        fly2.grow(10);
        System.out.println(fly2.toString());
      }
}