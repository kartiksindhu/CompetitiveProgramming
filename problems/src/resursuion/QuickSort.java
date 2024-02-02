package resursuion;

public class QuickSort {
    public void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
    public int partition(int[] arr, int start, int end) {
        int temp = arr[start];
        int count = 0;
//        System.out.println("inside partition: " + temp + " " + start + " " + end);
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] <= temp) {
                count++;
            }
        }
        int index = start + count;
//        System.out.println("count: " + count + ", index: " + index);
        swap(arr, start, index);
        int beforePivotIndex = start;
        int afterPivotIndex = end;
        while (beforePivotIndex < index && index < afterPivotIndex) {
            while (arr[beforePivotIndex] < arr[index]) {
                beforePivotIndex++;
            }
            while (arr[afterPivotIndex] > arr[index]) {
                afterPivotIndex--;
            }
            swap(arr, beforePivotIndex, afterPivotIndex);
            beforePivotIndex++;
            afterPivotIndex--;
        }
        return index;
    }
    public void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int p = partition(arr, start, end);
            quickSort(arr, start, p - 1);
            quickSort(arr, p + 1, end);
        }
    }
    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = new int[]{2, 4, 5, 6, 23, 4, 32, 1, 2, 43, 2, 23, 4, 65, 34, 5, 2134, 6, 23, 34, 2, 1};
//        int[] arr = new int[]{2,3,4,1};
        quickSort.quickSort(arr, 0, arr.length - 1);
        for (int i: arr) {
            System.out.print(i + " ");
        }
    }
}
