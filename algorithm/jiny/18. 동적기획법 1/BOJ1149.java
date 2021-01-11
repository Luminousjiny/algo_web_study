package day0108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// RGB 거리
public class BOJ1149 {
    static StringTokenizer st;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N+1][3]; // 1번부터 시작(i-1일때 인덱스 안벗어남), RGB->3가지 : 주어진 비용 저장
        int[][] dp = new int[N+1][3]; // 비용 기록할 배열
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 색 칠하는 비용 채우기

        // 조건 3가지 -> 즉, 나와 근접해 있는 집의 색이 같으면 안된다는 조건
        // N번째 집을 칠할 때,
        //      R로 칠할 경우, N-1번째 칸이 G, B 중 최소 비용 .... + N 번째에 R을 칠하는 비용
        //      G                        R, B
        //      B                        R, G
        // 즉, N 번째의 색이 결정되면 각각 비용이 다름 ... 모두 탐색
        // 각 칸에는 최소 비용이 기록됨 ...> 누적된 비용임
        // 즉 2번 칸에는 1번칸 비용 + 2번칸에 오는 최소 비용
        //   3번 칸에는 2번칸(1번칸 누적되어있음) 비용 + 3번칸에 오는 최소 비용
        //  .... 이런식으로 쭉쭉...기록      -> d[n] = d[n-1] + 최소값 a[n]
        for (int i = 1; i <= N; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0]; // 0(R)로 칠할 경우 -> 전에 기록된 비용이 1(G), 2(B) 중 최소인 값 + 0(R)로 칠할 비용
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1]; // 1(G)로 칠할 경우 -> 전에 기록된 비용이 0(R), 2(B) 중 최소인 값 + 1(G)로 칠할 비용
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2]; // 2(B)로 칠할 경우 -> 전에 기록된 비용이 0(R), 1(G) 중 최소인 값 + 2(B)로 칠할 비용
        }
        // 가장 마지막.. N번째 기록된 비용 중 최소 비용 -> 정답
        System.out.println( Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]) );


    }
}
