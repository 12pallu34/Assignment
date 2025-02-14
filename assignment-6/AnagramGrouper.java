import java.util.*;
public class AnagramGrouper {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user for input
        System.out.println("Enter words separated by spaces:");
        String input = scanner.nextLine();
        
        // Split the input into an array of words
        String[] words = input.split("\\s+");
        
        // Group anagrams
        List<List<String>> anagramGroups = groupAnagrams(words);
        
        // Print the grouped anagrams
        System.out.println("Grouped Anagrams:");
        for (List<String> group : anagramGroups) {
            System.out.println(group);
        }
        scanner.close();
    }
    public static List<List<String>> groupAnagrams(String[] words) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String word : words) {
            // Sort the characters of the word to create a key
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);
            
            // Add the word to the corresponding anagram group
            anagramMap.putIfAbsent(sortedWord, new ArrayList<>());
            anagramMap.get(sortedWord).add(word);
        }
        // Return the grouped anagrams as a list of lists
        return new ArrayList<>(anagramMap.values());
    }
}