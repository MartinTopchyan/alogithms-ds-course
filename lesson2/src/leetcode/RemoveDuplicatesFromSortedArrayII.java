package leetcode;

import java.util.Arrays;
// todo
public class RemoveDuplicatesFromSortedArrayII {

    public static int removeDuplicates(int[] nums) {
        int count = 2;
        for (int i = 2; i < nums.length; i++) {
            if(nums[i] != nums[i-2]){
                nums[count] = nums[i];
                count+=2;
            }
        }
        System.out.println(Arrays.toString(nums));
        return count;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,1,2,2,3}));
    }
}
