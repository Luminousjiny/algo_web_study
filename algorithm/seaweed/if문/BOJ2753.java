package backjoon;

import java.util.Scanner;

public class BOJ2753 {
    /**
     * 윤년이면 1 아니면 0
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        System.out.println(((year % 4 == 0 && year % 100 != 0)|| year % 400 == 0) ? 1 : 0);
    }
}
