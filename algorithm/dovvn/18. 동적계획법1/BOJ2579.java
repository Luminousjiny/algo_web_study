import java.util.Scanner;

//계단 오르기
//처음=>재귀: 시간초과
public class Main {

    static int N; //계단의 개수
    static int[] stairs;
    static int[] dp; //현재 계단에 올랐을때 최대값

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        stairs = new int[N+1];
        dp = new int[N+1];

        for(int i=1; i<=N; i++) stairs[i] = sc.nextInt();

        dp[1] = stairs[1];
        if(N >= 2) dp[2] = stairs[1] + stairs[2]; //계단이 한개일 수 있으므로

        //직전칸과 전전칸 중 최대값 저장
        for(int i=3; i<=N; i++) dp[i] = Math.max(stairs[i]+stairs[i-1]+dp[i-3], stairs[i]+dp[i-2]);
        System.out.println(dp[N]);
    }
}