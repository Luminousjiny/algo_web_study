package day1126;

import java.util.Scanner;

public class BOJ2742 {
    /**
     * N부터 1까지 출력
     * 0 < N <= 100,000
     */
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        N = sc.nextInt();

        for(int i = N; i > 0; i--){
            sb.append(i).append("\n");
        }
        System.out.println(sb.toString());
    }
}
