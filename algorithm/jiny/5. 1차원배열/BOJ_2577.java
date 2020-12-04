package day1204;

import java.util.Scanner;

//숫자의 개수
public class BOJ_2577 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        String num = Integer.toString(A*B*C);
        int[] count = new int[10];
        for (int i = 0; i < num.length(); i++) {
            count[num.charAt(i)-'0']++;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(count[i]);
        }
    }
}
