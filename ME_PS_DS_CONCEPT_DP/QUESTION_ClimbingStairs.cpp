#include <bits/stdc++.h>
using namespace std;

class ClimbingStairs {
public:
    int climbingStairs(int numberOfStairs) {
        if (numberOfStairs == 1) return 1;
        if (numberOfStairs == 2) return 2;
        
        int oneStepBack = 2; // This represents f(n-1) when starting to calculate from n=3
        int twoStepsBack = 1; // This represents f(n-2)
        int current = 0; // This will store the current number of ways to reach step n
        
        for (int i = 3; i <= numberOfStairs; i++) {
            current = oneStepBack + twoStepsBack; // f(n) = f(n-1) + f(n-2)
            twoStepsBack = oneStepBack; // Move one step back to n-1 for the next iteration
            oneStepBack = current; // Move one step back to n for the next iteration
        }
        
        return current;
    }
};

int main() {
    int numberOfStairs;
    cin >> numberOfStairs;
    ClimbingStairs solver;
    int result = solver.climbingStairs(numberOfStairs);
    cout << result;
    return 0;
}
