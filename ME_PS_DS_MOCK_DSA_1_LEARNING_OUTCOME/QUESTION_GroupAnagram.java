import java.util.*;

class GroupAnagram {

    public List<List<String>> groupAnagram(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<String>());
            }
            map.get(sorted).add(s);
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> list : map.values()) {
            result.add(list);
        }
        return result;
    }

    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        String strs[] = new String[n];
        for(int i = 0 ; i < n ;i++) {
            strs[i] = scanner.next();
        }
        List<List<String>> result = new GroupAnagram().groupAnagram(strs);

        for (int i = 0; i < result.size(); ++i) {
            for (int  j = 0; j < result.get(i).size(); ++j) {
                System.out.printf("%s ", result.get(i).get(j));
            }
            System.out.printf("\n");
        }
    }
}
