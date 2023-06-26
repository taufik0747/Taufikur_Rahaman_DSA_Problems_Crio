import java.util.*;


public class Solution {

    public static List<Integer> filterEven(List<Integer> inputList) {
       for (int i = inputList.size() - 1; i >= 0; i--) {
            if (inputList.get(i) % 2 == 0) {
                inputList.remove(i);
            }
        }
        return inputList;
    }

    public static void main(String args[]) {
        List<Integer> inputList = new LinkedList<>(Arrays.asList(1, 2, 6, 7, 9, 10));
        List<Integer> expectedOutputList = new LinkedList<>(Arrays.asList(1, 7, 9));
        assert filterEven(inputList).equals(expectedOutputList) : "Expect [1,7,9] from [1,2,6,7,9,10]";
        System.out.println("All test cases in main function passed");

    }
}

