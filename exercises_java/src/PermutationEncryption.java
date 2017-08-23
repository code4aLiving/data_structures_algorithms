import java.util.Scanner;

public class PermutationEncryption {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            int n = sc.nextInt();
            if(n==0)
                break;
            int [] key = new int[n];
            for (int i = 0; i < n; i++) {
                key[i] = sc.nextInt();
            }
            sc.nextLine();
            String message = sc.nextLine();
            String encrypted = permutationEncryption(key, message);
            System.out.printf("'%s'\n",encrypted);
        }
    }

    public static String permutationEncryption(int [] key, String message){
        StringBuffer sb = new StringBuffer();
        int start = 0;

        while(start < message.length()){
            for (int i = 0; i < key.length; i++) {
                int index = start + key[i] - 1;
                if (index >= message.length())
                    sb.append(' ');
                else
                    sb.append(message.charAt(index));
            }
            start += key.length;
        }
        return sb.toString();
    }
}
