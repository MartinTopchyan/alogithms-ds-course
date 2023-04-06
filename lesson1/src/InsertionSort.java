import java.util.Arrays;

public class InsertionSort {


    public static int[] insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int current = arr[i];
            int j = i -1;
            while (j >= 0 && arr[j] > current){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = current;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(insertionSort(new int[]{5, 2, 4, 6, 1, 3})));
    }
}
