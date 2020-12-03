package day1202;

import java.util.Scanner;

public class BOJ2231 {
    static int N, ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        ans = 0;

        /* String 사용 버젼
        *  메모리 : 60,000, 시간 : 352ms
        * String 객체 생성에 비용이 상당히 많이 드는듯
        */
//        for(int i = 1; i < N; i++){
//            int generated = i;
//            String curr = Integer.toString(i);
//            int size = curr.length();
//
//            for(int s = 0; s < size; s++){
//                generated += (curr.charAt(s) - '0');
//            }
//            if(N == generated) {
//                ans = i;
//                break;
//            }
//        }
        /*
         *  String 사용 안한 버젼
         *  메모리 : 18,000, 시간 : 228ms
         */
        for(int i = 1; i < N; i++){
            int generated = i;
            int tmp = i;
            while(tmp > 0){
                generated += (tmp % 10);
                tmp /= 10;
            }
            if(generated == N){
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
}
