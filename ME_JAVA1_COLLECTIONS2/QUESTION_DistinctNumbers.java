import java.util.*;

public class Solution {

  static int[] distinctNumbers(int[] arr) {
     Set<Integer> seen = new LinkedHashSet<>();
    List<Integer> result = new ArrayList<>();

    for (int num : arr) {
      if (!seen.contains(num)) {
        seen.add(num);
        result.add(num);
      }
    }

    // Convert the list back to an array
    int[] distinctArr = new int[result.size()];
    for (int i = 0; i < result.size(); i++) {
      distinctArr[i] = result.get(i);
    }

    return distinctArr;
  }

  public static void main(String args[]) {
    assert Arrays.equals(new int[] { 3, 2, 1, 11 }, distinctNumbers(new int[] { 3, 2, 3, 3, 1, 11, 11, 1, 2, 3 })) : "Expect {3, 2, 1, 11} for arr={ 3, 2, 3, 3, 1, 11, 11, 1, 2, 3 }";
    System.out.println("All test cases in main function passed");
  }
}

