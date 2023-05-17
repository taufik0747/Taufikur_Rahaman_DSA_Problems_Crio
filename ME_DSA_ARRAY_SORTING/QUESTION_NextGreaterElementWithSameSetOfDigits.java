import java.util.*;

class NextGreaterElementWithSameSetOfDigits{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n;
        n=sc.nextInt();
        System.out.print(nextGreaterElementWithSameSetOfDigits(n));
    }

    static int nextGreaterElementWithSameSetOfDigits(int n){
        // convert the number to a string for easier manipulation
        //convert the string to a character array for manipulation
        char digits[]=(Integer.toString(n)).toCharArray();
        //step1:check if the digits are in descending order
        int i;
        for( i=digits.length-1;i>0;i--){
            if(digits[i-1]<digits[i]){
                break;
            }
        }
        if(i==0){
            //Digits are in descending order, no next greater number is possible 
            return -1;
        }
        //step2:find the digit to be swapped
        int x= digits[i-1];
        int smallest=i;

        //step3:Find the smallest digit greater than x to be swapped with
        for(int j=i+1;j<digits.length;j++){
            if(digits[j]>x && digits[j]<=digits[smallest]){
                smallest=j;
            }
        }
        //step4:Swap the digit
        char temp=digits[i-1];
        digits[i-1]=digits[smallest];
        digits[smallest]=temp;
        //step5:Sort the digits after the swapped digit
        Arrays.sort(digits,i,digits.length);
        //Convert the character
        int nextGreater=Integer.parseInt(new String(digits));
        return nextGreater;
    }
}


/* 
  Crio Methodology
  
  Milestone 1: Understand the problem clearly
  1. Ask questions & clarify the problem statement clearly.
  2. *Type down* an example or two to confirm your understanding of the input/output & extend it to test cases
  
  Milestone 2: Finalize approach & execution plan
  1. Understand what type of problem you are solving.
       a. Obvious logic, tests ability to convert logic to code
       b. Figuring out logic
       c. Knowledge of specific domain or concepts
       d. Knowledge of specific algorithm
       e. Mapping real world into abstract concepts/data structures
  2. Brainstorm multiple ways to solve the problem and pick one
  3. Get to a point where you can explain your approach to a 10 year old
  4. Take a stab at the high-level logic & *type it down*.
  5. Try to offload processing to functions & keeping your main code small.
  
  Milestone 3: Code by expanding your pseudocode
  1. Have frequent runs of your code, dont wait for the end
  2. Make sure you name the variables, functions clearly.
  3. Avoid constants in your code unless necessary; go for generic functions, you can use examples for your thinking though.
  4. Use libraries as much as possible
  
  Milestone 4: Prove to the interviewer that your code works with unit tests
  1. Make sure you check boundary conditions
  2. Time & storage complexity
  3. Suggest optimizations if applicable
  */