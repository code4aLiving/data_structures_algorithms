import java.util.Scanner;

/**
 * Created by sergio on 14/08/17.
 */
public class HourglassSum {

    public static void main(String [] args){
        int row = 6;
        int col = 6;
        int [][] table = new int[6][6];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                table[i][j] = sc.nextInt();
            }
        }
        int res = maxHourGlassSumm(table);
        System.out.println(res);
    }

    public static int maxHourGlassSumm(int [][] arr){
        int res = Integer.MIN_VALUE;
        for (int row=0; row <= arr.length-3; row++){
            for(int col=0; col <= arr[0].length-3; col++){
                res = Math.max(res, sumHourGlass(arr, row, col));
            }
        }
        return res;
    }

    private static int sumHourGlass(int [][] arr, int row, int col){
        int sum = 0;
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                sum += arr[i][j];
            }
        }
        sum -= arr[row+1][col] + arr[row+1][col+2];
        return sum;
    }
}
