package day1202;

import java.util.Scanner;

public class BOJ1436 {
    static int N, cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        cnt = 0;

        int i = 1;
        while(true){
            int tmp = i;
            while(tmp > 0){
                if(tmp % 1000 == 666){ // 666들어있나 확인
                    cnt++;
                    break;
                }
                tmp /= 10;
            }
            if(cnt == N) // N번째 종말의 수 찾은 경우
                break;
            i++;
        }
        System.out.println(i);
    }
}
