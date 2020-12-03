package day1202;

import java.util.Scanner;

//한수
public class BOJ1065 {
    static int ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(num<100){
            ans = num;
        }else{
            int cnt = 0;
            for (int i = 100; i <= num; i++) {
                // 각 자리 숫자 차이가 같은지 보고 같은 숫자 세기
                if(((i/100) - ((i%100)/10)) == (((i%100)/10) - (i%10))){
                    cnt++;
                }
            }
            ans = 99 + cnt;
        }
        System.out.println(ans);
    }
}
