public class PrimitiveOperations {
    public static void main(String[] args) {
        int testInt = 3;
        double testDouble = 1.2;
        System.out.println("integer type: " + testInt);
        System.out.println("floating point type: " + testDouble);

        //double multiplied = testInt * testDouble;
        double multiplied = testDouble * testInt;
        System.out.printf("multiplied value: %.1f\n", multiplied);

        double castedInt = (double)testInt;
        System.out.println("casted int value: " + castedInt);

        double castedDouble = (int)testDouble;
        System.out.println("casted double value: " + castedDouble);

        char testChar = 'B';
        System.out.println("Char value: " + testChar);

        testChar += 32;
        System.out.println("Char Lower case: " + testChar);
    }
}
