package edu;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {

    List<Integer> list;
    int size;

    public MinHeap() {
        list = new ArrayList<>();
    }

    int parent(int pos){
        return (pos-1)/2;
    }

    int leftChild(int pos){
        return 2* pos +1;
    }

    int rightChild(int pos){
        return 2*pos +2;
    }

    boolean isLeaf(int pos){
        return pos > (size/2);
    }

    private void swap(int fpos, int lpos)
    {
        int tmp = list.get(fpos);
        list.set(fpos, list.get(lpos));
        list.set(lpos, tmp);
    }

    public void insert(int val){
        list.add(size, val);
        int currentPos = size++;
        while (val < list.get(parent(currentPos))){
            swap(currentPos, parent(currentPos));
            currentPos = parent(currentPos);
        }

    }

    void heapify(int pos){
        if(!isLeaf(pos)){
            int leftPos = leftChild(pos);
            int rightPos = rightChild(pos);
            int swappedPos;
            if(rightPos <= size){
                swappedPos = list.get(leftPos) <= list.get(rightPos) ? leftPos : rightPos;
            }else {
                swappedPos = leftPos;
            }

            if(list.get(pos) > list.get(swappedPos)){
                swap(pos, swappedPos);
                heapify(swappedPos);
            }
        }

    }

    public void delete(){
        swap(0, size);
        size--;
        heapify(0);
    }

    public int max(){
        return list.get(0);
    }

    public void print()
    {
        for (int i = 0; i < size / 2; i++) {

            System.out.print(
                    " PARENT : " + list.get(i)
                            + " LEFT CHILD : " + list.get(leftChild(i))
                            + " RIGHT CHILD :" + list.get(rightChild(i)));

            System.out.println();
        }
    }

    public static void heapSort(int[] arr){

    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap();
        heap.insert(5);
        heap.insert(3);
        heap.insert(17);
        heap.insert(10);
        heap.insert(84);
        heap.insert(19);
        heap.insert(6);
        heap.insert(22);
        heap.insert(9);

        heap.print();
        System.out.println("valod");
        heap.delete();
        heap.print();
        System.out.println(heap.max());

    }
}
