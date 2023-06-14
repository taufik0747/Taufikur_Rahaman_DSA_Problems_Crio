import java.util.*;

public class Solution {

    public static String theNextZombie(String[] array) {
        for(int i=0;i<array.length;i++){
            if(array[i].equals("Zombie")){
                return "Run away "+array[i+1]+"!";
            }

        }
        return "";
    }

    public static void main(String args[]) {
        String[] array = { "Anil", "Zombie", "Pulkit", "Chinmay" };
        assert (theNextZombie(array).equals("Run away Pulkit!")) : "Expect \"Run away Pulkit!\" for array = {\"Anil\",\"Zombie\",\"Pulkit\",\"Chinmay\"} ";
        System.out.println("All test cases in main function passed");
    }
}

