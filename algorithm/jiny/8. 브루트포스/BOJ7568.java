package day1206;

import java.util.Scanner;

public class BOJ7568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N  = sc.nextInt();
        int[] w = new int[N]; // 몸무게 배열
        int[] h = new int[N]; // 키 배열
        for (int i = 0; i < N; i++) {
            w[i] = sc.nextInt();
            h[i] = sc.nextInt();
        }

        int[] lank = new int[N]; // 등수
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if(w[j] > w[i] && h[j] > h[i]){ // 키도크고 몸무게도 많고
                    cnt++;
                }
            }
            lank[i] = cnt+1;
        }
        for (int i = 0; i < N; i++) {
            System.out.print(lank[i]+" ");
        }

    }

}
