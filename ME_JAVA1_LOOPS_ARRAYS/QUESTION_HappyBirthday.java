import java.util.*;

public class Solution {

    static String happyBirthday(int gifts){
        String[] gifts_response = {"Hardly any", "We need some more gifts", "Woah that's a lot of gifts!", "Happy Birthday Jhandu!!!"};
    
        String respond = gifts <= 5 ? gifts_response[0]  : gifts < 23 ? gifts_response[1] : gifts == 23 ? gifts_response[3] : gifts_response[2];
    
        return respond;
        
        
    }

    public static void main(String args[]) {
        int gifts = 99;
        assert happyBirthday(gifts).equals("Woah that's a lot of gifts!") : "Expect \"Woah that's a lot of gifts!\" for gifts=100";
        gifts = 23;
        assert happyBirthday(gifts).equals("Happy Birthday Jhandu!!!") : "Expect \"Happy Birthday Jhandu!!!\" for gifts=23";
        System.out.println("All test cases in main function passed");

    }
}

