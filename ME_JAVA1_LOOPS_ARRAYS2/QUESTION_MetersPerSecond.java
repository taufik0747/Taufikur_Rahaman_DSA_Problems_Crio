import java.util.*;

public class Solution {

    public static double metersPerSecond(int x) {
      return (double) (x*1000)/3600;
    }

    public static void main(String args[]) {

      assert (metersPerSecond(36) == 10) : "Expect 10 for 36";
      System.out.println("All test cases in main function passed");

    }
}

