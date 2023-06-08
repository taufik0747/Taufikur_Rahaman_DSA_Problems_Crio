import java.util.*;

public class Solution {

  public static String dayOfTheWeek(int day) {
    switch(day){
      case 1: 
      return "Monday";
      
      case 2:
       return "Tuesday";
       
       case 3:
       return "Wednesday";
       
       case 4:
       return "Thursday";
       
       case 5:
       return "Friday";
      
       case 6:
       return "Saturday";
      
       case 7:
       return "Sunday";
      
       
    }
    return "Invalid";
  }

  public static void main(String args[]) {
        assert (dayOfTheWeek(6).equals("Saturday")) : "Expect Saturday for day = 6";
        System.out.println("All test cases in main function passed");
    }
}

