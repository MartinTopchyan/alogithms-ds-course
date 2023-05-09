package leetcode;

import java.util.Arrays;

public class ArrayPartition {

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length-1; i+=2) {
            res += nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(arrayPairSum(new int[]{6,2,6,5,1,2}));
    }
}
