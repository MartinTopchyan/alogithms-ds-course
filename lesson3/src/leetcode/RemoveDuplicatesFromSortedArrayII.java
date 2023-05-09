package leetcode;

public class RemoveDuplicatesFromSortedArrayII {

    public static int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length){
            int count = 1;
            while (right+1< nums.length && nums[right] == nums[right+1]){
                count++;
                right++;
            }
            for (int i = 0; i < Math.min(2, count); i++) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        return left;
    }

    public static int removeDuplicates2(int[] nums) {
        int left = 2;
        int right = 2;

        while (right < nums.length){
            if(nums[right] != nums[left-2]){
                nums[left++] = nums[right++];
            }else {
                right++;
            }
        }
        return left;
    }

    public static void leftShift(int[] nums, int index){
        while (index < nums.length-1){
            int tmp = nums[index];
            nums[index] = nums[index+1];
            nums[index+1] = tmp;
            index++;
        }
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates2(new int[]{0,0,1,1,1,1,2,3,3}));
    }
}
