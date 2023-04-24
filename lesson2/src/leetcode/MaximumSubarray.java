package leetcode;

public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = 0;

        for(int num: nums){
            currentSum = Math.max(currentSum + num, num);
            maxSum = Math.max(maxSum, currentSum);

        }

        return maxSum;
    }

}
