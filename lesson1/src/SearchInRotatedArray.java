public class SearchInRotatedArray {

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(target == nums[mid]){
                return mid;
            }
            if(nums[mid] >= nums[start]){
                if(target < nums[mid] && target >= nums[start]){
                    end = mid -1;
                }else{
                    start = mid +1;
                }
            }
            else {
                if(target <= nums[end] && target > nums[mid]){
                    start = mid +1;
                }else{
                    end = mid -1;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInRotatedArray().search(new int[]{5,1,3}, 3));
    }
}
