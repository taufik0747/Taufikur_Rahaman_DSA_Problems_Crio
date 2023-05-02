import java.util.*;

class SpiralMatrixII {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result[][] = spiralMatrixII(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int[][] spiralMatrixII(int A) {
        int[][] matrix=new int[A][A];
        int sr=0,er=A-1,sc=0,ec=A-1;
        int n=1;
        while(n<=A*A){
            //1st Direction  left to right
        for(int col=sc;col<=ec;col++){
            matrix[sr][col]=n++;
        }
        sr++;
        if(n>A*A){
            break;
        }
        //2nd Direction Top to Bottom
        for(int row=sr;row<=er;row++){
            matrix[row][ec]=n++;
        }
        ec--;
        if(n>A*A){
            break;
        }
        //3rd Direction Right to Left
        for(int col=ec;col>=sc;col--){
            matrix[er][col]=n++;
        }
        er--;
        if(n>A*A){
            break;
        }
        //4th Direction Bottom to Top
        for(int row=er;row>=sr;row--){
            matrix[row][sc]=n++;
        }
        sc++;
        }
        return matrix; 
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