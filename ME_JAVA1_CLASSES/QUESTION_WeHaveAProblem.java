import java.util.*;

public class Solution {

    public String firstName;
    public String lastName;
    public String fullName;

    public Solution(String first, String last) { // Constructor
        this.firstName = first;
        this.lastName = last;
    }
        public String getFirstName(){
            return firstName;
        } 
        public String getLastName(){
            return lastName;
        }
         public String getFullName(){
            return (firstName+" "+lastName);
        }
        
       
        

    


    public static void main(String args[]) {
        Solution robot = new Solution("Wall", "E");
        assert(robot.getFirstName().equals("Wall")) : "Expect first name = \"Wall\" for name = \"Wall E\" ";
        assert(robot.getLastName().equals("E")) : "Expect last name = \"E\" for name = \"Wall E\" ";
        assert(robot.getFullName().equals("Wall E")) : "Expect full name = \"Wall E\" for name = \"Wall E\" ";
        System.out.println("All test cases in main function passed");

    }
}

