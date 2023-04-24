package edu;

import java.util.Arrays;

public class RadixSort {

    public static void countingSort(int[] arr, int n, int exp) {

        int[] resArr = new int[arr.length];
        int[] countArr = new int[10];

        for (int i = 0; i < n; i++)
            countArr[(arr[i] / exp) % 10]++;

        for (int i = 1; i < 10; i++) {
            countArr[i]+= countArr[i-1];
        }

        for (int i = n-1; i >= 0; i--) {
            resArr[countArr[(arr[i] / exp) % 10] - 1] = arr[i];
            countArr[(arr[i] / exp) % 10]--;
        }
        System.arraycopy(resArr, 0, arr, 0, n);
    }

    public static void radixSort(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
            max = Math.max(max, arr[i]);

        for (int exp = 1; max / exp > 0; exp *= 10)
            countingSort(arr, arr.length, exp);

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
        radixSort(arr);
    }
}
