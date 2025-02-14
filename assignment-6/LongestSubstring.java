import java.util.HashMap;
import java.util.Scanner;

public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int start = 0; // Left pointer of the window

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            // If the character is already in the map, move the start pointer
            if (charIndexMap.containsKey(currentChar)) {
                // Move the start pointer to the right of the last occurrence of currentChar
                start = Math.max(charIndexMap.get(currentChar) + 1, start);
            }

            // Update the last seen index of the character
            charIndexMap.put(currentChar, end);
            // Calculate the length of the current substring
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter the string");
        String s=scanner.nextLine();
        int result=lengthOfLongestSubstring(s);
        System.out.println("Length of the longest substring without repeating characters: " + result);
        scanner.close();
    }
}