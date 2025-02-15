import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

    public static boolean checkInclusion(String s1, String s2) {
        int lenS1 = s1.length();
        int lenS2 = s2.length();

        if (lenS1 > lenS2) {
            return false; // s1 cannot be a permutation of s2 if it's longer
        }

        // Frequency map for s1
        Map<Character, Integer> freqS1 = new HashMap<>();
        for (char c : s1.toCharArray()) {
            freqS1.put(c, freqS1.getOrDefault(c, 0) + 1);
        }

        // Frequency map for the first window in s2
        Map<Character, Integer> freqWindow = new HashMap<>();
        for (int i = 0; i < lenS1; i++) {
            char c = s2.charAt(i);
            freqWindow.put(c, freqWindow.getOrDefault(c, 0) + 1);
        }

        // Check the first window
        if (freqS1.equals(freqWindow)) {
            return true;
        }

        // Slide the window across s2
        for (int i = lenS1; i < lenS2; i++) {
            char charOut = s2.charAt(i - lenS1); // Character going out of the window
            char charIn = s2.charAt(i);          // Character coming into the window

            // Update the frequency map for the window
            freqWindow.put(charOut, freqWindow.get(charOut) - 1);
            if (freqWindow.get(charOut) == 0) {
                freqWindow.remove(charOut); // Remove the character if its count is zero
            }

            freqWindow.put(charIn, freqWindow.getOrDefault(charIn, 0) + 1);

            // Check if the current window matches the frequency of s1
            if (freqS1.equals(freqWindow)) {
                return true;
            }
        }

        return false; // No permutation found
    }

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean result = checkInclusion(s1, s2);
        System.out.println(result); // Expected output: true

        /*s1 = "ab";
        s2 = "eidboaoo";
        result = checkInclusion(s1, s2);
        System.out.println(result); // Expected output: false*/
    }
}