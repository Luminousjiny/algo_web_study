package day0109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14888 {
    static int N, MAX, MIN;
    static int[] nums;
    static int[] ops; //1 : 덧셈, 2 : 뺄셈, 3: 곱셈, 4: 나눗셈
    static boolean[] visited; // 연산자 사용 여부 체크
    static int[] selected; // 선택된 연산자
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        ops = new int[N - 1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; ++i) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        int idx = 0;
        for (int i = 0; i < 4; ++i) {
            int cntOps = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cntOps; ++j) {
                ops[idx + j] = i + 1;
            }
            idx += cntOps;
        }

        visited = new boolean[N - 1];
        selected = new int[N - 1];
        MAX = Integer.MIN_VALUE;
        MIN = Integer.MAX_VALUE;
        dfs(0);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    static void dfs(int cnt) {
        if (cnt == N - 1) {
            int result = nums[0];
            for (int i = 1; i < N; ++i) {
                switch (selected[i - 1]) {
                    case 1:
                        result += nums[i];
                        break;
                    case 2:
                        result -= nums[i];
                        break;
                    case 3:
                        result *= nums[i];
                        break;
                    case 4:
                        result /= nums[i];
                        break;
                }
            }
            MAX = Math.max(MAX, result);
            MIN = Math.min(MIN, result);
            return;
        }

        int before = 0; // 중복 제거
        for (int i = 0; i < N - 1; ++i) {
            if (!visited[i] && (i == 0 || before != ops[i])) {
                before = ops[i];
                selected[cnt] = ops[i];
                visited[i] = true;
                dfs(cnt + 1);
                visited[i] = false;
            }
        }
    }
}
