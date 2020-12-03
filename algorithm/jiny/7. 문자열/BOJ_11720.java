package day1203;

import java.util.Scanner;

public class BOJ_11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s =  sc.next();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = s.charAt(i) -'0';
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += num[i];
        }
        System.out.println(sum);
    }
}
