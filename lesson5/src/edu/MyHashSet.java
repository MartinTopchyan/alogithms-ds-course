package edu;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.IntStream;

public class MyHashSet {

    ArrayList<HashSetNode> bucket;
    int size;
    int bucketsCount;

    public MyHashSet() {
        bucket = new ArrayList<>();
        bucketsCount = 10;
        size = 0;
        IntStream.range(0, bucketsCount).forEach(index -> bucket.add(null));
    }


    private int hashCode(String key) {
        return Objects.hashCode(key);
    }

    private int getBucketIndex(String key) {
        int hashcode = hashCode(key);
        int index = hashcode % bucketsCount;

        index = index < 0 ? index * -1 : index;
        return index;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void add(String key) {
        int bucketNumber = getBucketIndex(key);
        HashSetNode head = bucket.get(bucketNumber);
        int hashcode = hashCode(key);

        if (head == null) {
            bucket.set(bucketNumber, new HashSetNode(key, hashcode));
            size++;
            return;
        }
        HashSetNode curr = head;
        while (curr != null) {
            if (curr.key.equals(key) && curr.hashcode == hashcode) {
                return;
            }
            curr = curr.next;
        }
        size++;

        HashSetNode newNode = new HashSetNode(key, hashcode);
        HashSetNode tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }

        tmp.next = newNode;

        //  check if load factor has been reached
        if ((size * 1.0 / bucketsCount) > 0.7) {

            ArrayList<HashSetNode> temp = bucket;
            bucket = new ArrayList<>();
            bucketsCount = 2 * bucketsCount;
            size = 0;

            IntStream.range(0, bucketsCount).forEach(index -> bucket.add(null));

            for (HashSetNode headNode : temp) {
                while (headNode != null) {
                    add(headNode.key);
                    headNode = headNode.next;
                }
            }

        }

    }

    public boolean contains(String key) {
        int bucketNumber = getBucketIndex(key);
        HashSetNode head = bucket.get(bucketNumber);
        int hashcode = hashCode(key);

        HashSetNode curr = head;
        while (curr != null) {
            if (curr.key.equals(key) && curr.hashcode == hashcode) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public boolean remove(String key) {
        int bucketNumber = getBucketIndex(key);
        HashSetNode head = bucket.get(bucketNumber);
        int hashcode = hashCode(key);

        HashSetNode curr = head;
        HashSetNode prev = null;
        while (curr != null) {
            if (curr.key.equals(key) && curr.hashcode == hashcode) {
                break;
            }
            prev = curr;
            curr = curr.next;
        }

        if (curr == null) {
            return false;
        }

        size--;

        if (prev != null) {
            prev.next = head.next;
        } else {
            bucket.set(bucketNumber, curr.next);
        }
        return true;
    }

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add("this");
        hashSet.add("coder");
        hashSet.add("this");
        hashSet.add("hi");
        System.out.println(hashSet.size());
        System.out.println(hashSet.remove("this"));
        System.out.println(hashSet.remove("this"));
        System.out.println(hashSet.size());
        System.out.println(hashSet.isEmpty());
        System.out.println(hashSet.contains("coder"));
    }
}

class HashSetNode{
    String key;
    HashSetNode next;
    int hashcode;

    public HashSetNode(String key, int hashcode) {
        this.key = key;
        this.hashcode = hashcode;
    }
}
