import java.util.Arrays;

public class MaximizeBeauty {

    public static void main(String[] args) {
        // Example input
        int T = 1; // Number of test cases
        int N = 3; // Size of the array
        int K = 210; // Maximum number of operations
        int[] A = {-100, -100, 5}; // Array elements

        // Solve each test case
        for (int t = 0; t < T; t++) {
            System.out.println(maximizeBeauty(N, K, A));
        }
    }

    public static int maximizeBeauty(int N, int K, int[] A) {
        // Sort the array
        Arrays.sort(A);

        int maxBeauty = 0;

        // Iterate through the array
        for (int i = 0; i < N; i++) {
            int currentBeauty = 1; // At least 1 element can be made the same (itself)
            int remainingOperations = K;

            // Check how many elements can be made equal to A[i]
            for (int j = i + 1; j < N; j++) {
                int cost = A[j] - A[i]; // Cost to make A[j] equal to A[i]
                if (remainingOperations >= cost) {
                    currentBeauty++;
                    remainingOperations -= cost;
                } else {
                    break; // Stop if operations are exhausted
                }
            }

            // Update the maximum beauty
            maxBeauty = Math.max(maxBeauty, currentBeauty);
        }

        return maxBeauty;
    }
}
