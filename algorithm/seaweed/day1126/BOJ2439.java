package day1126;

import java.util.Scanner;

public class BOJ2439 {
    /**
     *     *
     *   * *
     * * * *
     * 이런식으로 별 찍기
     *
     * 시간 복잡도 : O(N^2)
     * 공간 복잡도 : O(N^2)
     * - 찍은 별들 저장할 String 사이즈
     */
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        N = sc.nextInt();

        for(int i = 1; i <= N; i++){
            // 공백 찍기
            for(int j = 0; j < N - i; j++){
                sb.append(" ");
            }
            // 별 찍기
            for(int j = 0; j < i; j++){
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
