import java.util.*;

public class Solution {

    public static boolean isEqual(int a, int b) {
        // if(a==b){
        //     return true;
        // }
        // else{
        //     return false;
        // }
        boolean isEqual= a==b;
        return isEqual;
    }

    public static void main(String args[]) {
        assert (isEqual(100, 100) == true) : "Expect true for a = 100, b = 100";
        assert(isEqual(89,11)==false): "Expect false for a=89,b=11";
        assert(isEqual(-1,1)==false): "Expect false for a=-1, b=1";
        assert(isEqual(0,0)==true): "Expect true for a=0, b=0";
        System.out.println("All test cases in main function passed");
    }
}

