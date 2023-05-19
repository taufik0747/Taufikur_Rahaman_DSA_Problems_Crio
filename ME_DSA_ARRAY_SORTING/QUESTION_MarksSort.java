import java.util.*;

class Student {
    int id;
    String name;
    int marks[] = new int[5];

    public Student(int id, String name, int marks[]) {
        this.id = id;
        this.name = name;

        for (int i = 0; i < 5; i++) {
            this.marks[i] = marks[i];
        }
    }
}

class MarksSort {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Student arr[] = new Student[n];

        for (int i = 0; i < n; i++) {

            int id = sc.nextInt();
            String name = sc.next();
            int marks[] = new int[5];

            for (int j = 0; j < 5; j++)
                marks[j] = sc.nextInt();
            arr[i] = new Student(id, name, marks);
        }

        int res[] = marksSort(n, arr);

        for (int j : res) {
            System.out.print(j + " ");
        }
    }

    static int[] marksSort(int n, Student arr[]) {
Arrays.sort(arr, new Comparator<Student>() {
            
            public int compare(Student s1, Student s2) {
                int sum1 = getSum(s1);
                int sum2 = getSum(s2);

                if (sum1 != sum2) {
                    return Integer.compare(sum2, sum1); // Sort by sum of marks (descending)
                } else {
                    int nameCompare = s1.name.compareTo(s2.name);
                    if (nameCompare != 0) {
                        return nameCompare; // Sort alphabetically by name (ascending)
                    } else {
                        return Integer.compare(s1.id, s2.id); // Sort by student ID (ascending)
                    }
                }
            }

            private int getSum(Student s) {
                int sum = 0;
                for (int mark : s.marks) {
                    sum += mark;
                }
                return sum;
            }
        });

        int[] sortedIds = new int[n];
        for (int i = 0; i < n; i++) {
            sortedIds[i] = arr[i].id;
        }

        return sortedIds;
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