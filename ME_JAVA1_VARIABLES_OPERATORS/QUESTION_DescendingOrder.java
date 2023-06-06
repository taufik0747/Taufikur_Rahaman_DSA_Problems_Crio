import java.util.*;

public class Solution {

    public static boolean isDescending(int a, int b, int c) {
        return (a>b) && (b>c);
    }

    public static void main(String args[]) {
        assert (isDescending(10, 9, 7) == true) : "Expect true for a = 10, b = 9, c == 7";
        System.out.println("All test cases in main function passed");

    }
}

