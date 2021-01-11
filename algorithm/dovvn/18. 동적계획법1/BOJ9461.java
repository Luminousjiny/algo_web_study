import java.util.Scanner;

//파도반 수열
public class Main {

    static long[] dp = new long[101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for(int i=1; i<=3; i++) dp[i] = 1;
        for(int i=4; i<=100; i++){//규칙에 따라 P(i)값 구하기
            dp[i] = dp[i-2] + dp[i-3];
        }

        for(int tc=0; tc<T; tc++){
            int N = sc.nextInt();
            sb.append(dp[N]+"\n");
        }

        System.out.println(sb+"");
    }
}