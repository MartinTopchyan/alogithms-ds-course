package leetcode;

public class MaximumProductSubarray {

    public static int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int currentMax =1;
        int currentMin = 1;
        for (int num: nums){
            int prevMax = currentMax;
            currentMax = Math.max(currentMax * num, Math.max(currentMin * num, num));
            currentMin = Math.min(currentMin * num, Math.min(prevMax * num, num));
            maxProduct = Math.max(maxProduct, currentMax);
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-2,3,-4}));
    }
}
