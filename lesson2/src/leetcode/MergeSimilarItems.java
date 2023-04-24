package leetcode;

import java.util.*;

public class MergeSimilarItems {

    public static List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        List<List<Integer>> resList = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] ints : items1) {
            map.put(ints[0], ints[1]);
        }
        for (int[] ints : items2) {
            map.putIfAbsent(ints[0], 0);
            map.put(ints[0], map.get(ints[0]) + ints[1]);
        }
        for (var item: map.entrySet()){
            var list = new ArrayList<Integer>();
            list.add(item.getKey());
            list.add(item.getValue());
            resList.add(list);
        }
        return resList;
    }

    public static void main(String[] args) {
        System.out.println(mergeSimilarItems(new int[][]{{1, 3}, {2, 2}}, new int[][]{{7, 1}, {2, 2}, {1, 4}}));
    }
}
