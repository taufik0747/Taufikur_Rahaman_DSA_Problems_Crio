import java.util.*;

public class Solution {

    static int smallestValueOfArray(int[] numbers, String toReturn) {
        // int i=0;
        // int min1=numbers[0];
        // for( i=0;i<numbers.length;i++){
        //     min1=Math.min(min1,numbers[i]);
           
        // }
        // if(toReturn=="value"){
        //     return min1;
        // }
        // else if(toReturn=="index"){
        //     return i;
        // }
        //    return i; 
        int min1=numbers[0];
        int min2=0;
        for(int i=0;i<numbers.length;i++){
             if(numbers[i]<min1){
                 min1=numbers[i];
                 min2=i;
             }
        }
    
            if(toReturn.equals("value")){
                return min1;
            }
            else if(toReturn.equals("index")){
                return min2;
            }
            return -1;
        }
        
    public static void main(String args[]) {
        assert (1 == smallestValueOfArray(new int[] { 4, 2, 3, 1, 5 }, "value")) : "Expect 1 for numbers = [4, 2, 3, 1, 5] and toReturn = \"index\"";
        assert (3 == smallestValueOfArray(new int[] { 4, 2, 3, 1, 5 }, "index")) : "Expect 3 for numbers = [4, 2, 3, 1, 5] and toReturn = \"index\"";
        System.out.println("All test cases in main function passed");

    }
}

