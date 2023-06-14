import java.util.*;

public class Solution {

    static int getNthFibonacciNumber(int N) {
        while(N<=1){
            return N;
        }
        int prev=0;
        int curr=1;
        int i=2;
        while(i<=N){
            int next=prev+curr;
            prev=curr;
            curr=next;
            i++;
        }
        return curr;

    }

    public static void main(String args[]) {

        assert (getNthFibonacciNumber(3) == 2) : "Expect \"2\" for N = 3";
        assert (getNthFibonacciNumber(4) == 3) : "Expect \"3\" for N = 4";
        System.out.println("All test cases in main function passed");


    }
}

