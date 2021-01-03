package day0103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ12015 {
    /**
     * 가장 긴 증가하는 부분 수열
     * 1 <= N, Ai <= 1,000,000
     */
    static int N;
    static ArrayList<Integer> subsequence;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        subsequence = new ArrayList<>();

        st = new StringTokenizer(br.readLine(), " ");
        subsequence.add(Integer.parseInt(st.nextToken())); // 처음 숫자 리스트에 넣어둠

        for (int i = 0; i < N - 1; ++i) {
            int curr = Integer.parseInt(st.nextToken());
            binarySearch(0, subsequence.size() - 1, curr);
        }
        System.out.println(subsequence.size());
    }

    static void binarySearch(int start, int end, int num) {
        if (start >= end) {
            if (start == subsequence.size() - 1) { // 현재 위치가 리스트 맨 마지막인 경우
                if (subsequence.get(start) < num) // 맨 마지막 값이 num보다 작으면 증가하는 수열이므로 num을 리스트 뒤에 넣어줌
                    subsequence.add(num);
                else // 맨 마지막값이 num보다 크면 값 변경
                    subsequence.set(start, num);
            } else if (subsequence.get(start) > num)
                subsequence.set(start, num);
            return;
        }

        int mid = (start + end) / 2;

        if (subsequence.get(mid) < num) {
            binarySearch(mid + 1, end, num);
        } else if (subsequence.get(mid) > num) {
            binarySearch(start, mid, num);
        }
    }
}
