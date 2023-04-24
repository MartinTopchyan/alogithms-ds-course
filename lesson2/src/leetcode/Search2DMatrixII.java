package leetcode;

public class Search2DMatrixII {

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int column = matrix[0].length -1;
        while (row < matrix.length && column >=0){
            if(target == matrix[row][0] || target == matrix[row][column]){
                return true;
            }
            if(target > matrix[row][0] && target > matrix[row][column]){
                row++;
            }else if (target > matrix[row][0] && target < matrix[row][column]){
                column--;
            }else {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 5));
        System.out.println(searchMatrix(new int[][]{{-1,3}}, 3));
    }
}
