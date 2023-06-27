import java.util.*;

public class Solution {

    static int modeFrequency(int[] arr) {
         Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Calculate the frequency of each element in the array
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Find the element with the maximum frequency
        int maxFrequency = 0;
        for (int frequency : frequencyMap.values()) {
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
            }
        }

        return maxFrequency;
    
    }

    public static void main(String args[]) {
        int[] arr = { 3, 3, 3, 3, 1 };
        assert (modeFrequency(arr) == 4) : "Expect 4 for arr = { 3, 3, 3, 3, 1 }";
        System.out.println("All test cases in main function passed");
    }
}

