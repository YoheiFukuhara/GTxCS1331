public class EqualityTest {
    public static void main(String[] args) {
        String x = "park";
        String y = new String ("park");

        if (x == y) {
            System.out.println("x and y are aliases");
        }

        if (x != y) {
            System.out.println("x and y are not aliases");
        }

        if (x.equals(y)) {
            System.out.println("x and y are the same contents");
            System.out.println("x: " + x);
            System.out.println("y: " + y);
        }
    }
}