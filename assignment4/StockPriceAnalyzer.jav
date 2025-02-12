import java.util.Scanner;
import java.util.Stack;
public class StockPriceAnalyzer {
    public static int[] nextGreaterPrices(int[] prices) {
        int n = prices.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Initialize the result array with -1
        for (int i = 0; i < n; i++) {
            result[i] = -1;
        }

        // Iterate through the prices
        for (int i = 0; i < n; i++) {
            // While stack is not empty and the current price is greater than the price at the index stored at the top of the stack
            while (!stack.isEmpty() && prices[i] > prices[stack.peek()]) {
                // Pop the index from the stack and set the result
                int index = stack.pop();
                result[index] = prices[i];
            }
            // Push the current index onto the stack
            stack.push(i);
        }

        // The remaining indices in the stack will have no greater price, which is already set to -1
        return result;
    }
     
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt the user for the number of prices
        System.out.print("Enter the number of days: ");
        int n = scanner.nextInt();
        int[] dailyPrices = new int[n];
        
        // Prompt the user to enter the stock prices
        System.out.println("Enter the stock prices for each day:");
        for (int i = 0; i < n; i++) {
            dailyPrices[i] = scanner.nextInt();
        }
        // Calculate 111the next greater prices
        int[] nextGreater = nextGreaterPrices(dailyPrices);

        // Print the result
        System.out.println("Next greater prices:");
        for (int price : nextGreater) {
            System.out.print(price + " ");
        }
        
        // Close the scanner
        scanner.close();
    }
}