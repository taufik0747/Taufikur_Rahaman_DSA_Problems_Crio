import java.util.*;

public class Solution {

    public static boolean isogram(String s) {
      // Create a HashSet to store characters seen so far
        Set<Character> seenChars = new HashSet<>();

        // Iterate through each character in the string
        for (char ch : s.toCharArray()) {
            // If the character is already present in the set, it's not an isogram
            if (seenChars.contains(ch)) {
                return false;
            }

            // Add the character to the set
            seenChars.add(ch);
        }

        // All characters are unique, it's an isogram
        return true;
    }

    public static void main(String args[]) {

      assert (isogram("aba") == false) : "Expect false for s = \"aba\"" ;
      System.out.println("All test cases in main function passed");

    }
}

