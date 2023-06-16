import java.util.*;


public class Solution {

    public static String[] combineAllStrings(String[] s1, String[] s2) {
         int n1 = s1.length;
        int n2 = s2.length;
        String[] combined = new String[n1 * n2];
        int index = 0;

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                combined[index] = s1[i] + s2[j];
                index++;
            }
        }

        return combined;
    }
    

    public static void main(String args[]) {

        String input1[] = {"a", "c", "e"};
        String input2[] = {"b", "d", "f"};
        String output[] = {"ab", "ad", "af", "cb", "cd", "cf", "eb", "ed", "ef"};
        assert Arrays.equals(combineAllStrings(input1, input2), output) : "Expect [\"ab\", \"ad\", \"af\", \"cb\", \"cd\", \"cf\", \"eb\", \"ed\", \"ef\"] for input1 = [\"a\", \"c\", \"e\"] and input2 = [\"b\", \"d\", \"f\"]";
        System.out.println("All test cases in main function passed");

    }
}

