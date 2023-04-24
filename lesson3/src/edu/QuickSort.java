package edu;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void sort(int[] arr){
        quickSort(arr, 0, arr.length-1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partitionPivotRandom(arr, left, right);
            quickSort(arr, left, pivotIndex-1);
            quickSort(arr, pivotIndex + 1, right);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static int partitionPivotRandom(int[] arr, int left, int right) {
        int pivotIndex = new Random().nextInt(right-left) + left;
        swap(arr, pivotIndex, right);
        return partitionPivotRight(arr, left, right);
    }

    public static int partitionPivotFirst(int[] arr, int left, int right) {
        int i = right+1;
        int pivot = arr[left];
        for (int j = right; j > left; j--) {
            if(arr[j] >= pivot){
                i--;
                swap(arr, i, j);
            }
        }
        swap(arr, left, i-1);
        return i-1;
    }
    public static int partitionPivotRight(int[] arr, int left, int right) {
        int i = left-1;
        int pivot = arr[right];
        for (int j = left; j < right; j++) {
            if(arr[j] <= pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, right, i+1);
        return i+1;
    }


    public static void main(String[] args) {
        sort(new int[]{5,2,3,1});
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
