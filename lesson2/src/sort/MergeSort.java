package sort;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] array) {
        if (array.length < 2) {
            return;
        }
        int left = 0;
        int right = array.length - 1;
        mergeSort(array, left, right);

    }

    public static void mergeSort(int[] array, int left, int right) {
        if(left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int leftArraySize = mid + 1 - left;
        int rightArraySize = right - mid;
        int[] leftArray = new int[leftArraySize];
        int[] rightArray = new int[rightArraySize];

        for (int i = 0; i < leftArraySize; i++) {
            leftArray[i] = array[left + i];
        }
        for (int i = 0; i < rightArraySize; i++) {
            rightArray[i] = array[mid + 1 +i];
        }

        int i = 0, j = 0, k = left;

        while (i < leftArraySize && j < rightArraySize) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < leftArraySize) {
            array[k++] = leftArray[i++];
        }

        while (j < rightArraySize) {
            array[k++] = rightArray[j++];
        }
    }

    public static void main(String[] args) {
        mergeSort(new int[]{12, 11, 13, 5, 6, 7});
    }

}
