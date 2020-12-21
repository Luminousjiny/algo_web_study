package day1221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
// 단지번호 붙이기
public class BOJ2667 {
    static int[][] apart;
    static int cnt, total; // 한 단지의 아파트 개수, 1의 개수, 단지 수

    static int[] di = { -1, 1, 0, 0 }; // 상 하 좌 우
    static int[] dj = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException { // 예외처리 필수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
        int N = Integer.parseInt(br.readLine());

        Queue<point> qu = new LinkedList<>();
        Queue<Integer> num = new LinkedList<Integer>(); // 단지 아파트 수 저장
        apart = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                apart[i][j] = s.charAt(j) - '0';
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (apart[i][j] == 1) {
                    apart[i][j] = 0;
                    qu.add(new point(i, j)); // 1인 좌표값 찾기
                    int nx = 0, ny = 0;
                    cnt = 0;
                    while (!qu.isEmpty()) {

                        int size = qu.size();
                        for (int s = 0; s < size; s++) {
                            point now = qu.poll();

                            cnt++; // 큐에서 뺄때마다 cnt증가
                            for (int dir = 0; dir < 4; dir++) {
                                int x = now.i;
                                int y = now.j;
                                nx = x + di[dir];
                                ny = y + dj[dir];

                                if (nx >= 0 && nx < N && ny >= 0 && ny < N) { // 범위 내에서
                                    if (apart[nx][ny] == 1) {// 이동칸이 1이면
                                        qu.add(new point(nx, ny));
                                        apart[nx][ny] = 0; // 0으로 바꿔주기
                                    }
                                }

                            } // dir

                        } // size
                    } // while-하나의 그래프 탐색
                    num.offer(cnt);
                    total++;
                }
            }
        }

        int[] ans = new int[total];
        for (int h = 0; h < total; h++) {
            ans[h] = num.poll();
        }
        Arrays.sort(ans);
        System.out.println(total);
        for (int k = 0; k < total; k++) {
            System.out.println(ans[k]);
        }
    }

    static class point {// 좌표 x,y 를 한번에 저장
        int i, j;

        point(int x, int y) {
            i = x;
            j = y;
        }
    }
}
