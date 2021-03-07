package day0307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ20058 {
    /**
     * 마법사 상어와 파이어 스톰
     */
    static int N, Q, mapSize, quantity, bigSize;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static int[] levels;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        mapSize = (int) Math.pow(2, N);
        map = new int[mapSize][mapSize];
        visited = new boolean[mapSize][mapSize];
        levels = new int[Q];
        quantity = 0;
        bigSize = 0;

        for (int i = 0; i < mapSize; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < mapSize; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < Q; ++i) {
            levels[i] = Integer.parseInt(st.nextToken());
        }

        // Q만큼 실행
        for (int q = 0; q < Q; ++q) {
            // 1. 2^L x 2^L 로 나눔 + 회전
            divide((int) Math.pow(2, levels[q]));
            // 2. 얼음 양 감소
            melting();
        }

        // 3. 남아있는 얼음 합 구하기 & 가장 큰 덩어리 사이즈 구하기
        for (int i = 0; i < mapSize; ++i) {
            for (int j = 0; j < mapSize; ++j) {
                quantity += map[i][j];

                if (!visited[i][j] && map[i][j] != 0) {
                    findBigSize(i, j);
                }
            }
        }


        System.out.println(quantity);
        System.out.println(bigSize);
    }

    static void divide(int level) {
        for (int i = 0; i < mapSize; i += level) {
            for (int j = 0; j < mapSize; j += level) {
                rotate(i, j, level);
            }
        }
    }

    static void rotate(int si, int sj, int level) {
        for (int i = 0; i < level / 2; ++i) {
            for (int j = i; j < level - i - 1; ++j) {
                int temp = map[si + i][sj + j];

                map[si + i][sj + j] = map[si + level - 1 - j][sj + i];
                map[si + level - 1 - j][sj + i] = map[si + level - 1 - i][sj + level - 1 - j];
                map[si + level - 1 - i][sj + level - 1 - j] = map[si + j][sj + level - 1 - i];
                map[si + j][sj + level - 1 - i] = temp;
            }
        }
    }

    static void melting() {
        List<Point> melting = new LinkedList<>();
        for (int i = 0; i < mapSize; ++i) {
            for (int j = 0; j < mapSize; ++j) {
                int count = 0;

                for (int d = 0; d < 4; ++d) {
                    int ni = i + di[d];
                    int nj = j + dj[d];

                    // 맵 내부고, 얼음이 있으면 count 증가
                    if (ni >= 0 && ni < mapSize && nj >= 0 && nj < mapSize && map[ni][nj] != 0) {
                        ++count;
                    }
                }
                // 3곳 이상 얼음과 인접해있지 않은 경우
                if (!(count >= 3 || map[i][j] == 0)) {
                    melting.add(new Point(i, j));
                }
            }
        }

        // 녹아야 할 얼음 녹임
        for (Point point : melting) {
            map[point.i][point.j] -= 1;
        }
    }

    static void findBigSize(int i, int j) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(i, j));
        visited[i][j] = true;

        int size = 1;

        while (!queue.isEmpty()) {
            Point curr = queue.poll();

            for (int d = 0; d < 4; ++d) {
                int ni = curr.i + di[d];
                int nj = curr.j + dj[d];

                if (ni >= 0 && ni < mapSize && nj >= 0 && nj < mapSize && !visited[ni][nj] && map[ni][nj] != 0) {
                    queue.add(new Point(ni, nj));
                    visited[ni][nj] = true;
                    size += 1;
                }
            }
        }

        bigSize = Math.max(bigSize, size);
    }

    static class Point {
        int i, j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
