import java.io.*;
import java.util.*;

class MockSortColors {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0;
        int high = nums.length - 1;
        
        while (mid <= high) {
            switch (nums[mid]) {
                case 0: {
                    // Swap nums[low] and nums[mid]
                    int temp = nums[low];
                    nums[low] = nums[mid];
                    nums[mid] = temp;
                    low++;
                    mid++;
                    break;
                }
                case 1:
                    mid++;
                    break;
                case 2: {
                    // Swap nums[mid] and nums[high]
                    int temp = nums[mid];
                    nums[mid] = nums[high];
                    nums[high] = temp;
                    high--;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = scanner.nextInt();

        MockSortColors result = new MockSortColors();
        result.sortColors(nums);
        for (int i = 0; i < nums.length; i++)
            System.out.printf("%d ", nums[i]);
    }
}
