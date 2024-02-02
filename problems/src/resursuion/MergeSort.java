package resursuion;

public class MergeSort {
    public void sortAndMergeArrays(int[] arr, int start, int mid, int end) {
        int leftLen = mid - start + 1;
        int rightLen = end - mid;
        int[] tempLeft = new int[leftLen];
        int[] tempRight = new int[rightLen];
        for (int i = 0; i < leftLen; i++) {
            tempLeft[i] = arr[start + i];
        }
        for (int i = 0; i < rightLen; i++) {
            tempRight[i] = arr[mid + 1 + i];
        }
        int pointer = start;
        int leftPointer = 0;
        int rightPointer = 0;
        while (leftPointer < leftLen && rightPointer < rightLen) {
            if (tempLeft[leftPointer] < tempRight[rightPointer]) {
                arr[pointer++] = tempLeft[leftPointer++];
            } else {
                arr[pointer++] = tempRight[rightPointer++];
            }
        }
        while (leftPointer < leftLen) {
            arr[pointer++] = tempLeft[leftPointer++];
        }
        while (rightPointer < rightLen) {
            arr[pointer++] = tempRight[rightPointer++];
        }
    }
    public void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            sortAndMergeArrays(arr, start, mid, end);
        }
    }
    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = new int[] {3,5,2,5,7,8,4,2,5,34,12,34,34,3,43,4,25,7,656,75};
        mergeSort.mergeSort(arr, 0, arr.length - 1);
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}
