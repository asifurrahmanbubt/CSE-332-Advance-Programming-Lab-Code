import java.util.*;

public class StringOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        int wordCount = countWords(input);

        String reversedSentence = reverseSentence(input);

        String noPunctuation = removePunctuation(input);

        boolean isPalindrome = checkPalindrome(input);

        Map<Character, Integer> charFrequency = characterFrequency(input);

        System.out.println("Word count: " + wordCount);
        System.out.println("Reversed sentence: \"" + reversedSentence + "\"");
        System.out.println("Sentence without punctuation: \"" + noPunctuation + "\"");
        System.out.println("Is palindrome: " + isPalindrome);
        System.out.println("Character frequencies: " + charFrequency);
    }

    private static int countWords(String sentence) {
        String[] words = sentence.trim().split("\\s+");
        return words.length;
    }

    private static String reverseSentence(String sentence) {
        String[] words = sentence.split("\\s+");
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]);
            if (i > 0) {
                reversed.append(" ");
            }
        }
        return reversed.toString();
    }

    private static String removePunctuation(String sentence) {
        return sentence.replaceAll("[\\p{Punct}]", "");
    }

    private static boolean checkPalindrome(String sentence) {
        String cleaned = sentence.replaceAll("[\\s\\p{Punct}]", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }

    private static Map<Character, Integer> characterFrequency(String sentence) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : sentence.toCharArray()) {
            if (!Character.isWhitespace(ch) && !Character.toString(ch).matches("\\p{Punct}")) {
                frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
            }
        }
        return frequencyMap;
    }
}
