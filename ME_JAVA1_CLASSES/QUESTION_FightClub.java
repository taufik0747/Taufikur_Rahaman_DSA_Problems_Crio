import java.util.*;

public class Solution {

    static class Fighter {
        public String name;
        public int health, damagePerAttack;
        public Fighter(String name, int health, int damagePerAttack) {
          this.name = name;
          this.health = health;
          this.damagePerAttack = damagePerAttack;
        }
      }

    public static String fightClub(Fighter fighter1, Fighter fighter2) {
      int attacksNeeded1=(int)Math.ceil((double) fighter2.health/fighter1.damagePerAttack);
      int attacksNeeded2=(int)Math.ceil((double) fighter1.health/fighter2.damagePerAttack);
      if(attacksNeeded1<=attacksNeeded2){
      return fighter1.name;
      }
      return fighter2.name;
    }

    public static void main(String args[]) {
        assert fightClub(new Fighter("Lew", 10, 2), new Fighter("Harry", 5, 4)).equals("Lew") : "Expect \"Lew\" for (Lew,10,2) and (Harry,5,4)";
        System.out.println("All test cases in main function passed");
    }
}

