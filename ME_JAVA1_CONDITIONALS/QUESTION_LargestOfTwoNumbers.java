import java.util.*;

public class Solution {

  public static int findLargest(int a, int b) {
      if(a>b){
        return a;
      }
      else{
        return b;
      }
      

  }

  public static void main(String args[]) {
        assert (findLargest(1, 9) == 9) : "Expect 9 for a = 1, b = 9";
        System.out.println("All test cases in main function passed");

    }
}

