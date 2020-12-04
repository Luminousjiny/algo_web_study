package day1204;

import java.util.Scanner;

public class BOJ2562 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[9];

        for (int i = 0; i < 9; i++) {
            num[i] = sc.nextInt();
        }
        int max = num[0];
        for (int i = 0; i < 9; i++) {
            max = Math.max(max, num[i]);
        }
        int cnt = 0;
        for (int i = 0; i < 9; i++) {
            if(max == num[i]){
                cnt = i;
            }
        }

        System.out.println(max);
        System.out.println(cnt+1);
    }
}
