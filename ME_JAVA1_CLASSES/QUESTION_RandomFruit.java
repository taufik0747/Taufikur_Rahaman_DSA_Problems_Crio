import java.util.*;

public class Solution {
    private  String[]  Fruits={"apple","banana","orange"};
    private String Fruit;

    public Solution(){
        Random random=new Random();
        int index=random.nextInt(Fruits.length);
        Fruit=Fruits[index];
    }
    public String GetFruit(){
        return Fruit;
    }


    public static void main(String args[]) {
        Solution obj1 = new Solution();
        System.out.println(obj1.GetFruit());
        Solution obj2 = new Solution();
        System.out.println(obj2.GetFruit());
    }
}

