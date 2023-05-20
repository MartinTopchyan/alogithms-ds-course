package leetcode;

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        int[][] res = new int[matrix.length][matrix[0].length];
        int[][] zeroIndices = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    res[i][j] = Integer.MIN_VALUE;
                } else {
                    res[i][j] = matrix[i][j];
                }
            }
        }

        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                if (res[i][j] == Integer.MIN_VALUE) {

                }
            }
        }
    }

    void setZero(int[][] res, int i, int j) {
        for (int k = 0; k < res[i].length; k++){

        }
    }



}
