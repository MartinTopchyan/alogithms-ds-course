package leetcode;

public class FindMinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        // first One
//        while (left < right) {
//            int mid = left + (right - left) / 2;
//            if (nums[mid] >= nums[left]) {
//                if (nums[left] < nums[right]) {
//                    right = mid;
//                } else {
//                    left = mid +1;
//                }
//            } else {
//                right = mid;
//            }
//        }

        // Second one
        while(left < right){
            int mid = left + (right - left) /2;
            if(nums[mid] > nums[right]){
                left = mid +1;
            }else{
                right = mid;
            }

        }
        return nums[left];

    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
    }

    // 3,4,5,1,2

    //6,1,2,3,4,5
}
