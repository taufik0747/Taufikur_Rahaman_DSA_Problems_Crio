import java.util.*;

class FractionalKnapsack {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // Number of items
        int w = sc.nextInt();  // Capacity of knapsack

        int[] wt = new int[n];  // Array to store weights
        int[] val = new int[n];  // Array to store values
        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }

        // Output the maximum value to six decimal places
        System.out.println(String.format("%.6f", fractionalKnapsack(n, w, wt, val)));
        sc.close();
    }

    static double fractionalKnapsack(int n, int capacity, int[] wt, int[] val) {
        // Create an array of items
        ItemValue[] itemValues = new ItemValue[n];
        for (int i = 0; i < n; i++) {
            itemValues[i] = new ItemValue(wt[i], val[i], i);
        }

        // Sorting items by cost in descending order
        Arrays.sort(itemValues, (a, b) -> b.cost.compareTo(a.cost));

        double totalValue = 0;  // Total maximum value achievable within the given capacity

        // Process each item according to sorted order by value-to-weight ratio
        for (ItemValue iv : itemValues) {
            int currentWeight = (int)iv.wt;
            int currentValue = (int)iv.val;

            if (capacity - currentWeight >= 0) {
                // If the knapsack can still carry the full item weight
                capacity -= currentWeight;
                totalValue += currentValue;
            } else {
                // If the knapsack can carry only a fraction of the item weight
                totalValue += ((double)capacity / currentWeight) * currentValue;
                break;  // The knapsack is full
            }
        }

        return totalValue;
    }

    // Helper class to store item details along with value-to-weight ratio
    static class ItemValue {
        Double cost;
        double wt, val, ind;
  
        public ItemValue(int wt, int val, int ind) {
            this.wt = wt;
            this.val = val;
            this.ind = ind;
            cost = (double) val / wt;
        }
    }
}
