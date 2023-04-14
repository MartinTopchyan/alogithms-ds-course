import java.util.Arrays;

public class RotateImage {

    public void rotate(int[][] matrix) {
        int n = matrix.length-1;
        int iterations = n;
        for(int i = 0; i <= n; i++){
            for(int j = i; j <iterations; j++){
                int tmp1 = matrix[i][j];
                int tmp2 = matrix[j][n-i];
                int tmp3 = matrix[n-i][n-j];
                int tmp4 = matrix[n-j][i];

                matrix[j][n-i] = tmp1;
                matrix[n-i][n-j] = tmp2;
                matrix[n-j][i] = tmp3;
                matrix[i][j] = tmp4;
            }
            iterations--;

        }
        System.out.println(Arrays.deepToString(matrix));

    }

    public static void main(String[] args) {
        new RotateImage().rotate(new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}});
        // Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
    }
}
