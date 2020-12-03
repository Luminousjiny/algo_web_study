package day1127;

import java.util.Scanner;

public class BOJ1110 {
    /**
     * 0 ~ 99 사이의 숫자
     * 10보다 작으면 앞에 0을 붙여 두 자리 수로 만든다. (03, 04, ...)
     */
    static int start, next, ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ans = 0;
        start = sc.nextInt();
        next = start;

        do  {
            next = (next % 10) * 10 + ((next / 10) + (next % 10)) % 10;
            ++ans;
        } while(start != next);
        System.out.println(ans);
    }
}
