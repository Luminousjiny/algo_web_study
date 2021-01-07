import java.util.Scanner;

public class Main {

    static int N,K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        long left = 1;
        long right = K;
        long mid = 0;
        long Ans = 0;

        while(left <= right){
            mid = (left + right) / 2;
            int cnt = 0;

            for(int i=1; i<=N; i++) cnt += Math.min(mid / i, N);

            if(cnt >= K){
                Ans = mid;
                right = mid-1;
            }
            else left = mid + 1;
        }//End 이분탐색

        System.out.println(Ans);

    }
}