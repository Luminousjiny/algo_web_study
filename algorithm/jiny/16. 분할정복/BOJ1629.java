package day0102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 곱셈
public class BOJ1629 {
    static StringTokenizer st;
    static int A, B, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        // A^B % C
        // pow(a, n) = a^n .... 거듭제곱 함수 -> 입출력 모두 실수형(double)
        System.out.println(pow(A, B));
    }
    // 단순 반복문은 시간초과 -> 분할정복 필요
    /* 	pow(a,n)
    n=0 일 때	    1
    n이 짝수 일 때	pow(a,n/2)^2
    n이 홀수 일 때	pow(a,n/2)^2*a   */
    static long pow(int a, int n){
        if(n == 0) return 1;
        long tmp = pow(a, n/2);
        long res = (tmp * tmp) % C;
        if(n%2 != 0) res = res * a % C; // 홀수 일 때 한번 더 곱해줌
        return res;
    }
}
