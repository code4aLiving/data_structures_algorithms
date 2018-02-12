import java.util.Scanner;

public class MatrixLand {

    public static void main(String[] args){

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

    public static int matrixLand(int [][] a){
        //rows,column
        int [][] sumMatrix = new int[a.length][a[0].length];
        for (int row = 0; row<a.length; row++){
            int [] r = subsequenceSum(a[row]);
            for (int i = 0; i < r.length; i++) {
                System.out.print(r[i]);
                System.out.print(" ");
            }
            System.out.println();
            sumMatrix[row] = r;
        }

        //sum columns and keep the max
        int res = Integer.MIN_VALUE;
        for (int col = 0; col < sumMatrix[0].length; col++) {
            int partialSum = 0;
            for (int row = 0; row < sumMatrix.length; row++) {
                partialSum += sumMatrix[row][col];
            }
            res = Math.max(res,partialSum);
        }

        return res;
    }

    public static int[] subsequenceSum(int [] arr){
        int [] res = new int[arr.length];
        int [] left = leftSubsequenceSum(arr);
        int [] right = rightSubsequenceSum(arr);

        for (int i = 0; i < arr.length; i++) {
            int leftSum = i == 0 ? -300 : left[i-1];
            int rightSum = i == arr.length - 1 ? -300 : right[i+1];

            res[i] = Math.max(arr[i],leftSum + arr[i]);
            res[i] = Math.max(res[i], rightSum + arr[i]);
            res[i] = Math.max(res[i], rightSum + leftSum + arr[i]);
        }
        return res;
    }

    public static int[] leftSubsequenceSum(int [] arr){
        int [] res = new int[arr.length];
        res[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res[i] = Math.max(res[i-1] + arr[i], arr[i]);
        }
        return res;
    }

    public static int[] rightSubsequenceSum(int [] arr){
        int [] res = new int[arr.length];
        res[res.length-1] = arr[arr.length -1];
        for (int i = res.length - 2; i >= 0 ; i--) {
            res[i] = Math.max(res[i+1] + arr[i], arr[i]);
        }
        return res;
    }
}
