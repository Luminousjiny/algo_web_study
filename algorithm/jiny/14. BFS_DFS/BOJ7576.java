package day1221;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// 토마토 2차원
public class BOJ7576{
    static int[] di = { -1, 1, 0, 0 }; // 상 하 좌 우
    static int[] dj = { 0, 0, -1, 1 };
    static int[][] tomato;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(); // 열
        int N = sc.nextInt(); // 행

        Queue<point> qu = new LinkedList<>();

        int count = 0;
        tomato = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tomato[i][j] = sc.nextInt();
                if (tomato[i][j] == 1) {
                    qu.add(new point(i, j));
                } else if (tomato[i][j] == 0) {
                    count++;
                }
            }
        } // 배열 채우기

        int day = 0;
        int newi = 0, newj = 0;
        while (!qu.isEmpty()) {
            int size = qu.size();
            for (int s = 0; s < size; s++) {
                point now = qu.poll();

                for (int dir = 0; dir < 4; dir++) {
                    int x = now.i;
                    int y = now.j;
                    newi = x + di[dir];
                    newj = y + dj[dir];

                    if (newi < N && newi >= 0 && newj < M && newj >= 0) { // 배열 내에서
                        if (tomato[newi][newj] == 0) { // 1도 아니고
                            tomato[newi][newj] = 1;
                            qu.add(new point(newi, newj));
                            count--;

                        }
                    }
                }
            }
            day++;
        } // while
        System.out.println(count == 0 ? day - 1 : -1);
    }

    static class point {// 좌표 x,y 를 한번에 저장
        int i, j;

        point(int x, int y) {
            i = x;
            j = y;
        }
    }
}

