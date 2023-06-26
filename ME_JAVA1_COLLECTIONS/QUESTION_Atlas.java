import java.util.*;

public class Solution {

    public static List<String> atlas(List<String> words) {
        List<String> validWords = new ArrayList<>();

        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);

            // Check for empty string, indicating game end
            if (word.isEmpty()) {
                break;
            }

            // If it's the first word or the current word starts with the last letter of the previous word
            if (i == 0 || word.charAt(0) == validWords.get(validWords.size() - 1).charAt(validWords.get(validWords.size() - 1).length() - 1)) {
                validWords.add(word);
            } else {
                break; // Game ends if the condition is not met
            }
        }

        return validWords;
    }

    public static void main(String args[]) {
        ArrayList<String> words = new ArrayList<String>(
                Arrays.asList("budapest", "texas", "seattle", "edinburgh", "hokkaido"));
        ArrayList<String> expected = new ArrayList<String>(
                Arrays.asList("budapest", "texas", "seattle", "edinburgh", "hokkaido"));
        assert atlas(words).equals(expected) : "Expect [\"budapest\", \"texas\", \"seattle\", \"edinburgh\", \"hokkaido\"] for list = [\"budapest\", \"texas\", \"seattle\", \"edinburgh\", \"hokkaido\"]" ;
        System.out.println("All test cases in main function passed");
    }
}

