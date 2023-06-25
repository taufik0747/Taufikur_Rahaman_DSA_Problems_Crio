import java.util.*;

public class Solution {

    static String swchags(String name) {
         String upperCaseName = name.toUpperCase();

        if (upperCaseName.startsWith("T")) {
            return name + " is eligible";
        } else {
            return name + " is not eligible";
        }
    
    }

    public static void main(String args[]) {
        String name = "Taylor";
        assert (swchags(name).equals("Taylor is eligible")) : "Expect \"Taylor is eligible\" for name = \"Taylor\"";
        name = "Lucy";
        assert (swchags(name).equals("Lucy is not eligible")) : "Expect \"Lucy is eligible\" for name = \"Lucy\"";
        System.out.println("All test cases in main function passed");

    }
}

