public class SearchInRotatedSortedArrayII {

    public static boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return true;
            }
            if(nums[left] == nums[mid] && nums[right] == nums[mid]){
                left+= 1;
                right-= 1;
            }else {
                if (nums[mid] >= nums[left]) {
                    if (target >= nums[left] && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    if (target > nums[mid] && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }

        }
        return false;
    }

    public static boolean search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return true;
            }
            if (nums[mid] >= nums[left]) {
                if (target >= nums[left]) {
                    if (target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }else {
                    right = mid -1;
                }

//                    right = mid-1;
//                }else {
//                    left = mid +1;
//                }

            } else {
                if (target >= nums[right]) {
                    if (target < nums[mid]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }else {
                    left = mid +1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(search(new int[]{2,5,6,0,0,1,2}, 5));
        System.out.println(search2(new int[]{1, 0, 1, 1, 1}, 0));
    }
}
