package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> firstInterval = new ArrayList<>();
        firstInterval.add(intervals[0][0]);
        firstInterval.add(intervals[0][1]);
        res.add(firstInterval);
        int resIndex = 0;
        for (int i = 1; i < intervals.length; i++) {
            List<Integer> currentInterval = new ArrayList<>();
            if (res.get(resIndex).get(1) >= intervals[i][0]) {
                res.get(resIndex).set(1, Math.max(res.get(resIndex).get(1), intervals[i][1]));
            } else {
                resIndex++;
                currentInterval.add(intervals[i][0]);
                currentInterval.add(intervals[i][1]);
                res.add(currentInterval);
            }
        }

        return res.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(merge(new int[][]{{4, 5}, {2, 4}, {4, 6}, {3, 4}, {0, 0}, {1, 1}, {3, 5}, {2, 2}})));
        System.out.println(Arrays.deepToString(merge(new int[][]{{0, 1}, {4, 5}, {0, 2}, {3, 4}, {2, 4}, {0, 0}, {3, 5}, {0, 1}, {0, 0}, {5, 5}})));
    }

    // [[0,1],[4,5],[0,2],[3,4],[2,4],[0,0],[3,5],[0,1],[0,0],[5,5]]
    // [[4,5],[2,4],[4,6],[3,4],[0,0],[1,1],[3,5],[2,2]]
}
