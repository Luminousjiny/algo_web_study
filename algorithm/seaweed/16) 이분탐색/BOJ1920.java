package day1229;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1920 {
    /**
     * N개의 정수가 주어졌을 때, X라는 정수가 존재하는지 찾기
     * 1 <= N <= 100,000
     * 1 <= M <= 100,000
     */
    static int N, M;
    static int[] arrN, arrM;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        //========데이터 입력==============
        N = Integer.parseInt(br.readLine());
        arrN = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            arrN[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        arrM = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; ++i) {
            arrM[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrN);
        //=================================

        for (int m : arrM) {
            sb.append(binarySearch(0, N - 1, m) ? 1 : 0).append("\n");
        }
        System.out.println(sb.toString());
    }

    static boolean binarySearch(int start, int end, int target) {
        if (start == end)
            return arrN[start] == target;

        int mid = (start + end) / 2;

        if (arrN[mid] == target)
            return true;
        else if (arrN[mid] > target){
            return binarySearch(start, mid, target);
        } else {
            return binarySearch(mid + 1, end, target);
        }
    }
}
