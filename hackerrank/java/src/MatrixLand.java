import java.util.Arrays;
import java.util.Scanner;

public class MatrixLand {

    static int MIN_VALUE = -300;
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] A = new int[n][m];
        for(int A_i = 0; A_i < n; A_i++){
            for(int A_j = 0; A_j < m; A_j++){
                A[A_i][A_j] = in.nextInt();
            }
        }
        int result = matrixLand(A);
        System.out.println(result);
        in.close();
    }

    public static int matrixLand(int [][] matrix){
        
        if (matrix[0].length == 1){
            int res = 0;
            for (int r = 0; r < matrix.length; r++) {
                res += matrix[r][0];
            }
            return res;
        }
        
        int [] lastRow = null;
        int res = Integer.MIN_VALUE;
        for (int r = 0; r < matrix.length; r++) {
            int[] left = getLeft(matrix[r]);
            int[] right = getRight(matrix[r]);
            int [] fleft = left;
            int [] fright = right;

            if (lastRow != null){
                fleft = getFleft(matrix[r], left, lastRow);
                fright = getFright(matrix[r], right, lastRow);
            }
            else{
                lastRow = new int[matrix[r].length];
            }

            for (int c = 0; c < matrix[r].length; c++) {
                lastRow[c] = Math.max(fleft[c], fright[c]);
                if (c < matrix[r].length - 1)
                    lastRow[c] = Math.max(lastRow[c], fleft[c] + right[c+1]);
                if (c > 0)
                    lastRow[c] = Math.max(lastRow[c], fright[c] + left[c-1]);

                res = Math.max(res, lastRow[c]);
            }
        }
        return res;
    }

    public static int[] getLeft(int[] row){
        int [] res = new int[row.length];
        Arrays.fill(res, MIN_VALUE);
        res[0] = row[0];
        for (int i = 1; i < row.length; i++) {
            res[i] = Math.max(res[i-1] + row[i], row[i]);
        }
        return res;
    }

    public static int[] getRight(int [] row){
        int [] res = new int[row.length];
        Arrays.fill(res, MIN_VALUE);
        res[row.length - 1] = row[row.length - 1];
        for (int i = row.length-2; i >= 0; i--) {
            res[i] = Math.max(res[i+1] + row[i], row[i]);
        }
        return res;
    }

    public static int[] getFleft(int [] row, int [] left, int [] topRow){
        int [] res = new int[row.length];
        Arrays.fill(res, MIN_VALUE);
        res[0] = left[0] + topRow[0];
        for (int i = 1; i < row.length; i++) {
            res[i] = Math.max(left[i] + topRow[i], res[i-1] + row[i]);
        }
        return res;
    }

    public static int[] getFright(int [] row, int [] right, int [] topRow){
        int [] res = new int[row.length];
        Arrays.fill(res, MIN_VALUE);
        res[row.length-1] = topRow[row.length-1] + right[row.length - 1];

        for (int i = row.length - 2; i >= 0; i--) {
            res[i] = Math.max(topRow[i] + right[i], res[i+1] + row[i]);
        }
        return res;
    }
}
