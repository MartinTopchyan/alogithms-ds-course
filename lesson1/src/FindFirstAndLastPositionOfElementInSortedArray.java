import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }
        int first = lowerBound(nums, target);
        int last = upperBound(nums, target);

        return new int[]{first, last};
    }



    int lowerBound(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;
        int lower = -1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(target == nums[mid]){
                lower = mid;
                end = mid-1;
            }else if(target < nums[mid]){
                end = mid-1;
            }else{
                start = mid +1;
            }
        }

        return lower;
    }

    int upperBound(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;
        int upper = -1;
        while(start <= end){
            int mid = start + (end-start +1)/2;
            if(target == nums[mid]){
                upper = mid;
                start = mid+1;
            }else if(target > nums[mid]){
                start = mid +1;
            }else{
                end = mid -1;
            }
        }
        return upper;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindFirstAndLastPositionOfElementInSortedArray().searchRange(new int[]{5,7,7, 8, 8, 10}, 8)));
    }
}
