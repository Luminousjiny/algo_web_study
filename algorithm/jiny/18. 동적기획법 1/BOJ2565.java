package day0111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 전기줄
// 문제 : 연결된 전기 줄을 제공하고 교차하지 않으려면 최소 몇개를 제어해야하는가?
// 해석 : 가능한 전기줄을 제공하고 교차하지 않고 최대 몇개 추가 가능한가? (훨씬 쉬운 접근...)
// 1. A를 기준으로 오름차순 정렬 ... B도 오름차순 정렬이면 안겹침
// 2. 그래서 B를 LIS 탐색 (dp 탐색 이용)... 최장길이 len ... 이게 안겹치게 가능한 수
// 3. 가능한 전기줄 수 N - len = 최소 제거 개수!!!
public class BOJ2565 {
    static StringTokenizer st;
    static int N;
    static Connect[] line;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 전기줄 수
        line = new Connect[N]; // N 개 연결여부 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            line[i] = new Connect(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(line); // 오름차순 정렬

        dp = new int[N];
        int len = LIS(); // 탐색 후 최장 길이 반환
        System.out.println(N - len); // 전체에서 가능한 최장길이 빼면 정답
    }

    static int LIS(){ // 최장길이 dp 탐색
        dp[0] = 1;
        int max = 0;
        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(line[i].b >= line[j].b && dp[j]+1 > dp[i]) dp[i] = dp[j] +1;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    static class Connect implements Comparable<Connect>{
        int a, b;
        Connect(int a, int b){
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Connect o) {
            return Integer.compare(this.a, o.a); // a기준 오름차순 ...> 양음수 상관없는 형태
        }
    }
}
