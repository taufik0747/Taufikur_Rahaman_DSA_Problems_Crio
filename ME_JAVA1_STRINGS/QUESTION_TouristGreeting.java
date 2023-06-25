import java.util.*;

public class Solution {

    static String touristGreeting(String nationality) {
         if (nationality.toLowerCase().equals("wonderland")) {
            return "Welcome back!";
        }

        return String.format("Welcome to Wonderland, citizen from %s!", nationality);

       

    }

    public static void main(String args[]) {
        String nationality = "Wakanda";
        assert (touristGreeting(nationality).equals("Welcome to Wonderland, citizen from Wakanda!")) : "Expect \"Welcome to Wonderland, citizen from Wakanda!\" for nationality = \"Wakanda\"";
        nationality = "Wonderland";
        assert (touristGreeting(nationality).equals("Welcome back!")) : "Expect \"Welcome back!\" for nationality = \"Wonderland\"";
      System.out.println("All test cases in main function passed");
    }
}

