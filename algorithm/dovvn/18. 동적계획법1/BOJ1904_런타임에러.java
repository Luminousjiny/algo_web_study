import java.util.Scanner;

//01타일
//피보나치처럼 1->2->3->5->8->...
public class Main {

    static int N;
    static long[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        dp = new long[N+1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=N; i++) dp[i] = (dp[i-2] + dp[i-1]) % 15746;
        System.out.println(dp[N]);
    }
}