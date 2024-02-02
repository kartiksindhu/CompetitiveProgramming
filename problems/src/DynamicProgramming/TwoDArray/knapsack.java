package DynamicProgramming.TwoDArray;

import java.sql.Array;
import java.util.*;

public class knapsack {
    private static int solve(int[] weight, int[] value, int n, int maxWeight, int index, int[][] dp) {
        if (index == n - 1) {
            if (weight[index] <= maxWeight) {
                return value[index];
            }
            return 0;
        }
        if (dp[index][maxWeight] != -1) {
            return dp[index][maxWeight];
        }
        int include = 0;
        if (weight[index] <= maxWeight) {
            include = solve(weight, value, n, maxWeight - weight[index], index + 1, dp) + value[index];
        }
        int exclude = solve(weight, value, n, maxWeight, index + 1, dp);
        dp[index][maxWeight] = Math.max(include, exclude);
        return dp[index][maxWeight];
    }
    private static int solveBottomUp(int[] weight, int[] value, int size, int capacity) {
        int[][] dp = new int[size][capacity + 1];
        for (int[] eachArray : dp) {
            Arrays.fill(eachArray, 0) ;
        }
        for (int i = weight[0]; i <= capacity; i++) {
            if (weight[0] <= capacity) {
                dp[0][i] = value[0];
            } else {
                dp[0][i] = 0;
            }
        }
        for (int i = 1; i < size; i++) {
            for (int j = 0; j <= capacity; j++) {
                int include = 0;
                if (weight[i] <= j) {
                    include = value[i] + dp[i - 1][j - weight[i]];
                }
                int exclude = dp[i - 1][j];
                dp[i][j] = Math.max(include, exclude);
            }
        }
        return dp[size - 1][capacity];
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        int[] weight = new int[]{1, 2, 4, 5};
        int[] value = new int[]{5, 4, 8, 6};
        int capacity = 6;
        int n = weight.length;
        int[][] dp = new int[n][capacity + 1];
        for(int[] array: dp) {
            Arrays.fill(array, -1);
        }
        List<TreeNode> list = new ArrayList<>();
        list.remove(0);
        System.out.println(solve(weight, value, 4, 5, 0, dp));
        System.out.println(solveBottomUp(weight, value, 4, capacity));
    }
}
