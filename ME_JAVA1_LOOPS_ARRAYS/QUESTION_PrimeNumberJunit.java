import java.util.*;
// import static org.junit.Assert.assertEquals;

public class Solution {

    public static boolean checkPrime(int n) {
        if(n<=1){
            return false;
        }
        if(n==3 || n==2 ){
            return true;
        }
        else if(n%2==0 || n%3==0){
            return false;
        }
        for(int i=6;i<Math.sqrt(n);i=i+6){
            if((n%i==0) || (n%(i+2))==0){
                return false;
            }
        }
        
            return true;
        
    }

    public static void main(String args[]) {
        int n = 3;
        assert checkPrime(n) == true : "Expect true for n = 3";
        System.out.println("All test cases in main function passed");
    }
}

