import java.util.*;

public class Solution {

    static boolean isMagicSquare(int[][] arr) {
        int rowSum=0;
        int colSum=0;
        for(int i=0;i<arr.length;i++){
            rowSum=0;
            colSum=0;
            for(int j=0;j<arr[i].length;j++){
                rowSum=rowSum+arr[i][j];
                colSum=colSum+arr[j][i];
            }
            if(rowSum!=colSum){
                return false;
            }
            
        }
        int diagSum=0;
        int aDiagSum=0;
        for(int i=0;i<arr.length;i++){
            diagSum=diagSum+arr[i][i];
            aDiagSum=aDiagSum+arr[i][arr.length-1-i];
        }
        if(rowSum==diagSum && rowSum==aDiagSum){
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String args[]) {

        int[][] arr1 = {{4,9,2}, {3,5,7}, {8,1,6}};
        assert isMagicSquare(arr1) == true : "Expect true for arr = {{4,9,2}, {3,5,7}, {8,1,6}}";

        int[][] arr2 = {{4,9,2}, {3,5,9}, {8,1,6}};
        assert isMagicSquare(arr2) == false : "Expect false for arr = {{4,9,2}, {3,5,9}, {8,1,6}}";
        System.out.println("All test cases in main function passed");

    }
}

