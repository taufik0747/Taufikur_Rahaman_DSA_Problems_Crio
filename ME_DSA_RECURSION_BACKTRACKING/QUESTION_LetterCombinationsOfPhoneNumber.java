import java.io.*;
import java.util.*;

public class LetterCombinationsOfPhoneNumber {
    private List<String> output = new ArrayList<>();
    private Map<Character, String> phoneMap = new HashMap<>();

    public LetterCombinationsOfPhoneNumber() {
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
    }

    private void backtrack(String combination, String nextDigits) {
        if (nextDigits.length() == 0) {
            output.add(combination);
        } else {
            char digit = nextDigits.charAt(0);
            String letters = phoneMap.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phoneMap.get(digit).substring(i, i + 1);
                backtrack(combination + letter, nextDigits.substring(1));
            }
        }
    }

    public List<String> letterCombinationsOfPhoneNumber(String digits) {
        if (digits.length() == 0) {
            return output;
        }
        backtrack("", digits);
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String digits = in.readLine().trim();
        if (digits.isEmpty()) {
            System.out.println("null");
            return;
        }
        List<String> combinations = new LetterCombinationsOfPhoneNumber().letterCombinationsOfPhoneNumber(digits);
        
        // Joining all combinations with a space and printing them in one go
        System.out.println(String.join(" ", combinations));
    }
}
