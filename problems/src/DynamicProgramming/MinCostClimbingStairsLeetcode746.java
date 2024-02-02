package DynamicProgramming;

import com.sun.tools.jconsole.JConsoleContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.lang.Math.cos;
import static java.lang.Math.min;

public class MinCostClimbingStairsLeetcode746 {
    private static HashMap<Integer, Integer> map = new HashMap<>();

    private static int solve(List<Integer> cost, int n) {
        if (n < 0) return 0;
        if (n == 0 || n == 1) {
            return cost.get(n);
        }
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int result = cost.get(n) + Math.min(solve(cost, n - 1), solve(cost, n - 2));
            map.put(n, result);
            return result;
        }
    }

    public static void main(String[] args) {
        List<Integer> cost = new ArrayList<>(List.of(1, 100, 1, 1, 1, 100, 1, 1, 100, 1));
        System.out.println(cost);
        System.out.println(min(solve(cost, cost.size() - 1), solve(cost, cost.size() - 2)));
        System.out.println(map);
    }
}
