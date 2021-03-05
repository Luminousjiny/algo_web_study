package day0303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ17837 {
    /**
     * 새로운 게임 2
     * - N x N
     * - 1 ~ K 말, 이동방향 정해져있음
     * - 중간에 말 4개 쌓이는 순간 끝
     *
     * - 흰칸
     *  한 칸 이동 + 맨 위에 올려둠둠
     * - 빨간 칸
     *  A번 말과 그 위에 모든 말이 쌓여있는 순서가 바뀜
     * - 파란 칸 or 벽
     *  방향 반대로 바꾸고 한 칸 이동
     *  이동하려는 곳이 파란칸이나 벽이면 가만히 있음 -> 평생 이동 못하는 경우 발생
     *
     *
     * - 4 <= N <= 12
     * - 4 <= K <= 10
     */
    static int N, K, time;
    static boolean end;
    static int[] di = {0, 0, 0, -1, 1}; // 우, 좌, 상, 하
    static int[] dj = {0, 1, -1, 0, 0}; // 우, 좌, 상, 하
    static int[][] map;
    static LinkedList<Integer>[][] mapWithHorse;
    static List<Horse> horses;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        mapWithHorse = new LinkedList[N][N];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                mapWithHorse[i][j] = new LinkedList<>();
            }
        }
        horses = new ArrayList<>();

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 지도 저장 끝

        for (int k = 0; k < K; ++k) {
            st = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(st.nextToken()) - 1;
            int j = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            horses.add(new Horse(i, j, dir, k));
            mapWithHorse[i][j].add(k); // i, j에 k번 말 추가
        } // 말 저장 끝

        time = 1;

        while (time < 1000) {
            // 0번 말부터 이동
            for (Horse horse : horses) {
                int ni = horse.i + di[horse.dir];
                int nj = horse.j + dj[horse.dir];

                // 다음 위치가 파란색 or 체스판 밖인 경우 방향 바꿔서 이동
                if (ni < 0 || ni >= N || nj < 0 || nj >= N || map[ni][nj] == 2) {
                    horse.dir = (horse.dir == 1 || horse.dir == 3) ? horse.dir + 1 : horse.dir - 1;
                    ni = horse.i + di[horse.dir];
                    nj = horse.j + dj[horse.dir];
                }
                
                // 다음 이동 위치가 체스판 내부거나 파란색이 아닌 경우만 이동 진행
                if (ni >= 0 && ni < N && nj >= 0 && nj < N && map[ni][nj] != 2) {
                    int listLength = mapWithHorse[horse.i][horse.j].size();
                    switch (map[ni][nj]) {
                        case 0:
                            // 흰 칸 : 그대로 이동
                            for (int i = 0; i < listLength; ++i) {
                                if (mapWithHorse[horse.i][horse.j].get(i) == horse.idx) {
                                    int si = horse.i;
                                    int sj = horse.j;
                                    // 위에 쌓인 말까지 전부 다음 칸으로 이동
                                    for (int j = 0; j < listLength - i; ++j) {
                                        int moveIdx = mapWithHorse[si][sj].remove(i); // 이동 할 말 idx
                                        mapWithHorse[ni][nj].add(moveIdx); // 이동

                                        Horse moveHorse = horses.get(moveIdx);
                                        moveHorse.i = ni;
                                        moveHorse.j = nj;
                                    }
                                    
                                    // 4개 이상 쌓이면 게임 끝
                                    if (mapWithHorse[ni][nj].size() >= 4)
                                        end = true;
                                    break;
                                }
                            }
                            break;
                        case 1:
                            // 빨간 칸 : 순서 반대로
                            for (int i = 0; i < listLength; ++i) {
                                if (mapWithHorse[horse.i][horse.j].get(i) == horse.idx) {
                                    int si = horse.i;
                                    int sj = horse.j;
                                    // 맨 끝부터 현재 말까지 다음 칸으로 이동
                                    for (int j = 0; j < listLength - i; ++j) {
                                        int moveIdx = mapWithHorse[si][sj].removeLast();
                                        mapWithHorse[ni][nj].add(moveIdx);

                                        Horse moveHorse = horses.get(moveIdx);
                                        moveHorse.i = ni;
                                        moveHorse.j = nj;
                                    }

                                    // 4개 이상 쌓이면 게임 끝
                                    if (mapWithHorse[ni][nj].size() >= 4)
                                        end = true;
                                    break;
                                }
                            }
                            break;
                    }
                }

                if (end)
                    break;
            }
            if (end)
                break;
            ++time;
        }
        System.out.println((time >= 1000) ? -1 : time);
    }

    static class Horse {
        int i, j, dir, idx;

        public Horse(int i, int j, int dir, int idx) {
            this.i = i;
            this.j = j;
            this.dir = dir;
            this.idx = idx;
        }
    }
}
