// 22234103353
class UnderageException extends Exception {
    public UnderageException(String message) {
        super(message);
    }
}

public class VotingChecker_22234103353 {
    public static void checkEligibility(int age) throws UnderageException {
        if (age < 18) {
            throw new UnderageException("Age is less than 18. Not eligible to vote.");
        }
        System.out.println("Eligible to vote!");
    }

    public static void main(String[] args) {
        try {
            checkEligibility(16); // Example: Age less than 18
        } catch (UnderageException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
