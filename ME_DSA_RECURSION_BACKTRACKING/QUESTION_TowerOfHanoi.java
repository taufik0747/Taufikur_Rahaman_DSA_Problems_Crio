import java.util.*;

public class TowerOfHanoi {
    // List to hold the sequence of moves
    private ArrayList<String> moves;

    // Constructor to initialize the moves list
    public TowerOfHanoi() {
        this.moves = new ArrayList<>();
    }

    // Method to execute the tower of Hanoi moves
    private void executeTowerOfHanoi(int n, char fromRod, char toRod, char auxRod) {
        if (n == 1) {
            moves.add("1 " + fromRod + " " + toRod);
            return;
        }
        executeTowerOfHanoi(n - 1, fromRod, auxRod, toRod); // Move top n-1 disks from fromRod to auxRod
        moves.add(n + " " + fromRod + " " + toRod); // Move nth disk from fromRod to toRod
        executeTowerOfHanoi(n - 1, auxRod, toRod, fromRod); // Move n-1 disks from auxRod to toRod
    }

    // Public method to initiate the tower of Hanoi solution
    public ArrayList<String> towerOfHanoi(int n) {
        executeTowerOfHanoi(n, 'A', 'C', 'B'); // A is the source, C is the destination, B is the auxiliary
        return moves;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        TowerOfHanoi hanoi = new TowerOfHanoi();
        ArrayList<String> result = hanoi.towerOfHanoi(n);
        for (String move : result) {
            System.out.println(move);
        }
        scanner.close();
    }
}
