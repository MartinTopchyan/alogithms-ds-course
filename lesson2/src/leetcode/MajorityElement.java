package leetcode;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                majority = nums[i];
            }
            if (majority == nums[i]) {
                count++;
            } else {
                count--;
            }

        }
        return majority;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    // [2,5,1,3,1,2,2]
}
