package DynamicProgramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CountDerangementsCodingNinjas {
    static int mod = (int) (Math.pow(10, 9) + 7);
    private static long solve(int n, Map<Integer, Long> dpMap) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (dpMap.containsKey(n)) {
            return dpMap.get(n);
        }
        Long ans = (((n - 1) % mod * (solve(n - 1, dpMap) % mod + solve(n - 2, dpMap) % mod)) % mod) % mod;
        dpMap.put(n, ans);
        return dpMap.get(n);
    }

    private static Long solveBottomUp(int n) {
        Map<Integer, Long> dpMap = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            dpMap.put(i, 0L);
        }
        dpMap.put(0, 0L);
        dpMap.put(1, 0L);
        dpMap.put(2, 1L);
        for (int i = 3; i <= n; i++) {
            dpMap.put(i, ((i - 1) % mod * (dpMap.get(i - 1) % mod + dpMap.get( i - 2) % mod) % mod) % mod);
        }
        return dpMap.get(n);
    }

    public static void main(String[] args) {
        System.out.println(solve(744, new HashMap<>()));
        System.out.println(solveBottomUp(744));
    }
}
