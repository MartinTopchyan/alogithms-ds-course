import java.util.Arrays;

public class SelectionSort {

    public static int[] selectionSort(int[] arr){

        for(int j = 0; j < arr.length; j++){
            int current = arr[j];
            int minIndex = j;
            for(int i = j +1; i < arr.length; i++){
                if(arr[minIndex] > arr[i]){
                    minIndex = i;
                }
            }
            arr[j] = arr[minIndex];
            arr[minIndex] = current;
        }

        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(selectionSort(new int[]{-1, 3, 7, 1, 0, 8, 11, 4, 5})));
    }
}


