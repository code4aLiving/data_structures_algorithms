import java.util.Scanner;

public class SurfaceArea3d {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int [][] board = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int result = surfaceArea(board);
        System.out.println(result);

    }

    public static int surfaceArea(int [][] board){

        int result = 0;
        int cols = board[0].length;
        int rows = board.length;
        //Base and top
        result += 2 * cols * rows;

        for (int col = 0; col < cols; col++) {
            for (int row = 0; row < rows; row++) {
                //left
                if (col == 0)
                    result += board[row][col];
                else
                    result += Math.max(0, board[row][col] - board[row][col-1]);

                //right
                if (col == cols - 1)
                    result += board[row][col];
                else
                    result += Math.max(0, board[row][col] - board[row][col+1]);

                //front
                if (row == 0)
                    result += board[row][col];
                else
                    result += Math.max(0, board[row][col] - board[row-1][col]);

                //back
                if (row == rows-1)
                    result += board[row][col];
                else
                    result += Math.max(0, board[row][col] - board[row+1][col]);
            }
        }
        return result;
    }
}
