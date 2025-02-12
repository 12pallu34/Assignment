import java.util.Scanner;

public class MissingElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input array size (N-1 elements, one missing)
        System.out.println("Enter the total number of elements (N): ");
        int N = scanner.nextInt();
        
        int[] arr = new int[N - 1]; // Array of size N-1 (one number missing)
        System.out.println("Enter " + (N - 1) + " elements:");
        
        int sum = 0; // To store sum of array elements
        for (int i = 0; i < N - 1; i++) {
            arr[i] = scanner.nextInt();
            sum += arr[i]; // Calculate sum of given numbers
        }
        
        // Calculate expected sum of first N natural numbers
        int expectedSum = N * (N + 1) / 2;
        
        // Find missing number
        int missingNumber = expectedSum - sum;
        
        // Output the missing number
        System.out.println("The missing number is: " + missingNumber);
        
        scanner.close();
    }
}
