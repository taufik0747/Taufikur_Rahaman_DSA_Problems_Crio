import java.util.*;

public class Solution {

  public static int findCenturyFromYear(int a) {
    // int result=a/100;
    // int remainder=a%100;
    // if(result==0){
    //   return result;
    // }
    // else if(remainder!=0){
    //   return result+remainder;
    // }
    // return result;
    // int remainder=a%100;
    // if(a==1705){
    //   return 18;
    // }
    // else if(remainder==1){
    //   return 1;
    // }

    // else{
    //   return (a/100) + (a%100);
    // }
    if(a%100==0){
      return a/100;
    }
      else if(a/100!=0){
        return a/100 +1;
      }
      else if(a>0 && a<100){
        return 1;
      }
      else{
        return (a/100) + (a%100);
      }
    }


  

  public static void main(String args[]) {
        assert (findCenturyFromYear(1705) == 18) : "Expect 18 for a = 1705";
        System.out.println("All test cases in main function passed");

    }
}

