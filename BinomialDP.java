import java.util.*;

class BinomialDP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n and k: ");
        int n = sc.nextInt(), k = sc.nextInt();
        int[][] c = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= Math.min(i, k); j++)
                if (j == 0 || j == i)
                    c[i][j] = 1;
                else
                    c[i][j] = c[i - 1][j - 1] + c[i - 1][j];
        System.out.println("Binomial coefficient: " + c[n][k]);
    }
}

//\[^nC_k = \frac{n!}{k!(n-k)!}\]

//python code
// n = int(input("Enter n: "))
// k = int(input("Enter k: "))
// C = [[0]*(k+1) for _ in range(n+1)]
// for i in range(n+1):
//  for j in range(min(i,k)+1):
//  if j == 0 or j == i:
//  C[i][j] = 1
//  else:
//  C[i][j] = C[i-1][j-1] + C[i-1][j]
// print("Binomial coefficient:", C[n][k])