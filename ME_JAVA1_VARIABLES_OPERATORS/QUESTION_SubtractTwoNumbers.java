import java.util.*;

public class Solution {

    public static int subtractTwoNumbers(int a, int b) {
        int diff=a-b;
        return diff;
    }

    public static void main(String args[]) {
        assert (subtractTwoNumbers(766, 100) == 666) : "Expect 666 for a = 766, b = 100";
        assert (subtractTwoNumbers(89, 11) == 78) : "Expect 78 for a = 89, b = 11";
        assert (subtractTwoNumbers(-98, 9) == -107) : "Expect -107 for a = -98, b = 9";
        assert (subtractTwoNumbers(1001,-1 ) ==1002 ) : "Expect 1002 for a = 1001, b = -1";
        assert (subtractTwoNumbers(0, 0) == 0) : "Expect 0 for a = 0, b = 0";
        
        System.out.println("All test cases in main function passed");

    }
}

