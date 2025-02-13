import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ClosestReadings {

    public static int[] closestReadings(int[] readings, int target, int k) {
        // Create an array of pairs (difference, reading)
        int[][] differences = new int[readings.length][2];

        for (int i = 0; i < readings.length; i++) {
            differences[i][0] = Math.abs(readings[i] - target); // absolute difference
            differences[i][1] = readings[i]; // the reading itself
        }
        // Sort the differences array
        Arrays.sort(differences, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]); // compare by difference
                } else {
                    return Integer.compare(a[1], b[1]); // compare by reading value
                }
            }
        });

        // Extract the k closest readings
        int[] closest = new int[k];
        for (int i = 0; i < k; i++) {
            closest[i] = differences[i][1];
        }

        return closest;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for sensor readings
        System.out.print("Enter the number of sensor readings: ");
        int n = scanner.nextInt();
        int[] readings = new int[n];

        System.out.println("Enter the sensor readings:");
        for (int i = 0; i < n; i++) {
            readings[i] = scanner.nextInt();
        }

        // Input for the target value
        System.out.print("Enter the target value: ");
        int target = scanner.nextInt();

        // Input for the number of closest readings to return
        System.out.print("Enter the number of closest readings to return (k): ");
        int k = scanner.nextInt();

        // Calculate the closest readings
        int[] result = closestReadings(readings, target, k);

        // Output the result
        System.out.println("The closest readings are: " + Arrays.toString(result));

        scanner.close();
    }
}