// 22234103353
import java.util.Scanner;

public class ArrayDivision_22234103353 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = {10, 20, 30, 40, 50};

        try {
            System.out.println("Enter the index of the array to access: ");
            int index = scanner.nextInt();

            try {
                System.out.println("Enter the number to divide the element by: ");
                int divisor = scanner.nextInt();

                int result = array[index] / divisor;
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Error: Division by zero is not allowed!");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index is out of bounds!");
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid number!");
        } finally {
            scanner.close();
        }
    }
}
