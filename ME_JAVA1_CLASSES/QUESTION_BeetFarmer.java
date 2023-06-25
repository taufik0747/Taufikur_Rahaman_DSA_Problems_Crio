import java.util.*;

public class Solution {
    private int numberOfBeetsSold;
    private int costPricePerBeet;
     private int sellingPricePerBeet;

     public Solution(int numberOfBeetsSold,int costPricePerBeet,int sellingPricePerBeet){
         this.numberOfBeetsSold=numberOfBeetsSold;
         this.costPricePerBeet=costPricePerBeet;
         this.sellingPricePerBeet=sellingPricePerBeet;
     }
     public int Profit(){
         int profit=(sellingPricePerBeet-costPricePerBeet)* numberOfBeetsSold;
         return profit;

     }



    public static void main(String args[]) {
        int numberOfBeetsSold = 2;
        int costPricePerBeet = 3;
        int sellingPricePerBeet = 4;
        Solution obj = new Solution(numberOfBeetsSold, costPricePerBeet, sellingPricePerBeet);
        assert obj.Profit() == 2 : "Expect 2 for (2,3,4)";
        System.out.println("All test cases in main function passed");
    }
}

