import java.util.*;

public class Solution {

    public static String combineStrings(String s1, String s2) {
         // Create a HashSet to store distinct characters
        Set<Character> distinctChars = new HashSet<>();

        // Add characters from the first string to the set
        for (char ch : s1.toCharArray()) {
            distinctChars.add(ch);
        }

        // Add characters from the second string to the set
        for (char ch : s2.toCharArray()) {
            distinctChars.add(ch);
        }

        // Convert the set to a sorted list
        List<Character> sortedChars = new ArrayList<>(distinctChars);
        Collections.sort(sortedChars);

        // Convert the sorted list to a string
        StringBuilder result = new StringBuilder();
        for (char ch : sortedChars) {
            result.append(ch);
        }

        return result.toString();
    }

    public static void main(String args[]) {

        assert combineStrings("aaab", "bjjj").equals("abj") : "Expect \"abj\" for (\"aaab\",\"bjjj\")";
        System.out.println("All test cases in main function passed");

    }
}

