package day1206;

import java.util.Scanner;

public class BOJ2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int ans = 0;
        for (int i = 1; i < N; i++) {
            int total = i;
            String S = Integer.toString(i);
            for (int j = 0; j < S.length(); j++) {
                total += S.charAt(j)-'0';
            }
            if(total == N){
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
}
