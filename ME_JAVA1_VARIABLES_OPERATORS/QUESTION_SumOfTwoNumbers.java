import java.util.*;

public class Solution {

    public static int sumOfTwoNumbers(int a, int b) {
        int sum=a+b;
        return sum;
    }

    public static void main(String args[]) {
        assert (sumOfTwoNumbers(100, 566) == 666) : "Expect 666 for a = 100, b = 566";
        assert(sumOfTwoNumbers(89,11)==100): "Except 100 for a=89, b=11";
        assert(sumOfTwoNumbers(-100,1)==-99): "Except -99 for a=-100 ,b=1";
        assert(sumOfTwoNumbers(0,0)==0): "Except 0 for a=0,b=0";
        System.out.println("All test cases in main function passed");

    }
}

