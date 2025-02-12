//Write a function to count the number of times each word appears in a given paragraph.

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class wordcount {
    public static Map<String, Integer> countWords(String paragraph) {
        // Convert the paragraph to lowercase to make the count case-insensitive
        paragraph = paragraph.toLowerCase();

        // Replace punctuation with spaces
        paragraph = paragraph.replaceAll("[\\p{Punct}]", " ");

        // Split the paragraph into words
        String[] words = paragraph.split("\\s+");

        // Create a map to hold the word counts
        Map<String, Integer> wordCount = new HashMap<>();

        // Count the occurrences of each word
        for (String word : words) {
            if (!word.isEmpty()) { // Check for empty strings
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        return wordCount;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user for input
        System.out.println("Please enter a paragraph:");
        String paragraph = scanner.nextLine(); // Read the entire line of input
        
        // Count the words in the paragraph
        Map<String, Integer> wordCounts = countWords(paragraph);
        
        // Print the word counts in a dictionary-like format
        System.out.print("{");
        int count = 0;
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.print("'" + entry.getKey() + "': " + entry.getValue());
            count++;
            if (count < wordCounts.size()) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
        
        // Close the scanner
        scanner.close();
    }
}