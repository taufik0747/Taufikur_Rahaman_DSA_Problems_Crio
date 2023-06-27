import java.util.*;

public class Solution {
     private Map<String, String> dictionary;

    public Solution() { // constructor
        // your code
        dictionary = new HashMap<>();

    }

    public void addWord(String key, String value) {
        // your code
        dictionary.put(key.toLowerCase(), value);
    }

    public String lookUp(String key) {
        // your code
        
        String meaning = dictionary.getOrDefault(key.toLowerCase(), "No entry found for " + key);
        return meaning;
    }

    public static void main(String args[]) {

        Solution dict = new Solution();
        dict.addWord("Mango", "A yellow colored fruit");
        assert (dict.lookUp("Mango").equals("A yellow colored fruit")) : "Expect \"A yellow colored fruit\" when looking up \"Mango\"";
        assert (dict.lookUp("Kiwi").equals("No entry found for Kiwi")) : "Expect \"No entry found for Kiwi\" when looking up \"Kiwi\"";

        System.out.println("All test cases in main function passed");

    }
}

