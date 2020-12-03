package backjoon;

import java.util.Scanner;

public class BOJ1330 {
    /**
     * 정수 A, B가 주어졌을 때
     * 1) A > B => > 출력
     * 2) A < B => < 출력
     * 3) A = B => == 출력
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        String result = "";
        if(A > B)
            result = ">";
        else if(A < B)
            result = "<";
        else
            result = "==";

        System.out.println(result);
    }
}
