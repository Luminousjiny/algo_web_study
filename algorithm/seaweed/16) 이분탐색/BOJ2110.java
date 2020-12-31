package day1231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2110 {
    /**
     * 수직선 위 N개의 집
     * C개의 공유기를 설치하여 가장 인접한 두 공유기 사이의 거리를 최대
     *
     * 2 <= N <= 200,000
     * 2 <= C <= N
     * 0 <= xi <= 1,000,000,000
     */
    static int N, C;
    static int[] houses; // 집 좌표들
    static long ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        houses = new int[N];
        ans = 0;

        for (int i = 0; i < N; ++i) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses);

        buildRouter(1, houses[N - 1] - houses[0]);

        System.out.println(ans);
    }

    static void buildRouter(long start, long end) {
        if (start > end) return;

        long mid = (start + end) / 2; // 라우터간 거리
        int prev = houses[0];
        int restCnt = C - 1; // 설치할 라우터 개수. 첫 위치에 무조건 설치
        for (int i = 1; i < N; ++i) {
            if (houses[i] - prev >= mid) {
                restCnt--;
                prev = houses[i];
            }
        }

        if (restCnt > 0) { // 라우터 다 설치 못함. 라우터 간격 더 줄여야 함
            buildRouter(start, mid - 1);
        } else { // 라우터 전부 설치 가능. 간격 더 넓힐 수 있는지 확인
            ans = Math.max(ans, mid);
            buildRouter(mid + 1, end);
        }
    }
}
