package day1204;

import java.util.Scanner;

public class BOJ8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int TC = 0; TC < T; TC++) {
            String S = sc.next();
            int cnt = 0;
            int total = 0;
            for (int i = 0; i < S.length(); i++) {
                if(S.charAt(i) == 'O'){
                    cnt++;
                    total += cnt;
                }
                if(S.charAt(i) == 'X'){
                    cnt = 0;
                }
            }
            System.out.println(total);
        }
    }
}
