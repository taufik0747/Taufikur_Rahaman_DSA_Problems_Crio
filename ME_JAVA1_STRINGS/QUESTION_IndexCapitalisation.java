import java.util.*;

public class Solution {

    static String indexCapitalisation(String s, int[] ind) {
         StringBuilder sb = new StringBuilder(s);

        for (int index : ind) {
            if (index >= 0 && index < s.length()) {
                sb.setCharAt(index, Character.toUpperCase(sb.charAt(index)));
            }
        }

        return sb.toString();
    
    }

    public static void main(String args[]) {
        String s = "learn by doing";
        int[] ind = new int[] { 0, 6, 9 };
        assert (indexCapitalisation(s, ind).equals("Learn By Doing")) : "Expect \"Learn By Doing\" for s = \"learn by doing\" and ind = [0, 6, 9]";

        System.out.println("All test cases in main function passed");

    }
}

