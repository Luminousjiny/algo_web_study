package day1221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
        ArrayList<Integer> num = new ArrayList<>(); // 단지 아파트 수 저장
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
                    cnt = 0;
                    while (!qu.isEmpty()) {
                        point now = qu.poll();
                        cnt++; // 큐에서 뺄때마다 cnt 증가
                        for (int dir = 0; dir < 4; dir++) {
                            int nx = now.i + di[dir];
                            int ny = now.j + dj[dir];
                            if (nx >= 0 && nx < N && ny >= 0 && ny < N && apart[nx][ny] == 1) { // 범위 내에서 1이면
                                qu.add(new point(nx, ny));
                                apart[nx][ny] = 0; // 0으로 바꿔주기
                            }
                        } // dir
                    } // while-하나의 그래프 탐색
                    num.add(cnt);
                    total++;
                }
            }
        }
        Collections.sort(num);
        System.out.println(total);
        for (int k = 0; k < total; k++) {
            System.out.println(num.get(k));
        }
    }
    static class point {
        int i, j;
        point(int x, int y) {
            i = x;
            j = y;
        }
    }
}
