import java.util.Scanner;

public class ValidateIPv4 {
    public static boolean isValidIPv4(String ip) {
        String[] parts = ip.split("\\.");
        if (parts.length != 4) {
            return false; // Must have exactly 4 parts
        }
        for (String part : parts) {
            try {
                int num = Integer.parseInt(part);
                if (num < 0 || num > 255) {
                    return false; // Each part must be in the range 0-255
                }
                // Check for leading zeros
                if (part.length() > 1 && part.startsWith("0")) {
                    return false; // Leading zeros are not allowed
                }
            } catch (NumberFormatException e) {
                return false; // Not a valid number
            }
        }
        return true; // All checks passed, it's a valid IPv4 address
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user for input
        System.out.println("Please enter an IP address:");
        String ipAddress = scanner.nextLine(); // Read the entire line of input
        
        // Validate the IP address
        boolean isValid = isValidIPv4(ipAddress);
        
        // Output the result
        System.out.println("Is the IP address valid? " + isValid);
        scanner.close();
    }
}
