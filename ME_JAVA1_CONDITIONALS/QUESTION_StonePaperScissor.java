import java.util.*;

public class Solution {

    static String stonePaperScissor(String s1, String s2) {
      if (s1.equals(s2)) {
            return "Share it!";
        } else if ((s1.equals("Stone") && s2.equals("Scissor")) ||
                   (s1.equals("Scissor") && s2.equals("Paper")) ||
                   (s1.equals("Paper") && s2.equals("Stone"))) {
            return "Tom";
        } else {
            return "Jerry";
        }
    
    }

    public static void main(String args[]) {
        assert (stonePaperScissor("Stone", "Paper").equals("Jerry")) : "Expect \"Jerry\" for input = \" Stone\", \" Paper\" ";
        assert (stonePaperScissor("Stone", "Stone").equals("Share it!")) : "Expect \"Share it!\" for input = \" Stone\", \" Stone\" ";
      System.out.println("All test cases in main function passed");
    }
}

