package sort;

import java.util.Arrays;

public class MaxSubArrayWithDivideAndConquer {

    static int[] maxSubArray(int[] array, int left, int right) {
        if (left > right) {
            return new int[]{};
        }
        if (left == right) {
            return new int[]{array[left], left, left};
        }
        int mid = left + (right - left) / 2;
        int[] maxLeft = maxSubArray(array, left, mid);
        int[] maxRight = maxSubArray(array, mid + 1, right);
        int[] maxCrossing = maxCrossingSubArray(array, left, mid, right);
        return maximum(maxLeft, maxRight, maxCrossing);
    }

    static int[] maxCrossingSubArray(int[] array, int left, int mid, int right) {
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        int leftIndex = Integer.MIN_VALUE;
        for (int i = mid; i >= left; i--) {
            sum = sum + array[i];
            if (sum > leftSum){
                leftSum = sum;
                leftIndex = i;
            }
        }

        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        int rightIndex = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= right; i++) {
            sum = sum + array[i];
            if (sum > rightSum){
                rightSum = sum;
                rightIndex = i;
            }
        }

        return new int[]{leftSum + rightSum, leftIndex, rightIndex};
    }

    static int[] maximum(int[] a, int[] b, int[] c)
    {
        if (a[0]>=b[0] && a[0]>=c[0])
            return a;
        else if (b[0]>=a[0] && b[0]>=c[0])
            return b;
        return c;
    }

    public static void main(String[] args) {
        int[] a = {3, -1, -1, 10, -3, -2, 4};
        System.out.println(Arrays.toString(maxSubArray(a, 0, 6)));
    }
}
