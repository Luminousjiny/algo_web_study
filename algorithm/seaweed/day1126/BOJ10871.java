package day1126;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10871 {
    /**
     * 정수 N개로 이루어진 수열 A, 정수 X
     * X보다 작은 수 전부 출력
     *
     * 시간 복잡도 : O(N)
     * - N개 수열 입력받으면서 동시에 처리
     * 공간 복잡도 : O(1)
     * - 수열 따로 저장하지 않고 입력 받으면서 비교하기 때문에 추가적인 메모리 필요 없음
     */
    static int N, X, input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++){
            input = Integer.parseInt(st.nextToken());
            if( input < X){
                sb.append(input).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
