package leetcode;

public class SingleElementInSortedArray {

    public static int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        while (left < right){
            int mid = left + (right -left)/2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
                return nums[mid];
            }

            if(nums[mid] != nums[mid-1]){
                if((mid -left) % 2 == 0){
                    left = mid;
                }else {
                    right = mid-1;
                }
            }else{
                if((right-mid) % 2 == 0){
                    right = mid;
                }else {
                    left = mid+1;
                }
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
        System.out.println(singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
        System.out.println(singleNonDuplicate(new int[]{1,1,2}));
    }
}
