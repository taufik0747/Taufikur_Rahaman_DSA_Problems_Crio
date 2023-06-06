import java.util.*;

public class Solution {

    public static boolean compareNumbers(int a, int b, int c) {
        if(a==b || b==c || a==c){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String args[]) {
        assert (compareNumbers(10, 99, 99) == true) : "Expect true for a = 10, b = 99, c == 99";
        System.out.println("All test cases in main function passed");

    }
}

