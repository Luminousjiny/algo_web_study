package day1128;

import java.util.Scanner;

public class BOJ2562 {
    /**
     * 9개의 서로 다른 자연수
     * 최대값 찾고 몇 번째 수인지 구하시오
     */
    static int maxN, maxIdx;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 1; i <= 9; i++){
            int curr = sc.nextInt();
            if(curr > maxN){
                maxIdx = i;
                maxN = curr;
            }
        }
        System.out.println(maxN + "\n" + maxIdx);
    }
}
