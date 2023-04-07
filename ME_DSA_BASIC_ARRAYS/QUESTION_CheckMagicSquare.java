import java.util.*;

class CheckMagicSquare {
    // NOTE: Please do not modify this function
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int grid[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        }

        String result = checkMagicSquare(n, grid);

        System.out.println(result);

    }

    // TODO: Implement this method
    static String checkMagicSquare(int n, int[][] grid) {
        int sum=0;
        for(int col=0;col<n;col++){
            sum=sum+grid[0][col];
        }
        for(int row=1;row<n;row++){
            int rSum=0;
        for(int col=0;col<n;col++){
            rSum=rSum+grid[row][col];
        }
        if (rSum!=sum){
            return "No";
        }

    }
    for(int col=0;col<n;col++){
        int cSum=0;
    for(int row=0;row<n;row++){
        cSum=cSum+grid[row][col];
    }
    if(cSum!=sum){
        return "No";
    }
}
int dSum=0;
for(int i=0;i<n;i++){
    dSum=dSum+ grid[i][i];

}
if (dSum!=sum){
    return "No";
}
    int aSum=0;
    for(int i=0;i<n;i++){
        aSum=aSum+grid[i][n-1-i];

    }
    if(aSum!=sum){
        return "No";
    }
    return "Yes";
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