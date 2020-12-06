package day1206;

import java.util.Scanner;

public class BOJ2798 {
    static int N, M, max;
    static int[] card; // 입력된 카드 저장
    static int[] number; // 3장뽑아 넣기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 카드개수
        M = sc.nextInt(); // 넘지말아야할 숫자

        card = new int[N];
        for (int i = 0; i < N; i++) {
            card[i] = sc.nextInt();
        }

        number = new int[3];
        max = Integer.MIN_VALUE;
        comb(0,0);
        System.out.println(max);

    }

    static void comb(int cnt, int cur){ // 조합
        if(cnt == 3){
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += number[i];
            }

            if(sum <= M){
                max = Math.max(max, sum);
            }
            return;
        }

        for (int i = cur; i < N; i++) {
            number[cnt] = card[i];
            comb(cnt+1, i+1);
        }
    }
}
