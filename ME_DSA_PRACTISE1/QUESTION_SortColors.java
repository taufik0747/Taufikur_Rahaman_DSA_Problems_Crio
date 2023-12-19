import java.util.Scanner;

public class SortColors {

    public void sortColors(int[] nums) {
        int low = 0;        // Pointer for 0s
        int high = nums.length - 1;     // Pointer for 2s
        int curr = 0;       // Current pointer
        
        while (curr <= high) {
            if (nums[curr] == 0) {
                // Swap with the element at the low pointer
                swap(nums, curr, low);
                curr++;
                low++;
            } else if (nums[curr] == 2) {
                // Swap with the element at the high pointer
                swap(nums, curr, high);
                high--;
            } else {
                curr++;
            }
        }
    }
    
    // Helper method to swap two elements in the array
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        SortColors sortColors = new SortColors();
        sortColors.sortColors(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
        scanner.close();
    }
}
