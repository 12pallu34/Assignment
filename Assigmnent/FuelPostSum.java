import java.util.Scanner;
public class FuelPostSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array size
        System.out.println("Enter the number of delivery points:");
        int m = scanner.nextInt();
        int[] fuel = new int[m];
        int[] postfixSum = new int[m];

        // Taking input for fuel consumption
        System.out.println("Enter fuel consumption at each point:");
        for (int i = 0; i < m; i++) {
            fuel[i] = scanner.nextInt();
        }

        // Compute postfix sum
        computePostfixSum(fuel, postfixSum, m);

        // Output the postfix sum array
        System.out.println("PostfixSum array:");
        for (int num : postfixSum) {
            System.out.print(num + " ");
        }

        scanner.close();
    }

    // Function to compute postfix sum
    private static void computePostfixSum(int[] fuel, int[] postfixSum, int m) {
        postfixSum[m - 1] = fuel[m - 1]; // Last element remains the same

        // Compute cumulative sum from right to left
        for (int i = m - 2; i >= 0; i--) {
            postfixSum[i] = fuel[i] + postfixSum[i + 1];
        }
    }
}

    

