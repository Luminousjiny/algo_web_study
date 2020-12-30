package day1230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2805 {
    /**
     * 적어도 M 미터의 나무를 가져가기 위한 H의 최댓값
     * 1 <= N <= 1,000,000
     * 1 <= M <= 2,000,000,000
     * 0 <= H <= 1,000,000,000
     */
    static int N, M, maxHeight;
    static int[] heights;
    static long H;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maxHeight = 0;

        heights = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            heights[i] = Integer.parseInt(st.nextToken());
            maxHeight = Math.max(maxHeight, heights[i]);
        }

        getTree(1, maxHeight);

        System.out.println(H);
    }

    static void getTree(long start, long end) {
        if (start > end) {
            return;
        }
        long mid = (start + end) / 2;
        long sum = 0;
        for (int height : heights) {
            long cut = (long)height - mid;
            sum += (cut > 0 ? cut : 0);
        }

        if (sum < M) { // 원하는 만큼 나무 못베었으면 더 낮은 높이로 나무 베기
            getTree(start, mid - 1);
        } else { // 원하는 만큼 나무는 베었는데 더 높은 높이도 가능한가 탐색
            H = Math.max(H, mid);
            getTree(mid + 1, end);
        }
    }
}
