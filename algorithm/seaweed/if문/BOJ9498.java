package backjoon;

import java.util.Scanner;

public class BOJ9498 {
    /**
     * 90 ~ 100 : A
     * 80 ~ 89 : B
     * 70 ~ 79 : C
     * 60 ~ 69 : D
     * 0  ~ 59 : F
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String grade = "";
        int score = sc.nextInt();

        if(score < 60){
            grade = "F";
        } else if(score < 70){
            grade = "D";
        } else if(score < 80){
            grade = "C";
        } else if(score < 90){
            grade = "B";
        } else {
            grade = "A";
        }
        System.out.println(grade);
    }
}
