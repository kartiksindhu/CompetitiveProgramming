//package resursuion;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Practice {
//    private void mergeAndSortArrays(int[] arr, int start, int mid, int end) {
//        int leftSide = mid - start + 1;
//        int rightSide = end - mid;
//        int[] leftArr = new int[leftSide];
//        int[] rightArr = new int[rightSide];
//        for (int i = 0; i < leftSide; i++) {
//            leftArr[i] = arr[start + i];
//        }
//        for (int i = 0; i < rightSide; i++) {
//            rightArr[i] = arr[mid + 1 + i];
//        }
//        while ()
//    }
//    private void solve(int[] arr, int start, int end) {
//        if (start < end) {
//            int mid = (end - start) / 2;
//            solve(arr, mid + 1, end);
//            solve(arr, start, mid);
//            mergeAndSortArrays(arr, start, mid, end);
//        }
//    }
//
//    public static void main(String[] args) {
//        String input = "23";
//        int[] arr = new int[]{2, 4, 5, 6, 23, 4, 32, 1, 2, 43, 2, 23, 4, 65, 34, 5, 2134, 6, 23, 34, 2, 1};
//        Practice practice = new Practice();
//        practice.solve(arr, 0, arr.length - 1);
//    }
//}
