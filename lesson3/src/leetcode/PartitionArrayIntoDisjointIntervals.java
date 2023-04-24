package leetcode;

public class PartitionArrayIntoDisjointIntervals {

    public static int partitionDisjoint(int[] nums) {
        int currentMax = nums[0];
        int prevMax = nums[0];
        int size = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < prevMax) {
                size = i+1;
                prevMax = currentMax;
            }else {
                currentMax = Math.max(currentMax, nums[i]);
            }
        }
        return size == 0 ? 1 : size;

    }

    public static void main(String[] args) {
        System.out.println(partitionDisjoint(new int[]{24,11,49,80,63,8,61,22,73,85}));
    }
}
