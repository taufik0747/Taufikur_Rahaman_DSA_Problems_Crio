// import java.util.*;


// class KthSmallestElementInMatrix{
//     public static void main(String args[]){
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int k = sc.nextInt();
//         List<ArrayList<Integer>>Matrix = new ArrayList<ArrayList<Integer>>();
//         for (int i = 0; i < n; i++) {
//             ArrayList<Integer>row = new ArrayList<>();
//             for (int j = 0; j < n; j++) {
//                 row.add(sc.nextInt());
//             }
//             Matrix.add(row);
//         }
//         int ans = kthSmallestElementInMatrix(Matrix,k);
//         System.out.print(ans);
//     }
//     static int findLessOrEqualInRow(ArrayList<Integer> row, int element){
//         int count=0;
//         for(int col=0;col<row.size();col++){
//             if(row.get(col)>element){
//                 break;
//             }
//             count++;
//         }
//         return count;
//     }
// static int countOfElementsLessOrEqual(List<ArrayList<Integer>>matrix, int element){
//         int n=matrix.size();
//         int count=0;
//         for(int row=0;row<n;row++){
//             if(matrix.get(row).get(0)>element){
//                 break;
//             }
//             else if(matrix.get(row).get(n-1)<=element){
//                 count+=n;
//             }
//             else{
//             count+=findLessOrEqualInRow(matrix.get(row),element);
//             }

//         }
//         return count;
//     }

// static int kthSmallestElementInMatrix(List<ArrayList<Integer>>matrix, int k){
//         int n=matrix.size();
//         int beg=matrix.get(0).get(0), end=matrix.get(n-1).get(n-1);
//         int ans=end;
//         while(beg<=end){
//             int mid=beg+(end-beg)/2;
//             int count=countOfElementsLessOrEqual(matrix,mid);
//             if(count==k){
//                 ans=mid;
//                 end=mid-1;
//             }
//             else if(count<k){
//                 beg=mid+1;
//             }
//             else if(count>k){
//                 end=mid-1;
//             }

//         }
//         return ans;
//     }
// }
// import java.util.*;

// class KthSmallestElementInMatrix {
//     public static void main(String args[]) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int k = sc.nextInt();
//         int[][] matrix = new int[n][n];
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 matrix[i][j] = sc.nextInt();
//             }
//         }
//         int ans = kthSmallestElementInMatrix(matrix, k);
//         System.out.print(ans);
//     }

//     static int countOfElementsLessOrEqual(int[][] matrix, int element) {
//         int n = matrix.length;
//         int count = 0;
//         int row = n - 1;
//         int col = 0;
//         while (row >= 0 && col < n) {
//             if (matrix[row][col] <= element) {
//                 count += row + 1; // Count all elements in the current column (including the current element)
//                 col++;
//             } else {
//                 row--; // Move to the previous row
//             }
//         }
//         return count;
//     }

//     static int kthSmallestElementInMatrix(int[][] matrix, int k) {
//         int n = matrix.length;
//         int beg = matrix[0][0];
//         int end = matrix[n - 1][n - 1];
//         int ans = end;
//         while (beg <= end) {
//             int mid = beg + (end - beg) / 2;
//             int count = countOfElementsLessOrEqual(matrix, mid);
//             if (count >= k) {
//                 ans = mid;
//                 end = mid - 1;
//             } else {
//                 beg = mid + 1;
//             }
//         }
//         return ans;
//     }
// }
import java.util.*;

class KthSmallestElementInMatrix {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int ans = kthSmallestElementInMatrix(matrix, k);
        System.out.print(ans);
    }

    static int findLessOrEqualInRow(int[] row, int element) {
        int count = 0;
        int left = 0;
        int right = row.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (row[mid] <= element) {
                count = mid + 1;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return count;
    }

    static int countOfElementsLessOrEqual(int[][] matrix, int element) {
        int n = matrix.length;
        int count = 0;
        for (int row = 0; row < n; row++) {
            count += findLessOrEqualInRow(matrix[row], element);
        }
        return count;
    }

    static int kthSmallestElementInMatrix(int[][] matrix, int k) {
        int n = matrix.length;
        int beg = matrix[0][0];
        int end = matrix[n - 1][n - 1];
        int ans = end;
        while (beg <= end) {
            int mid = beg + (end - beg) / 2;
            int count = countOfElementsLessOrEqual(matrix, mid);
            if (count >= k) {
                ans = mid;
                end = mid - 1;
            } else {
                beg = mid + 1;
            }
        }
        return ans;
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