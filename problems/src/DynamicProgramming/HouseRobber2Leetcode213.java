package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HouseRobber2Leetcode213 {
    private static int solve(int[] list, int index, Map<Integer, Integer> dpMap) {
        return 0;
    }
    private static int solveBottomUp(int[] list) {
        if (list.length == 1) {
            return list[0];
        }
        Map<Integer, Integer> dpMap = new HashMap<>();
        dpMap.put(0, list[0]);
        if (list.length > 1) {
            dpMap.put(1, Math.max(list[0], list[1]));
        }
        for (int i = 2; i < list.length - 1; i++) {
            dpMap.put(i, Math.max(dpMap.get(i - 2) + list[i], dpMap.get(i - 1)));
        }
        int firstIncluded = dpMap.get(dpMap.size() - 1);
        int[] newList = Arrays.copyOfRange(list, 1, list.length);
        dpMap = new HashMap<>();
        dpMap.put(0, newList[0]);
        for (int i = 1; i < newList.length; i++) {
            dpMap.put(i, Math.max(dpMap.containsKey(i - 2) ? dpMap.get(i - 2) + newList[i] : newList[i], dpMap.get(i - 1)));
        }
        int lastIncluded = dpMap.get(dpMap.size() - 1);
        return Math.max(firstIncluded, lastIncluded);
    }
    public static void main(String[] args) {
        int[] list = new int[]{2, 7, 9, 3, 1};
        System.out.println(solve(list, 0, new HashMap<>()));
        System.out.println(solveBottomUp(new int[]{2,1,1,2}));
    }
}
