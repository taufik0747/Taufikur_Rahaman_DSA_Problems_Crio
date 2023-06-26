import java.util.*;

public class Solution {

    static boolean anagramCouples(String s1, String s2) {

     // Convert names to lowercase and remove any whitespace
        s1 = s1.toLowerCase().replaceAll("\\s", "");
        s2 = s2.toLowerCase().replaceAll("\\s", "");

        // Convert names to character arrays and sort them
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        Arrays.sort(s1Chars);
        Arrays.sort(s2Chars);

        // Compare the sorted character arrays
        return Arrays.equals(s1Chars, s2Chars);
    }


    public static void main(String args[]) {
        String s1 = "Liam";
        String s2 = "mila";
        assert anagramCouples(s1, s2) == true : "Expect true for s1 = \"Liam\" and s2 = \"mila\"";
        s1 = "Sia";
        s2 = "Sam";
        assert anagramCouples(s1, s2) == false: "Expect false for s1 = \"Sia\" and s2 = \"Sam\"";
        System.out.println("All test cases in main function passed");
    }
}

