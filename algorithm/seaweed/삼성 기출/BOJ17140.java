package day0130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17140 {
    /**
     * 3x3 배열
     * 1초마다 연산
     * - R연산 : 모든 행에 대해서 정렬 수행. 행의 개수 >= 열의 개수인 경우만
     * - C연산 : 모든 열에 대해서 정렬 수행. 행의 개수 < 열의 개수인 경우만
     *
     * 연산 결과로 행, 열의 크기가 변할 수 있음
     * - 가장 큰 행,열 기준으로 크기가 변하고 크기가 커진 곳은 0으로 채움
     * - 수를 정렬 할 때 0은 무시
     *
     * 행 또는 열의 크기가 100을 넘어가면 처음 100개만 남기고 버림
     *
     * - 입력
     *      A에 들어있는 수와 r, c, k
     * - 출력
     *      A[r][c]에 들어있는 값이 k가 되기 위한 최소 시간
     *      100초가 지나도 A[r][c] = k가 되지 않으면 -1
     */
    static int R, C, K, rowNum, colNum, minTime;
    static int[][] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken()) - 1;
        C = Integer.parseInt(st.nextToken()) - 1;
        K = Integer.parseInt(st.nextToken());

        A = new int[100][100];
        minTime = -1; // 최소 시간
        rowNum = 3;
        colNum = 3;

        for (int i = 0; i < 3; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
            A[i][2] = Integer.parseInt(st.nextToken());
        }

        // 0 ~ 100초간 연산
        for (int i = 0; i <= 100; ++i) {
            // A[R][C] == K면 종료
            if (A[R][C] == K) {
                minTime = i;
                break;
            }
            

            if (rowNum >= colNum) {
                // 행 개수 >= 열 개수
                int maxRow = 0;
                for (int j = 0; j < rowNum; ++j) {
                    Map<Integer, Integer> map = new HashMap<>();
                    PriorityQueue<Number> pq = new PriorityQueue<>();

                    // 숫자 카운팅
                    for (int data : A[j]) {
                        if(data == 0) continue;
                        map.put(data, map.getOrDefault(data, 0) + 1);
                    }

                    // 카운팅 한 결과 토대로 정렬
                    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                        pq.add(new Number(entry.getKey(), entry.getValue()));
                    }
                    
                    // 이전에 입력된 값 전부 지움
                    for (int k = 0; k < colNum; ++k) {
                        A[j][k] = 0;
                    }

                    // 정렬된 값으로 채워넣는데 100개까지만 저장
                    int idx = 0;
                    while (!pq.isEmpty()) {
                        Number curr = pq.poll();
                        A[j][idx++] = curr.num;
                        A[j][idx++] = curr.cnt;

                        if(idx >= 100) break;
                    }
                    maxRow = Math.max(maxRow, idx);
                } // 모든 행 연산 끝
                colNum = maxRow;
            } else {
                // 행 개수 < 열 개수
                int maxCol = 0;
                for (int j = 0; j < colNum; ++j) {
                    Map<Integer, Integer> map = new HashMap<>();
                    PriorityQueue<Number> pq = new PriorityQueue<>();

                    for (int k = 0; k < colNum; ++k) {
                        if(A[k][j] == 0) continue;
                        map.put(A[k][j], map.getOrDefault(A[k][j], 0) + 1);
                    }
                    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                        pq.add(new Number(entry.getKey(), entry.getValue()));
                    }

                    for (int k = 0; k < rowNum; ++k) {
                        A[k][j] = 0;
                    }

                    int idx = 0;
                    while (!pq.isEmpty()) {
                        Number curr = pq.poll();
                        A[idx++][j] = curr.num;
                        A[idx++][j] = curr.cnt;

                        if(idx >= 100) break;
                    }
                    maxCol = Math.max(maxCol, idx);
                }
                rowNum = maxCol;
            }
        }
        System.out.println(minTime);
    }

    static class Number implements Comparable<Number>{
        int num, cnt;

        public Number(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Number o) {
            if (this.cnt == o.cnt) {
                return Integer.compare(this.num, o.num);
            }
            return Integer.compare(this.cnt, o.cnt);
        }
    }
}
