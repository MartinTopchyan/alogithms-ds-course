package edu;

import java.util.Arrays;

public class CountingSort {

    public static int[] countingSort(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            max = Math.max(i, max);
        }
        int[] countArr = new int[max + 1];

        for (int j : arr) {
            countArr[j]++;
        }

        int[] res = new int[arr.length];
        int resIndex = 0;
        for (int i = 0; i < countArr.length; i++) {
            while (countArr[i] > 0) {
                res[resIndex++] = i;
                countArr[i]--;
            }

        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countingSort(new int[]{1, 0, 3, 1, 3, 1})));
    }
}
