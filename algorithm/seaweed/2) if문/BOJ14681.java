package backjoon;

import java.util.Scanner;

public class BOJ14681 {
    /**
     * (x, y) 주어졌을 떄 몇 사분면인지 출력
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        boolean xSigned = sc.nextInt() > 0;
        boolean ySigned = sc.nextInt() > 0;

        if(xSigned){
            // x > 0
            if(ySigned){
                // y > 0
                result = 1;
            } else {
                // y < 0
                result = 4;
            }
        } else {
            // x < 0
            if(ySigned){
                // y > 0
                result = 2;
            } else {
                // y < 0
                result = 3;
            }
        }
        System.out.println(result);
    }
}
