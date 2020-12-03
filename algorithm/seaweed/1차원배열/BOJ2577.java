package day1128;

import java.util.Scanner;

public class BOJ2577 {
    /**
     * A x B x C
     */
    static int result;
    static int[] count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        result = sc.nextInt() * sc.nextInt() * sc.nextInt();
        count = new int[10];

        while(result > 0){
            count[result % 10]++;
            result /= 10;
        }

        for(int c : count){
            System.out.println(c);
        }
    }
}
