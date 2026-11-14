import java.util.*;

class Knapsack01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] wt = new int[n];
        int[] val = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter weight and value of item " + (i + 1) + ":");
            wt[i] = sc.nextInt();
            val[i] = sc.nextInt();
        }

        System.out.print("Enter knapsack capacity: ");
        int W = sc.nextInt();

        int[][] dp = new int[n + 1][W + 1];

        // Build DP table
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                dp[i][w] = dp[i - 1][w];

                if (wt[i - 1] <= w) {
                    dp[i][w] = Math.max(
                        dp[i][w],
                        val[i - 1] + dp[i - 1][w - wt[i - 1]]
                    );
                }
            }
        }

        System.out.println("Maximum value: " + dp[n][W]);

        sc.close();
    }
}


//python code
// weights = [2, 3, 4, 5]
// values = [3, 4, 5, 6]
// W = 5
// n = len(weights)
// dp = [[0]*(W+1) for _ in range(n+1)]
// for i in range(1, n+1):
//  for w in range(W+1):
//  dp[i][w] = dp[i-1][w]
//  if weights[i-1] <= w:
//  dp[i][w] = max(dp[i][w],
//  values[i-1] + dp[i-1][w-weights[i-1]])
// print("Maximum value:", dp[n][W])