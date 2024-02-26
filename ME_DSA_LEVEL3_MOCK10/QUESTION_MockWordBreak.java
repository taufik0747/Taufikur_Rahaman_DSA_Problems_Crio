import java.io.*;
import java.util.*;

class MockWordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        
        int n = scanner.nextInt();
        scanner.nextLine(); // consume the leftover newline
        List<String> wordDict = new ArrayList<>();
        for(int i = 0 ; i < n ; ++i) {
            String word = scanner.nextLine(); 
            wordDict.add(word);
        }

        boolean result = new MockWordBreak().wordBreak(s, wordDict);
        System.out.println(result);
    }
}
