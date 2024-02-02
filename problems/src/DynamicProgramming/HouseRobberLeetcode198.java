package DynamicProgramming;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class HouseRobberLeetcode198 {
    private static int solve(int[] list, int index, Map<Integer, Integer> dpMap) {
        if (index == list.length - 1) {
            return list[list.length - 1];
        }
        if (index >= list.length) {
            return 0;
        }

        if (dpMap.containsKey(index)) {
            return dpMap.get(index);
        }

        int includeSum = solve(list, index + 2, dpMap) + list[index];
        int excludeSum = solve(list, index + 1, dpMap);
        dpMap.put(index, Math.max(includeSum, excludeSum));
        return Math.max(includeSum, excludeSum);
    }

    private static int solveBottomUp(int[] list) {
        Map<Integer, Integer> dpMap = new HashMap<>();
        dpMap.put(0, list[0]);
        if (list.length > 1) {
            dpMap.put(1, Math.max(list[1], dpMap.get(0)));
        }
        for (int i = 2; i < list.length; i++) {
            dpMap.put(i, Math.max(dpMap.get(i - 2) + list[i], dpMap.get(i - 1)));
        }
        System.out.println(dpMap);
        return dpMap.get(list.length - 1);
    }
    public static void main(String[] args) {
        int[] list = new int[]{2, 1, 1, 2};
        System.out.println(solve(list, 0, new HashMap<>()));
        System.out.println(solveBottomUp(list));
    }
}
