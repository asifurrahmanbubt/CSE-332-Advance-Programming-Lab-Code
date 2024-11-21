// 22234103353
import java.util.Scanner;
import java.util.InputMismatchException;

class InvalidGradeException extends Exception {
    public InvalidGradeException(String message) {
        super(message);
    }
}

public class GradeCalculator_22234103353 {
    public static double calculateGrade(int subject1, int subject2, int subject3) throws InvalidGradeException {
        if (subject1 < 0 || subject1 > 100 || subject2 < 0 || subject2 > 100 || subject3 < 0 || subject3 > 100) {
            throw new InvalidGradeException("Marks must be between 0 and 100.");
        }
        return (subject1 + subject2 + subject3) / 3.0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter marks for three subjects: ");
            int subject1 = scanner.nextInt();
            int subject2 = scanner.nextInt();
            int subject3 = scanner.nextInt();

            double grade = calculateGrade(subject1, subject2, subject3);
            System.out.println("Average Grade: " + grade);

        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter numeric values for marks!");
        } catch (InvalidGradeException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
