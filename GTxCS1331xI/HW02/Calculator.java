import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int int1 = 0;
        int int2 = 0;
        double double1 = 0.0;
        double double2 = 0.0;
        String word1 = "";
        String word2 = "";
        System.out.println("List of operations: add subtract multiply divide alphabetize");
        System.out.println("Enter an operation:");
        String operation = input.next().toLowerCase();
        if (operation.equals("add") || operation.equals("subtract")) {
            System.out.println("Enter two integers:");
            try {
                int1 = input.nextInt();
                int2 = input.nextInt();
            } catch(Exception e) {
                operation = "";  //clear operation for error message
            }
        }
        else if (operation.equals("multiply") || operation.equals("divide")) {
            System.out.println("Enter two doubles:");
            double1 = input.nextDouble();
            double2 = input.nextDouble();
        }
        else if (operation.equals("alphabetize")) {
            System.out.println("Enter two words:");
            word1 = input.next().toLowerCase();
            word2 = input.next().toLowerCase();
        }
        switch (operation) {
            case "add":
                System.out.printf("Answer: %d\n", (int1 + int2));
                break;
            case "subtract":
                System.out.printf("Answer: %d\n", (int1 - int2));
                break;
            case "multiply":
                System.out.printf("Answer: %.2f\n", (double1 * double2));
                break;
            case "divide":
                if (double2 == 0.0) {
                    System.out.println("Invalid input entered. Terminating...");
                }
                else {
                    System.out.printf("Answer: %.2f\n", (double1 / double2));
                }
                break;
            case "alphabetize":
                if (word1.compareTo(word2) == 0){
                    System.out.println("Chicken or Egg.");
                }
                else if (word1.compareTo(word2) > 0){
                    System.out.printf("Answer: %s comes before %s alphabetically.\n", word2, word1);
                }
                else {
                    System.out.printf("Answer: %s comes before %s alphabetically.\n", word1, word2);
                }
                break;
            default:
                System.out.println("Invalid input entered. Terminating...");
        }
    }
}
