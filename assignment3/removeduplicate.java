import java.util.HashSet;
import java.util.Scanner;rathnamma


public class removeduplicate{

    public static String removeDuplicateCharacters(String input) {
        // Use a HashSet to track characters that have already been added
        HashSet<Character> seen = new HashSet<>();
        StringBuilder result = new StringBuilder();

        // Iterate through each character in the input string
        for (char c : input.toCharArray()) {
            // If the character has not been seen, add it to the result
            if (!seen.contains(c)) {
                seen.add(c);
                result.append(c);
            }
        }

        // Convert StringBuilder to String and return
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user for input
        System.out.println("Please enter a string:");
        String input = scanner.nextLine(); // Read the entire line of input
        
        // Remove duplicate characters
        String output = removeDuplicateCharacters(input);
        
        // Display the results
        System.out.println("Original String: " + input);
        System.out.println("Modified String: " + output);
        
        // Close the scanner
        scanner.close();
    }
}