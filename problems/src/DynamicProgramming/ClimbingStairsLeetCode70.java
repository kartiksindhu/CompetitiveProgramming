package DynamicProgramming;

import java.util.HashMap;

public class ClimbingStairsLeetCode70 {
    private static HashMap<Integer, Integer> map = new HashMap<>();
    public static int solve(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int result = solve(n - 1) + solve(n - 2);
            map.put(n, result);
            return result;
        }
    }
    public static void main(String[] args) {
        System.out.println(solve(30));
    }
}
