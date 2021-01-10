package day0110;

import java.util.Scanner;

public class BOJ9663 {
    static int N, ANS;
    static int[] queens; // k번째 queen 놓은 위치 저장
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        queens = new int[N];
        ANS = 0;

        dfs(0);
        System.out.println(ANS);
    }

    static void dfs(int cnt) {
        if (cnt == N) {
            // 선택 끝
            ++ANS;
            return;
        }

        for (int i = 0; i < N; ++i) {
            if (checkPos(i, cnt)) {
                // 현재 위치에 Queen 놓을 수 있으면 놓고 진행
                queens[cnt] = i;
                dfs(cnt + 1);
            }
        }
    }

    static boolean checkPos(int pos, int row) {
        for (int i = 0; i < row; ++i) {
            if (queens[i] - (row - i) == pos || queens[i] == pos || queens[i] + (row - i) == pos)
                return false;
        }
        return true;
    }
}
