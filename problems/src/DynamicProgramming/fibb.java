package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class fibb {
    static Map<Integer, Integer> mapToStoreValue = new HashMap();

    private static int solveTopDownApproach(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (mapToStoreValue.containsKey(n)) {
            System.out.println("contains: " + n);
            return mapToStoreValue.get(n);
        } else {
            int result = solveTopDownApproach(n - 1) + solveTopDownApproach(n - 2);
            mapToStoreValue.put(n, result);
            return result;
        }
    }

    public static int solveBottomUpApproach(int n, List<Integer> dpTable) {
        for (int i = 2; i <= n; i++) {
            int result = dpTable.get(i - 1) + dpTable.get(i - 2);
            dpTable.add(result);
        }
        return dpTable.get(n);
    }

    public static int solveBottomUpApproachSpaceOptimization(int n) {
        int prev2 = 0;
        int prev1 = 1;
        for (int i = 2; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        if (n == 0) {
            return 0;
        }
        return prev1;
    }

    public static void main(String[] args) {
        System.out.println(solveTopDownApproach(8));
        List<Integer> dpTable = new ArrayList<>();
        dpTable.add(0);
        dpTable.add(1);
        System.out.println(solveBottomUpApproach(8, dpTable));
        System.out.println(solveBottomUpApproachSpaceOptimization(8));
    }
}
