public class BinarySearch {

    public static int binarySearch(int[] arr, int k){
        int start = 0;
        int end = arr.length -1;
        while (start <= end){
            int mid = start + (end - start) /2 ;
            if(arr[mid] == k){
                return mid;
            }
            else if (arr[mid] < k){
                start = mid +1;
            }
            else {
                end = mid -1;
            }
        }
        return -1;
    }

    public static int binarySearchRecursiveBase(int[] arr, int k){
        return binarySearchRecursive(arr, 0, arr.length -1, k);
    }
    public static int binarySearchRecursive(int[] arr, int start, int end, int k){
        if(start > end){
            return -1;
        }
        int mid = start + (end - start) /2 ;
        if(arr[mid] == k){
            return mid;
        }else if (arr[mid] < k){
            return binarySearchRecursive(arr, mid+1, end, k);
        }
        else {
            return binarySearchRecursive(arr, start, mid -1, k);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,4,5,6,13,17,19};
        System.out.println(binarySearchRecursiveBase(arr, 5));
        System.out.println(binarySearchRecursiveBase(arr, 20));
        System.out.println(binarySearchRecursiveBase(arr, 17));
    }
}
