import java.util.*;

public class Solution {

    static int doraCakes(double days) {
        return (int) (days/2);
    }

    public static void main(String args[]) {
        double number = 5.0;
        assert doraCakes(number) == 2 : "Expect 2 for days = 5.0";
        number = 2.2;
        assert doraCakes(number) == 1 : "Expect 1 for days = 2.2";
        System.out.println("All test cases in main function passed");

    }
}

