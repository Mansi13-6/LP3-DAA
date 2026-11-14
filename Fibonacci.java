import java.util.Scanner;
class Fibonacci {
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 System.out.print("Enter number of terms: ");
 int n = sc.nextInt();
 long a = 0, b = 1;
 int steps = 0;
 for (int i = 0; i < n; i++) {
 System.out.print(a + " ");
 long next = a + b;
 a = b; b = next;
 steps++;
 }
 System.out.println("\\nComputational loop steps: " + steps);
 System.out.println("Time: O(n), Space: O(1)");
 }
}

//Python code

// n = int(input("Enter number of terms: "))
// a, b = 0, 1
// steps = 0
// for i in range(n):
//     print(a, end=" ")
//     a, b = b, a + b
//     steps += 1
// print("\\nComputational loop steps:", steps)
// print("Time complexity: O(n), Space complexity: O(1)")
