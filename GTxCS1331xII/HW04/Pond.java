public class Pond {
    public static void main(String[] args) {
        Frog peepo = new Frog("Peepo"); // default is 5 months age and 5 tongue speed
        Frog pepe = new Frog("Pepe", 10, 15);
        Frog peepaw = new Frog("Peepaw", 4.6, 5);
        Frog ryota = new Frog("Ryota");
        Fly fly1 = new Fly(1, 3);
        Fly fly2 = new Fly(6);  // default speed is 10
        Fly fly3 = new Fly();

        Frog.setSpecies("1331 Frogs");
        System.out.println(peepo);
        
        // eat fails, since frog tongue speed 5 is slower than fly speed 10
        // as a result, fly mass becomes 6(=5+1), speed becomes 11(=10+1)
        peepo.eat(fly2);
        System.out.println(fly2);

        // Peepo age 13(=5+8), tongue speed 12(5+7)
        peepo.grow(8);

        // fly2 dead
        peepo.eat(fly2);
        System.out.println(fly2);
        System.out.println(peepo);
        System.out.println(ryota);

        peepaw.grow(4);
        System.out.println(peepaw);
        System.out.println(pepe);
    }
}