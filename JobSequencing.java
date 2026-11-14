import java.util.*;

class JobSequencing {
    static class Job {
        String id;
        int deadline, profit;

        Job(String i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of jobs: ");
        int n = sc.nextInt();

        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter job ID, deadline and profit for job " + (i + 1) + ":");
            String id = sc.next();
            int deadline = sc.nextInt();
            int profit = sc.nextInt();

            jobs[i] = new Job(id, deadline, profit);
        }

        // Sort jobs by profit in descending order
        Arrays.sort(jobs, (x, y) -> y.profit - x.profit);

        int max = 0;

        for (Job j : jobs) {
            max = Math.max(max, j.deadline);
        }

        String[] slot = new String[max + 1];
        int total = 0;

        // Schedule each job in the latest available slot
        for (Job j : jobs) {
            for (int t = Math.min(j.deadline, max); t >= 1; t--) {
                if (slot[t] == null) {
                    slot[t] = j.id;
                    total += j.profit;
                    break;
                }
            }
        }

        System.out.print("Job Sequence: ");

        for (int i = 1; i <= max; i++) {
            if (slot[i] != null) {
                System.out.print(slot[i] + " ");
            }
        }

        System.out.println();
        System.out.println("Maximum Profit: " + total);

        sc.close();
    }
}

//sample output
// Enter number of jobs: 5

// Enter job ID, deadline and profit for job 1:
// A 2 100

// Enter job ID, deadline and profit for job 2:
// B 1 19

// Enter job ID, deadline and profit for job 3:
// C 2 27

// Enter job ID, deadline and profit for job 4:
// D 1 25

// Enter job ID, deadline and profit for job 5:
// E 3 15



// jobs = [('A', 2, 100), ('B', 1, 19), ('C', 2, 27),
//  ('D', 1, 25), ('E', 3, 15)] # (id, deadline, profit)
// jobs.sort(key=lambda x: x[2], reverse=True)
// slots = [None] * (max(j[1] for j in jobs) + 1)
// profit = 0
// for jid, deadline, value in jobs:
//  for t in range(min(deadline, len(slots)-1), 0, -1):
//  if slots[t] is None:
//  slots[t] = jid
//  profit += value
//  break
// print("Job sequence:", [x for x in slots[1:] if x])
// print("Maximum profit:", profit)
