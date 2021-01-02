package day0102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10816_binarySearch {
    static int N, M, low, high;
    static int[] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr); // 이진 탐색을 위한 정렬

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; ++i) {
            int curr = Integer.parseInt(st.nextToken());
            /* 방법 1 : 시간 초과 */
//            findNum(0, N - 1, curr);

            /* 방법 2 */
            low = Integer.MAX_VALUE;
            high = Integer.MIN_VALUE;

            binaryLow(0, N - 1, curr);
            binaryHigh(0, N - 1, curr);
            sb.append((high == Integer.MIN_VALUE ? 0 : high - low + 1)).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    /* 방법 1 - 시간 초과 */
    static void findNum(int start, int end, int target) {
        if (start > end) { // 해당 숫자 못찾은 경우
            sb.append("0 ");
            return;
        }

        int mid = (start + end) / 2;

        if (arr[mid] < target) {
            findNum(mid + 1, end, target);
        } else if (arr[mid] > target) {
            findNum(start, mid - 1, target);
        } else { // 해당 숫자 찾음. 좌우에 같은 값 몇개 있나 체크
            countNum(mid);
        }
    }

    static void countNum(int idx) {
        int count = 1;

        int tmpIdx = idx;
         // 오른쪽 방향 탐색
        while (tmpIdx + 1 < N) {
            if (arr[tmpIdx] == arr[tmpIdx + 1])
                ++count;
            else
                break;
            ++tmpIdx;
        }
        tmpIdx = idx;
        // 왼쪽 방향 탐색
        while (tmpIdx - 1 >= 0) {
            if(arr[tmpIdx] == arr[tmpIdx - 1])
                ++count;
            else
                break;
            --tmpIdx;
        }
        sb.append(count).append(" ");
    }

    /* 방법 2 */
    static void binaryLow(int start, int end, int target) {
        if (start > end) return;
        int mid = (start + end) / 2;

        if (arr[mid] < target) {
            binaryLow(mid + 1, end, target);
        } else if (arr[mid] > target) {
            binaryLow(start, mid - 1, target);
        } else {
            low = Math.min(low, mid);
            binaryLow(start, mid - 1, target);
        }
    }

    static void binaryHigh(int start, int end, int target) {
        if (start > end) return;
        int mid = (start + end) / 2;

        if (arr[mid] < target) {
            binaryHigh(mid + 1, end, target);
        } else if (arr[mid] > target) {
            binaryHigh(start, mid - 1, target);
        } else {
            high = Math.max(high, mid);
            binaryHigh(mid + 1, end, target);
        }
    }
}
