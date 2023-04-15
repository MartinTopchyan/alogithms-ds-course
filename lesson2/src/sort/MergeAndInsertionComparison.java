package sort;

import static sort.MergeSort.mergeSort;

public class MergeAndInsertionComparison {

    public static void main(String[] args) {
        int n = 281;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = n - i;
        }
        var time = System.nanoTime();
        insertionSort(array);
        System.out.println("insertionSort " + (System.nanoTime() - time));
        var time2 = System.nanoTime();
        mergeSort(array);
        System.out.println("mergeSort " + (System.nanoTime() - time2));
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }
}
