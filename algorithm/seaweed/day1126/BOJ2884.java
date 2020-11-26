package day1126;

import java.util.Scanner;

public class BOJ2884 {
    /**
     * 모듈러 연산 활용
     * 시간 복잡도 : O(1)
     * 공간 복잡도 : O(1)
     */
    static int H, M; // 시간, 분
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt(); // 시간
        M = sc.nextInt(); // 분

        M = (M - 45) % 60; // 45분 더 빨리
        H = (M < 0) ? H - 1 : H; // 음수면 시간 1시간 감소
        M = (M + 60) % 60; // 분 음수로 간 경우 다시 0 ~ 60 사이의 값으로 맞춤
        H = (H + 24) % 24; // 시간 음수로 간 경우 다시 0 ~ 23 사이의 값으로 맞춤
        System.out.println(H + " " + M);
    }
}