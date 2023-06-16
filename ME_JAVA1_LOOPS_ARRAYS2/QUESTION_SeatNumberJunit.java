import java.util.*;

public class Solution {

    public static int findFriendSeatNo(String[] arr1, String[] arr2) {
        String mridula="Mridula";
        String friend=null;
        int seatNumber=-1;
        for(String name: arr1){
            if(name.equals(mridula)){
                break;
            }
            friend=name;
        }
        for(int i=0;i<arr2.length;i++){
            if(arr2[i].equals(friend)){
                seatNumber=i;
                break;
            }
        }
        return seatNumber;
        
    }

    public static void main(String args[]) {

        String arr1[] = {"Raghu", "Goli", "Farhat", "Mridula", "Rahul"};
        String arr2[] = {"Mridula", "Raghu", "Goli", "Farhat"};
        assert findFriendSeatNo(arr1, arr2) == 3 : "Expect 3 for ([\"Raghu\", \"Goli\", \"Farhat\", \"Mridula\", \"Rahul\"],[\"Mridula\", \"Raghu\", \"Goli\", \"Farhat\"])";
        System.out.println("All test cases in main function passed");

    }
}

