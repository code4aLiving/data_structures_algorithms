import java.io.IOException;
import java.util.Scanner;

public class SecretMessage {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String message = sc.next();
            System.out.println(secretMessage(message));
        }
        System.in.close();
    }

    public static String secretMessage(String message){

        int l = message.length();
        double sqrt = Math.sqrt(l);
        int k;
        double e = Math.pow(10,-8);
        if (sqrt - (int)sqrt < e)
            k = (int)sqrt;
        else
            k = (int)sqrt + 1;

        char [][] table = new char[k][k];
        for (int row = 0; row < k; row++) {
            for (int col = 0; col < k; col++) {
                if (k * row + col >= message.length())
                    table[col][k-1-row] = '*';
                else
                    table[col][k-1-row] = message.charAt(k * row + col);
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int row = 0; row < k; row++) {
            for (int col = 0; col < k; col++) {
                if (table[row][col] == '*')
                    continue;
                sb.append(table[row][col]);
            }
        }
        return sb.toString();
    }
}