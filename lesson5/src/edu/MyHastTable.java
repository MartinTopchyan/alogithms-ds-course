package edu;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyHastTable {
    ArrayList<HashNode> bucket;
    int size;
    int bucketsCount;

    public MyHastTable() {
        bucket = new ArrayList<>();
        bucketsCount = 10;
        size = 0;
        IntStream.range(0, bucketsCount).forEach(index -> bucket.add(null));
    }


    private int hashCode(String key){
        return Objects.hashCode(key);
    }

    private int getBucketIndex(String key){
        int hashcode = hashCode(key);
        int index =  hashcode % bucketsCount;

        index = index < 0 ? index*-1 : index;
        return index;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size() == 0; }
    public void put(String key, int value){
        int bucketNumber = getBucketIndex(key);
        HashNode head = bucket.get(bucketNumber);
        int hashcode = hashCode(key);

        if(head == null){
            bucket.set(bucketNumber, new HashNode(key, value, hashcode));
            size++;
            return;
        }
        HashNode curr = head;
        while (curr != null){
            if(curr.key.equals(key) && curr.hashcode ==hashcode){
                curr.value = value;
                return;
            }
            curr = curr.next;
        }
        size++;

        HashNode newNode = new HashNode(key, value, hashcode);
        HashNode tmp = head;
        while (tmp.next != null){
            tmp = tmp.next;
        }

        tmp.next = newNode;

        //  check if load factor has been reached
        if((size * 1.0 / bucketsCount) > 0.7){

            ArrayList<HashNode> temp = bucket;
            bucket = new ArrayList<>();
            bucketsCount = 2 * bucketsCount;
            size = 0;

            IntStream.range(0, bucketsCount).forEach(index -> bucket.add(null));

            for (HashNode headNode : temp) {
                while (headNode != null) {
                    put(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }

        }

    }

    public Integer get(String key){
        int bucketNumber = getBucketIndex(key);
        HashNode head = bucket.get(bucketNumber);
        int hashcode = hashCode(key);

        HashNode curr = head;
        while (curr != null){
            if(curr.key.equals(key) && curr.hashcode ==hashcode){
                return curr.value;
            }
            curr = curr.next;
        }
        return null;
    }

    public boolean remove(String key){
        int bucketNumber = getBucketIndex(key);
        HashNode head = bucket.get(bucketNumber);
        int hashcode = hashCode(key);

        HashNode curr = head;
        HashNode prev = null;
        while (curr != null){
            if(curr.key.equals(key) && curr.hashcode ==hashcode){
                break;
            }
            prev = curr;
            curr = curr.next;
        }

        if(curr == null){
            return false;
        }

        size--;

        if(prev != null){
            prev.next = head.next;
        }else {
            bucket.set(bucketNumber, curr.next);
        }
        return true;
    }

    public static void main(String[] args)
    {
        MyHastTable hastTable = new MyHastTable();
        hastTable.put("this", 1);
        hastTable.put("coder", 2);
        hastTable.put("this", 4);
        hastTable.put("hi", 5);
        System.out.println(hastTable.size());
        System.out.println(hastTable.remove("this"));
        System.out.println(hastTable.remove("this"));
        System.out.println(hastTable.size());
        System.out.println(hastTable.isEmpty());
        System.out.println(hastTable.get("coder"));
    }
}

class HashNode{
    String key;
    int value;
    HashNode next;
    int hashcode;

    public HashNode(String key, int value, int hashcode) {
        this.key = key;
        this.value = value;
        this.hashcode = hashcode;
    }
}
