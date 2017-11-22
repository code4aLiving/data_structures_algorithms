import java.util.Scanner;

/**
 * Created by sergio on 06/08/17.
 */
public class GradingStudents {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] grades = new int[n];
        for(int grades_i=0; grades_i < n; grades_i++){
            grades[grades_i] = in.nextInt();
        }
        int[] result = gradeStudents(grades);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");

    }

    public static int[] gradeStudents(int[] grades){
        int[] res = new int[grades.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = gradeStudent(grades[i]);
        }
        return res;
    }

    public static int gradeStudent(int mark){
        if(mark < 38)
            return mark;
        int div5 = mark / 5;
        if(5*(div5+1) - mark < 3)
            return 5*(div5+1);
        return mark;
    }
}
