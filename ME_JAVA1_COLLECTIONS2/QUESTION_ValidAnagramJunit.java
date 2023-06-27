import java.util.*;

public class Solution {

    static boolean isValidAnagram(String s, String t) {
         if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> charFrequency = new HashMap<>();

        // Count the frequency of characters in string s
        for (char c : s.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        // Decrement the frequency of characters in string t
        for (char c : t.toCharArray()) {
            int frequency = charFrequency.getOrDefault(c, 0);
            if (frequency == 0) {
                return false; // Character not present in string s
            }
            charFrequency.put(c, frequency - 1);
        }

        // Check if all characters have zero frequency
        for (int frequency : charFrequency.values()) {
            if (frequency != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {

        String a1 = "anagram";
        String a2 = "nagaram";
        assert (isValidAnagram(a1, a2) == true) : "Expect true for Strings : anagram & nagaram";

        String b1 = "rat";
        String b2 = "car";
        assert (isValidAnagram(b1, b2) == false): "Expect false for Strings : rat & car";
        System.out.println("All test cases in main function passed");

    }
}

