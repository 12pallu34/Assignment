import java.util.Scanner;

public class CoinChange {
    
    public static int coinChange(int[] coins, int amount) {
        // Initialize the dp array with a size of amount + 1
        int[] dp = new int[amount + 1];
        
        // Fill the dp array with a large number (amount + 1)
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1; // Use amount + 1 as a representation of infinity
        }
        
        // Base case: 0 coins are needed to make amount 0
        dp[0] = 0;

        // Iterate through each coin
        for (int coin : coins) {
            for (int x = coin; x <= amount; x++) {
                dp[x] = Math.min(dp[x], dp[x - coin] + 1);
            }
        }

        // If dp[amount] is still amount + 1, it means we cannot form that amount
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for coin denominations
        System.out.print("Enter the number of coin denominations: ");
        int n = scanner.nextInt();
        int[] coins = new int[n];

        System.out.println("Enter the coin denominations:");
        for (int i = 0; i < n; i++) {
            coins[i] = scanner.nextInt();
        }

        // Input for the amount
        System.out.print("Enter the amount: ");
        int amount = scanner.nextInt();

        // Calculate the minimum number of coins
        int result = coinChange(coins, amount);
        
        // Output the result
        if (result == -1) {
            System.out.println("It is not possible to form the amount with the given coins.");
        } else {
            System.out.println("The minimum number of coins required: " + result);
        }

        scanner.close();
    }
}