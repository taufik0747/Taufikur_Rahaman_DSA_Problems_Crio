import java.util.*;

public class Solution {

    static String findLanguage(String country) {
       Map<String, String> languageMap = new HashMap<>();
        languageMap.put("Australia", "English");
        languageMap.put("England", "English");
        languageMap.put("Brazil", "Portuguese");
        languageMap.put("China", "Chinese");
        languageMap.put("France", "French");
        languageMap.put("Spain", "Spanish");
        languageMap.put("Germany", "German");
        languageMap.put("Japan", "Japanese");
        languageMap.put("Greece", "Greek");
        languageMap.put("India", "Hindi");

        return languageMap.get(country);

    }

    public static void main(String args[]) {

      assert findLanguage("Australia").equals("English") : "Expect \"English\" for country = \"Australia\"";
      System.out.println("All test cases in main function passed");

    }
}

