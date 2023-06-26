import java.util.*;

public class Solution {

    static String jeeResult(String marks) {
       String[] marksArray = marks.split(" ");
        List<Integer> scores = new ArrayList<>();

        for (String mark : marksArray) {
            scores.add(Integer.parseInt(mark));
        }

        int lowestScore = Collections.min(scores);
        int highestScore = Collections.max(scores);

        return highestScore + " " + lowestScore;
    }

    public static void main(String args[]) {

      assert (jeeResult("4 2 -13 4 5").equals("5 -13")) :  "Expect \"5 -13\" for s=\"4 2 -13 4 5\"" ;
      System.out.println("All test cases in main function passed");

    }
}

