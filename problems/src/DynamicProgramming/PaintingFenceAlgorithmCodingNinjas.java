package DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class PaintingFenceAlgorithmCodingNinjas {
    static Map<Integer, Long> dpMap = new HashMap<>();

    static int mod = (int) (Math.pow(10 ,9) + 7);

    static long addMod(long a, long b) {
        return ((a % mod) + (b % mod)) % mod;
    }

    static long mulMod(long a, long b) {
        return ((a % mod) * (b % mod)) % mod;
    }
    private static Long solve(int fence, int color, Map<Integer, Long> dpMap) {
        if (fence == 2) {
            return addMod(color, mulMod(color, color - 1));
        }
        if (fence == 1) {
            return (long) color;
        }
        if (dpMap.containsKey(fence)) {
            return dpMap.get(fence);
        }
        long ans = mulMod(color - 1, addMod(solve(fence - 2, color, dpMap), solve(fence - 1, color, dpMap)));
        dpMap.put(fence, ans);
        return dpMap.get(fence);
    }
    private static long solveBottomUp(int n, int k) {
        long var1 = k;
        long var2 = addMod(k, mulMod(k, k - 1));
        for (int i = 3; i <= n; i++) {
            long temp = var2;
            var2 = mulMod(k - 1, addMod(var1, var2));
            var1 = temp;
        }
        return var2;
    }
    public static void main(String[] args) {
        System.out.println((int) (solve(1000 ,2, new HashMap<>()) %  mod));
        System.out.println(solveBottomUp(1000, 2) %  mod);

    }
}
