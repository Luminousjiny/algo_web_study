package day0103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
// 나무자르기
public class BOJ2805 {
    static StringTokenizer st;
    static int N, M, start, end, high, ans;
    static Integer[] trees;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 나무 수
        M = Integer.parseInt(st.nextToken()); // 최소 가져갈 길이
        trees = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        } // 나무 채우기
        Arrays.sort(trees, Collections.reverseOrder()); // 내림차순
        start = 0;
        end = trees[0];
        // 이분탐색 시작
        while (start <= end){
            high = (start+end)/2; // 가운데 지점 찾기
            long len = 0;
            int id = 0;
            while (true){
                // 배열 id가 인덱스 밖이거나, 정렬 되었으므로 높이가 정한 길이보다 작아지면 더이상 볼 필요 없음
                if(id >= N || trees[id] < high) break;
                len += trees[id] - high; // 예외가 아니면 배열 돌면서 정한 높이 빼고 누적
                id++;
            }
            // 시작점 끝점 갱신
            if(len < M) end = high-1; // 끝점을 정한 가운데 지점-1로 다시 이분탐색하기
            else {
                //ans = Math.max(ans, high); // 최소 M을 가져가려면 최대 high 는 가능한 높이중 최대값
                //ans = high; // 이것도 통과 되던데 상관없나...?
                start = high+1; // 사직점을 정한 가운데 지점 +1로 다시 이분탐색
            }
        }
        System.out.println(end);
    }
}
