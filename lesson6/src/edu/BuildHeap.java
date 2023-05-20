package edu;

import java.util.PriorityQueue;

public class BuildHeap {

    public static void heapify(int[] arr, int pos, int length) {
        int biggest = pos;
        int leftChild = 2 * biggest + 1;
        int rightChild = 2 * biggest + 2;

        if (leftChild < length && arr[leftChild] > arr[biggest]) {
            biggest = leftChild;
        }

        if (rightChild < length && arr[rightChild] > arr[biggest]) {
            biggest = rightChild;
        }

        if (biggest != pos) {
            int tmp = arr[pos];
            arr[pos] = arr[biggest];
            arr[biggest] = tmp;
            heapify(arr, biggest, length);
        }
    }

    public static void buildHeap(int[] arr) {
        int index = (arr.length) / 2 -1;
        for (int i = index; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
    }

    static void printHeap(int[] arr) {
        for (int j : arr)
            System.out.print(j + " ");
        System.out.println();
    }

    static void heapSort(int[] arr){
        int length = arr.length;
        buildHeap(arr);

        for (int i = length -1; i >=0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i);
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 10, 6, 25, 10, 9, 48, 57, 68};

        buildHeap(arr);
        printHeap(arr);

        int[] arr2 = {1, 2, 5, 10, 6, 25, 10, 9, 48, 57, 68};
        heapSort(arr2);
        printHeap(arr2);
    }
}
