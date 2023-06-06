import java.util.*;

public class Solution {

    public static int arithmeticOperation(int a, int b, int c, int d) {
        int sum=a+b+c;
        int diff=sum-d;
        return diff;
    }

    public static void main(String args[]) {
        assert (arithmeticOperation(10, 11, 12, 3) == 30) : "Expect 30 for a = 10, b = 11, c = 12, d = 3";
        assert (arithmeticOperation(1, -2, 3, 3) == -1) : "Expect -1 for a = 1, b = -2, c = 3, d = 3";
        assert (arithmeticOperation(-5, -9, 0, -14) == 0) : "Expect 0 for a = -5, b =-9, c = 0, d = -14";
        
        System.out.println("All test cases in main function passed");
    }
}

