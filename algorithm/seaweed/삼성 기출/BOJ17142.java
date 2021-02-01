package day0201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17142 {
    /**
     * 시간 제한 1초
     *
     * - 바이러스
     *      - 상태 : 활성 / 비활성
     *              활성 -- 1초마다 상하좌우 --> 비활성
     *      - 목적 : 바이러스 M개를 활성 상태로 바꾸기
     * - 연구소 : NxN
     *      - 0 : 빈칸, 1 : 벽, 2 : 바이러스 놓을 수 있는 위치
     *      
     * - 입력
     *   4 <= N <= 50
     *   1 <= M <= 10
     *   M <= 바이러스 개수 <= 10
     *
     * - 출력
     *   모든 빈 칸에 바이러스가 있게 되는 최소 시간
     *   불가능한 경우 -1
     *
     * - 아이디어
     *    바이러스와 M의 범위가 충분히 작다 -> 조합 이용한 완탐
     *    바이러스 시작 위치 정한 뒤 BFS로 탐색
     */
    static int N, M, numVirus, numVacant, minTime;
    static int[] di = {1, -1, 0, 0}; // 상 하 좌 우
    static int[] dj = {0, 0, -1, 1}; // 상 하 좌 우
    static int[][] map;
    static int[] virusIndexes;
    static List<Virus> viruses;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        minTime = Integer.MAX_VALUE;
        viruses = new ArrayList<>(); // 바이러스 놓을 수 있는 위치
        virusIndexes = new int[M];
        map = new int[N][N];
        numVacant = 0; // 빈칸 개수
        numVirus = 0; // 바이러스 놓을 수 있는 위치 개수

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2)
                    viruses.add(new Virus(i, j));
                else if (map[i][j] == 0)
                    ++numVacant;
            }
        }

        if (numVacant != 0) { // 빈 칸 있는 경우
            numVirus = viruses.size();
            combination(0, 0);

            System.out.println(minTime == Integer.MAX_VALUE ? -1 : minTime);
        } else { // 빈 칸 없는 경우
            System.out.println(0);
        }
    }

    static class Virus {
        int i, j;

        public Virus(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static void combination(int cnt, int curr) {
        if (cnt == M) {
            // bfs 탐색 시작
            bfs();
            return;
        }

        for (int i = curr; i < numVirus; ++i) {
            virusIndexes[cnt] = i;
            combination(cnt + 1, i + 1);
        }
    }

    static void bfs() {
        Queue<Virus> queue = new LinkedList<>();
        int vacants = numVacant; // 빈칸 개수
        boolean[][] visited = new boolean[N][N];

        // 선택한 바이러스들 큐에 집어넣음
        for (int index : virusIndexes) {
            Virus virus = viruses.get(index);
            queue.add(virus);
            visited[virus.i][virus.j] = true;
        }

        // bfs 시작
        int currTime = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; ++i) {
                Virus curr = queue.poll();

                for (int d = 0; d < 4; ++d) {
                    int ni = curr.i + di[d];
                    int nj = curr.j + dj[d];

                    if (checkRange(ni, nj) && !visited[ni][nj]) {
                        queue.add(new Virus(ni, nj));
                        visited[ni][nj] = true;

                        // 해당 위치가 비활성 바이러스라면 빈칸 갯수 빼면 안됨
                        if(map[ni][nj] != 2) {
                            if (--vacants == 0) {
                                minTime = Math.min(minTime, currTime);
                                return;
                            }
                        }
                    }
                }
            }
            ++currTime; // 1초 증가
        }
    }

    static boolean checkRange(int ni, int nj) {
        return ni >= 0 && ni < N && nj >= 0 && nj < N && map[ni][nj] != 1;
    }
}
