package leetcode;

public class Search2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int firstRow = 0;
        int lastRow = matrix.length - 1;
        while (firstRow <= lastRow) {
            int midRow = (firstRow + lastRow) / 2;
            if (target > matrix[midRow][matrix[midRow].length - 1]) {
                firstRow = midRow + 1;
            } else if (target < matrix[midRow][0]) {
                lastRow = midRow - 1;
            } else break;
        }

        if (firstRow > lastRow) {
            return false;
        }

        int left = 0;
        int right = matrix[0].length - 1;
        int row = (firstRow + lastRow) / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else {
                if (target > matrix[row][mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            int left = 0;
            int right = ints.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (ints[mid] == target) {
                    return true;
                }
                if (target > ints[mid]) {
                    if (target == ints[right]) {
                        return true;
                    }
                    if (target < ints[right]) {
                        left = mid + 1;
                    } else {
                        break;
                    }
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1}}, 1));
    }
}
