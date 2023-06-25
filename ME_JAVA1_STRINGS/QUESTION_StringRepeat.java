import java.util.*;

public class Solution {

    static String stringRepeat(String s, int n) {
         StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(s);
        }
        return result.toString();
    
    }

    public static void main(String args[]) {
        String s = "Hello";
        int n = 3;
        assert (stringRepeat(s, n).equals("HelloHelloHello")) : "Expect \"HelloHelloHello\" for s = \"Hello\" and n = 3";
        System.out.println("All test cases in main function passed");
    }
}

