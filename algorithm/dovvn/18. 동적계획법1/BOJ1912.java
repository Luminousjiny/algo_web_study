import java.util.Scanner;

//연속합
public class Main {

    static int N;
    static int[] nums;
    static int[] dp;
    static int Ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        nums = new int[N];
        dp = new int[N];

        for(int i=0; i<N; i++) nums[i] = sc.nextInt();

        dp[0] = nums[0];
        Ans = dp[0];

        for(int i=1; i<N; i++){
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i-1]+nums[i]); //앞에서 구한 최대값+현재 배열값 or 이전 배열값+현재 배열값
            dp[i] = Math.max(dp[i], nums[i]); //앞에서 아무것도 선택x

            Ans = Math.max(Ans, dp[i]);
        }
        System.out.println(Ans);
    }
}