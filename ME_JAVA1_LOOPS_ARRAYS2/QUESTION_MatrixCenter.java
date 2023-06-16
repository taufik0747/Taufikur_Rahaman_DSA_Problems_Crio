import java.util.*;

public class Solution {

    public static Integer matrixCenter(int[][] m) {
        int rows = m.length;
        int columns = m[0].length;

        if (rows % 2 == 0 || columns % 2 == 0) {
            // If either row or column length is even, there is no center
            return null;
        }

        int centerRow = rows / 2;
        int centerColumn = columns / 2;

        return m[centerRow][centerColumn];
    }
    
    public static void main(String args[]) {

        assert (matrixCenter(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }) == 5) : "Expect 5 from { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }";
        System.out.println("All test cases in main function passed");

    }
}

