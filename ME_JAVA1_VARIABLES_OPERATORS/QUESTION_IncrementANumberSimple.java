import java.util.*;

public class Solution {

    static int incrementNumberSimple(int a) {
        return a+1;
    }

    public static void main(String args[]) {

        assert incrementNumberSimple(899) == 900 : "Expect 900 for a = 899";
        assert incrementNumberSimple(7) == 8 : "Expect 8 for a = 7";

        System.out.println("All test cases in main function passed");

    }
}

