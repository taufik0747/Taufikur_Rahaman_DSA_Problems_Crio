import java.util.*;

public class Solution {

    static String switcheroo(String s) {
        s = s.replace('a', '#'); // Replace 'a' with a placeholder character '#'
        s = s.replace('b', 'a'); // Replace 'b' with 'a'
        s = s.replace('#', 'b'); // Replace the placeholder character '#' with 'b'
        return s;
    }
    

    public static void main(String args[]) {
        String s = "aabacbaa";
        assert (switcheroo(s).equals("bbabcabb")) : "Expect \"bbabcabb\" for s = \"aabacbaa\"";
        System.out.println("All test cases in main function passed");

    }
}

