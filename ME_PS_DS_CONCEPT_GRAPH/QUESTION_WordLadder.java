import java.io.*;
import java.util.*;

class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                char[] wordArray = word.toCharArray();
                for (int j = 0; j < wordArray.length; j++) {
                    char originalChar = wordArray[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue; // Skip if the character is the same
                        wordArray[j] = c;
                        String newWord = new String(wordArray);
                        if (newWord.equals(endWord)) {
                            return level + 1;
                        }
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            queue.add(newWord);
                            visited.add(newWord);
                        }
                    }
                    wordArray[j] = originalChar;
                }
            }
            level++;
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String beginWord = scanner.nextLine();
        String endWord = scanner.nextLine();
        
        int n = Integer.parseInt(scanner.nextLine()); // Read the number of words
        List<String> wordList = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            String word = scanner.next();
            wordList.add(word);
        }

        scanner.close();

        int result = new WordLadder().ladderLength(beginWord, endWord, wordList);
        System.out.println(result);
    }
}
