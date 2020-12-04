package day1204;

import java.util.Scanner;
//더하기 사이클
public class BOJ1110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 정수 입력
        int[] num = new int[2];
        if(N/10 == 0 ){
            num[1] = N;
        }else{
            num[0] = N/10;
            num[1] = N%10;
        }

        int cnt = 0;
        while (true){
            int tmp1 = num[1];
            int tmp2 = ( num[0] + num[1] )%10;
            cnt++;
            if( tmp1 == N/10 && tmp2 == N%10) break;
            num[0] = tmp1;
            num[1] = tmp2;

        }
        System.out.println(cnt);

    }
}
