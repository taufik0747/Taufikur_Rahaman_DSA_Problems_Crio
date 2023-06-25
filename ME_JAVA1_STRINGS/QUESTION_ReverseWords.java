import java.util.*;

public class Solution {

    static String reverseWords(String string) {
         StringBuilder sb = new StringBuilder(string);
        return sb.reverse().toString();
    }

    public static void main(String args[]) {
        String string = "Cat";
        assert (reverseWords(string).equals("taC")) : "Expect \"taC\" for string = \"Cat\"";
        string = "cart";
        assert (reverseWords(string).equals("trac")) : "Expect \"trac\" for string = \"cart\"";
        System.out.println("All test cases in main function passed");

    }
}

