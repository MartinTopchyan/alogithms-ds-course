package leetcode;

import java.util.*;

public class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {
        Map<Integer, Integer> zeroRaws = new HashMap<>();
        Map<Integer, Integer> zeroColumns = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    zeroRaws.putIfAbsent(i, i);
                    zeroColumns.putIfAbsent(j, i);
                }
            }
        }

        zeroRaws.keySet().forEach(i -> setZeroForRaw(matrix, i));
        zeroColumns.keySet().forEach(i -> setZeroForColumn(matrix, i));
    }

    static void setZeroForRaw(int[][] res, int i) {
        Arrays.fill(res[i], 0);
    }

    static void setZeroForColumn(int[][] res, int i) {
        for (int j = 0; j < res.length; j++) {
            res[j][i] = 0;
        }
    }

    public static void setZeroes2(int[][] matrix) {
        boolean firstZero = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if(i > 0){
                        matrix[i][0] = 0;
                    }else {
                        firstZero = true;
                    }
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(matrix[0][0] == 0) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if(firstZero) {
            Arrays.fill(matrix[0], 0);
        }

    }

    public static void setZeroes3(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    markR(matrix, i);
                    markC(matrix, j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '*'){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    static void markC(int[][] res, int i) {
        for (int j = 0; j < res.length; j++) {
            if(res[j][i] != 0){
                res[j][i] = '*';
            }
        }
    }

    static void markR(int[][] res, int i) {
        for (int j = 0; j < res[0].length; j++) {
            if(res[i][j] != 0){
                res[i][j] = '*';
            }
        }
    }


    public static void main(String[] args) {
//        setZeroes(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}});
//        setZeroes(new int[][]{{0,1,2,0}, {3,4,5,2}, {1,3,1,5}});
//        setZeroes(new int[][]{{1,2,3,4},{5,0,7,8}, {0,10,11,12}, {13,14,15,0}});
        setZeroes3(new int[][]{{0,0,0,5},{4,3,1,4}, {0,1,1,4}, {1,2,1,3},{0,0,1,1}});
    }


}
