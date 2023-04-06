import java.util.Arrays;

public class BubbleSort {
    public static int[] bubbleSort(int[] array){
        int length = array.length;
        for(int i = 0; i< length -1; i++){
            for(int j = 0; j < length - i -1; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSort(new int[]{5, 2, 4, 6, 1, 3})));
    }
}
