package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class CutIntoSegmentsCodingNinjas {
    private static int solve(int n, int[] list, Map<Integer, Integer> dpMap) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return Integer.MIN_VALUE;
        }
        if (dpMap.containsKey(n)) {
            return dpMap.get(n);
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < list.length; i++) {
            int ans = solve(n - list[i], list, dpMap);
            if (ans != Integer.MIN_VALUE) {
                result = Math.max(result, ans + 1);
            }
            dpMap.put(n, result);
        }
        return result;
    }
    private static int solveBottomUp(int[] list, int n) {
        Map<Integer, Integer> dpMap = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            dpMap.put(i, Integer.MIN_VALUE);
        }
        dpMap.put(0, 0);
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < list.length; j++) {
                if (i - list[j] >= 0 && dpMap.get(i - list[j]) != Integer.MIN_VALUE) {
                    dpMap.put(i, Math.max(dpMap.get(i), dpMap.get(i - list[j]) + 1));
                }
            }
        }
        if (dpMap.get(n) < 0) {
            return 0;
        } else {
            return dpMap.get(n);
        }
    }
    public static void main(String[] args) {
        int result1 = solve(7,new int[]{5,2,2}, new HashMap<>());
        int result2 = solve(8,new int [] {3,3,3}, new HashMap<>());
        System.out.println(result1 == Integer.MIN_VALUE ? 0 : result1);
        System.out.println(result2 == Integer.MIN_VALUE ? 0 : result2);
        System.out.println(solveBottomUp(new int[]{5,2,2}, 7));
        System.out.println(solveBottomUp(new int[]{3,3,3}, 8));
    }
}
