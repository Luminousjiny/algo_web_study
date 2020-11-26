package day1126;

import java.util.Scanner;

public class BOJ2741 {
    /**
     * 최대 100,000인 자연수 N 주어짐
     * 1부터 N까지 한 줄에 하나씩 출력
     */
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        N = sc.nextInt();

        for(int i = 1; i <= N; i++){
            sb.append(i + "\n");
        }
        System.out.println(sb.toString());
    }
}
