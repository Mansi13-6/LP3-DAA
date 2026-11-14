import java.util.*;

class FractionalKnapsack {
    static class Item {
        double value, weight;

        Item(double v, double w) {
            value = v;
            weight = w;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        Item[] a = new Item[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter value and weight of item " + (i + 1) + ":");
            double value = sc.nextDouble();
            double weight = sc.nextDouble();

            a[i] = new Item(value, weight);
        }

        System.out.print("Enter knapsack capacity: ");
        double cap = sc.nextDouble();

        // Sort items by value/weight ratio in descending order
        Arrays.sort(a, (x, y) ->
            Double.compare(y.value / y.weight, x.value / x.weight)
        );

        double ans = 0;

        for (Item x : a) {
            if (cap <= 0)
                break;

            double take = Math.min(cap, x.weight);

            ans += take * (x.value / x.weight);
            cap -= take;
        }

        System.out.println("Maximum value: " + ans);

        sc.close();
    }
}

//sample output
// Enter number of items: 3
// Enter value and weight of item 1:
// 60 10
// Enter value and weight of item 2:
// 100 20
// Enter value and weight of item 3:
// 120 30
// Enter knapsack capacity: 50

//Python code

// items = [(60, 10), (100, 20), (120, 30)] # (value, weight)
// capacity = 50
// items.sort(key=lambda x: x[0] / x[1], reverse=True)
// total = 0
// for value, weight in items:
//  if capacity == 0: break
//  take = min(weight, capacity)
//  total += value * take / weight
//  capacity -= take
// print("Maximum value:", total)