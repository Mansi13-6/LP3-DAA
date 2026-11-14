import java.util.*;

class EightQueens {
    static int[] board = new int[8];

    static boolean safe(int r, int c) {
        for (int i = 0; i < 8; i++)
            if (board[i] != -1 &&
                    (board[i] == c || Math.abs(i - r) == Math.abs(board[i] - c)))
                return false;
        return true;
    }

    static boolean solve(int r) {
        if (r == 8)
            return true;
        if (board[r] != -1)
            return solve(r + 1);
        for (int c = 0; c < 8; c++)
            if (safe(r, c)) {
                board[r] = c;
                if (solve(r + 1))
                    return true;
                board[r] = -1;
            }
        return false;
    }

    public static void main(String[] args) {
        Arrays.fill(board, -1);
        Scanner sc = new Scanner(System.in);
        System.out.print("First queen row and column (0-7): ");
        int r = sc.nextInt(), c = sc.nextInt();
        board[r] = c;
        if (solve(0))
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++)
                    System.out.print(board[i] == j ? "Q " : " . ");
                System.out.println();
            }
        else
            System.out.println("No solution for this fixed position.");
    }

}

// Python code

// N=8 
// board=[-1]*N#board[row]=column 
// first_row=int(input("First queen row (0-7): "))
// first_col=int(input("First queen column (0-7): "))
// board[first_row]=first_col

// def safe(row, col):
//  for r in range(N):
//  c = board[r]
//  if c != -1 and (c == col or abs(r-row) == abs(c-col)):
//  return False
//  return True

// def solve(row=0):
//  if row == N: return True
//  if board[row] != -1: return solve(row+1)
//  for col in range(N):
//  if safe(row, col):
//  board[row] = col
//  if solve(row+1): return True
//  board[row] = -1
//  return False
// if solve():
//  for r in range(N):
//  print(" ".join("Q" if board[r] == c else "." for c in range(N)))
// else:
//  print("No solution for this fixed position.")
