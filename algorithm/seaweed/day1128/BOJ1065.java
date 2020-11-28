package day1128;

import java.util.Scanner;

public class BOJ1065 {
    /**
     * 한수 구하기
     */
    static int N, result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        if(N < 100){
            System.out.println(N);
        } else {
            result = 99;
            for (int i = 100; i <= N; i++) {
                if(i == 1000)
                    break;
                int one = i % 10;
                int ten = (i / 10) % 10;
                int hun = (i / 100) % 10;

                if (ten - one == hun - ten)
                    result++;
            }
            System.out.println(result);
        }
    }
}
