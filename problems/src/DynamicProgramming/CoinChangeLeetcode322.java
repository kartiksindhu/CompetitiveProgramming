package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinChangeLeetcode322 {
    private static int solve(List<Integer> list, int target, Map<Integer, Integer> dpMap) {
        if (target == 0) {
            return 0;
        }
        if (target < 0) {
            return Integer.MAX_VALUE;
        }
        if (dpMap.containsKey(target)) {
            return dpMap.get(target);
        }
        int minimum = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            int result = solve(list, target - list.get(i), dpMap);
            if (result != Integer.MAX_VALUE) {
                minimum = Math.min(minimum, result + 1);
            }
            dpMap.put(target, minimum);
        }
        return minimum;
    }

    private static int bottomToTopApproach(List<Integer> list, int target, HashMap<Integer, Integer> dpMap) {
        for (int i = 0; i <= target; i++) {
            dpMap.put(i, Integer.MAX_VALUE);
        }
        dpMap.put(0, 0);

        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (i - list.get(j) >= 0 && dpMap.get(i - list.get(j)) != Integer.MAX_VALUE) {
                    dpMap.put(i, Math.min(dpMap.get(i), dpMap.get(i - list.get(j)) + 1));
                }
            }
        }
        return dpMap.get(target);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 5));
        int result = bottomToTopApproach(list, 11, new HashMap<>());
        if (result != Integer.MAX_VALUE) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }
}
