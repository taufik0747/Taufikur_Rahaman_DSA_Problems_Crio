import java.util.*;

public class Solution {

  static Boolean balancedToken(String name) {
    name = name.toLowerCase();

        // Create a HashMap to store the frequency of each character
        Map<Character, Integer> charFrequency = new HashMap<>();

        // Iterate through each character in the name and update the frequency map
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            charFrequency.put(ch, charFrequency.getOrDefault(ch, 0) + 1);
        }

        // Check if all frequencies are the same
        Set<Integer> frequencySet = new HashSet<>(charFrequency.values());
        return frequencySet.size() <= 1;
    }

  

  public static void main(String args[]) {
    assert balancedToken("Dererd") == true : "Expect true for input =\"Dererd\"";
    System.out.println("All test cases in main function passed");
  }
}

