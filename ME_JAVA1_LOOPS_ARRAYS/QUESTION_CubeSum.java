import java.util.*;

public class Solution {

    public static int cubeSum(int[] arr) {
      int sum=0;
      for(int i:arr){
        if(i%2==0){
          int cube=(int)Math.pow(i,3);
          sum+=cube;
        }
      }
      return sum;
     
    }

    public static void main(String args[]) {

      assert cubeSum(new int[] { 1, 2, 3, 4 }) == 72 : "Expect 72 for {1,2,3,4}";
      System.out.println("All test cases in main function passed");

    }
}

