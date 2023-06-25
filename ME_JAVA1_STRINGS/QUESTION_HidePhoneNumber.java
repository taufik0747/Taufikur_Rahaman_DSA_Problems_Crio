import java.util.*;

public class Solution {

    static String hidePhoneNumber(String s) {
        int length = s.length();
        StringBuilder maskedNumber = new StringBuilder();
        
        for (int i = 0; i < length - 3; i++) {
            maskedNumber.append("*");
        }
        
        maskedNumber.append(s.substring(length - 3));
        
        return maskedNumber.toString();
    }

    
    public static void main(String args[]) {
        assert (hidePhoneNumber("9090213229").equals("*******229")) : "Expect \"*******229\" when s= \"9090213229\"";
        System.out.println("All test cases in main function passed");

    }
}

