package resursuion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SubSetsLeetCode78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generateSubset(0, nums, new ArrayList<>(), result);
        return result;
    }

    public void generateSubset(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        System.out.println("__resursicecall__");
        System.out.println(current + " " + index);
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        generateSubset(index + 1, nums, current, result);
        current.remove(current.size() - 1);
        generateSubset(index + 1, nums, current, result);
    }
    public static void main(String[] args) {
        HashSet<int[]> hashSet = new HashSet<>();
        int[] arr = new int[]{1,2,3};
        SubSetsLeetCode78 subSets = new SubSetsLeetCode78();
        List<List<Integer>> result = subSets.subsets(arr);
        System.out.println("------------------------------------------------------");
        for (List<Integer> i: result) {
            System.out.print(i + " ");
        }
    }
}
