package day1126;

import java.util.Scanner;

public class BOJ10950 {
    /**
     * 정수 A, B를 입력받은 다음 A+B출력
     */
    static int A, B;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();

        for(int tc = 1; tc <= TC; tc++){
            A = sc.nextInt();
            B = sc.nextInt();

            System.out.println(A + B);
        }
    }
}
