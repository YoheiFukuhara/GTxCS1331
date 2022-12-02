import java.util.Scanner;
public class FahrenheitToCelsius {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Fahrenheit value and the day of the week: ");
        int fahrenheit = input.nextInt();
        String day = input.nextLine().trim();
        double celsius = (5.0/9) * (fahrenheit - 32);
        System.out.println(day + " Fahrenheit: " + fahrenheit);
        System.out.println(day + " Celsius: " + celsius);
    }
}