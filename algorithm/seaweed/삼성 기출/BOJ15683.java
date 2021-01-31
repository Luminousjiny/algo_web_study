package day0131;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ15683 {
    /**
     * CCTV
     * - 1 : 1 방향, 총 4가지 경우
     * - 2 : 반대 두 방향, 총 2가지 경우
     * - 3 : 직각 2방향, 총 4가지 경우
     * - 4 : 3 방향, 총 4가지 경우
     * - 5 : 4 방향, 총 1가지 경우
     *
     * 벽(6) 통과 할 수 없음. 다른 CCTV는 건너 뛰기 가능
     *
     * - 입력
     *  - 사무실 크기 1x1 ~ 8x8
     *  - CCTV 개수 최대 8개
     *
     * - 출력
     *      사각지대의 최소 크기
     *
     * - 아이디어
     *   CCTV 최대 개수가 적고 사무실 크기도 작음 -> 완전 탐색
     */
    static int N, M, minBlindSpot;
    static int[][] map; // 사무실
    static int[] di = {1, 0, -1, 0}; // 상, 우, 하, 좌
    static int[] dj = {0, 1, 0, -1}; // 상, 우, 하, 좌
    static List<CCTV> cctvList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        minBlindSpot = Integer.MAX_VALUE;

        map = new int[N][M];
        cctvList = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0 && map[i][j] != 6) {
                    cctvList.add(new CCTV(i, j, map[i][j]));
                }
            }
        }

        dfs(0, map);
        System.out.println(minBlindSpot);
    }

    static class CCTV {
        int i, j, type;

        public CCTV(int i, int j, int type) {
            this.i = i;
            this.j = j;
            this.type = type;
        }
    }

    static void dfs(int cctvIdx, int[][] prevMap) {
        if (cctvIdx == cctvList.size()) {
            // 모든 CCTV 방향 설정 끝 사각지대 계산
            int currBlindSpot = 0;
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < M; ++j) {
                    if(prevMap[i][j] == 0)
                        ++currBlindSpot;
                }
            }
            minBlindSpot = Math.min(minBlindSpot, currBlindSpot);
            return;
        }

        int[][] currMap = new int[N][M];
        CCTV curr = cctvList.get(cctvIdx);

        switch (curr.type) {
            case 1:
                // 1번 CCTV : [상], [하], [좌], [우]
                for (int d = 0; d < 4; ++d) {
                    for (int r = 0; r < N; r++) {
                        currMap[r] = prevMap[r].clone();
                    }
                    check(curr.i, curr.j, d, currMap); // 해당 방향 탐색
                    dfs(cctvIdx + 1, currMap);
                }
                break;
            case 2:
                // 2번 CCTV : [상, 하], [좌, 우]
                for (int d = 0; d < 2; ++d) {
                    for (int r = 0; r < N; r++) {
                        currMap[r] = prevMap[r].clone();
                    }
                    check(curr.i, curr.j, d, currMap); // 해당 방향 탐색
                    check(curr.i, curr.j, d + 2, currMap); // 해당 방향 탐색
                    dfs(cctvIdx + 1, currMap);
                }
                break;
            case 3:
                // 3번 CCTV : [상, 우], [우, 하], [하, 좌], [좌, 상]
                for (int d = 0; d < 4; ++d) {
                    for (int r = 0; r < N; r++) {
                        currMap[r] = prevMap[r].clone();
                    }
                    check(curr.i, curr.j, d, currMap); // 해당 방향 탐색
                    check(curr.i, curr.j, (d + 1) % 4, currMap); // 해당 방향 탐색
                    dfs(cctvIdx + 1, currMap);
                }
                break;
            case 4:
                // 4번 CCTV : [상, 우, 하], [우, 하, 좌], [하, 좌, 상], [좌, 상, 우]
                for (int d = 0; d < 4; ++d) {
                    for (int r = 0; r < N; r++) {
                        currMap[r] = prevMap[r].clone();
                    }
                    check(curr.i, curr.j, d, currMap); // 해당 방향 탐색
                    check(curr.i, curr.j, (d + 1) % 4, currMap); // 해당 방향 탐색
                    check(curr.i, curr.j, (d + 2) % 4, currMap); // 해당 방향 탐색
                    dfs(cctvIdx + 1, currMap);
                }
                break;
            case 5:
                // 5번 CCTV : [상, 하, 좌, 우]
                for (int d = 0; d < 1; ++d) {
                    for (int r = 0; r < N; r++) {
                        currMap[r] = prevMap[r].clone();
                    }
                    check(curr.i, curr.j, 0, currMap); // 상
                    check(curr.i, curr.j, 1, currMap); // 우
                    check(curr.i, curr.j, 2, currMap); // 하
                    check(curr.i, curr.j, 3, currMap); // 좌
                    dfs(cctvIdx + 1, currMap);
                }
                break;
        }
    }

    static void check(int si, int sj, int dir, int[][] currMap) {
        int ni = si + di[dir];
        int nj = sj + dj[dir];

        while (ni >= 0 && ni < N && nj >= 0 && nj < M) {
            // 벽 만나면 끝
            if(currMap[ni][nj] == 6)
                break;

            if (currMap[ni][nj] == 0) {
                // 빈 칸인 경우 방문 체크
                currMap[ni][nj] = -1;
            }
            ni += di[dir];
            nj += dj[dir];
        }
    }
}
