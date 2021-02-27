package day0227;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ17779 {
    /**
     * 개리맨더링2
     * 5 <= N <= 20
     *
     * 기준점 (x, y), d1, d2
     * d1,d2 >= 1
     * 1 <= x < x + d1 + d2 <= N
     * 1 <= y - d2 < y < y + d2 <= N
     */
    static int N, total, ans; // 재현시 크기, 총 인구, 인구수 차이 최소값
    static int[] nums; // 각 선거구별 인구수
    static int[][] map;
    static boolean[][] zone;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        total = 0;
        ans = Integer.MAX_VALUE;
        for (int i = 1; i <= N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                total += map[i][j];
            }
        }

        // 총 인구수에 1,2,3,4 구역 인구수 빼면 5구역 인구수
        for (int i = 1; i <= N; ++i) {
            for (int j = 1; j <= N; ++j) {
                // (i, j)에서 가능한 구역 확인
                for (int d1 = 1; d1 < N; ++d1) {
                    for (int d2 = 1; d2 < N; ++d2) {
                        // (i,j)위치에서 d1, d2로 구역 생성 가능
                        if (checkRange(i, j, d1, d2)) {
                            nums = new int[5];
                            zone = new boolean[N + 1][N + 1]; // 구역 구분용 boolean 배열
                            // 구역 체크 + 인구수 구하기
                            checkZone5(i, j, d1, d2);
                            nums[0] = checkZone1(i, j, d1, d2);
                            nums[1] = checkZone2(i, j, d1, d2);
                            nums[2] = checkZone3(i, j, d1, d2);
                            nums[3] = checkZone4(i, j, d1, d2);
                            nums[4] = total - (nums[0] + nums[1] + nums[2] + nums[3]);

                            int maxNum = 0;
                            int minNum = Integer.MAX_VALUE;
                            for (int k = 0; k < 5; ++k) {
                                maxNum = Math.max(maxNum, nums[k]);
                                minNum = Math.min(minNum, nums[k]);
                            }
                            ans = Math.min(ans, maxNum - minNum);
                        }
                    }
                }
            }
        }
        System.out.println(ans);
    }

    static boolean checkRange(int x, int y, int d1, int d2) {
        return x + d1 + d2 <= N && y - d1 >= 1 && y + d2 <= N;
    }

    static void checkZone5(int x, int y, int d1, int d2) {
        // 5구역 경계선 체크
        for (int i = 0; i <= d1; ++i) {
            zone[x + i][y - i] = true;
            zone[x + d2 + i][y + d2 - i] = true;
        }
        for (int i = 0; i <= d2; ++i) {
            zone[x + i][y + i] = true;
            zone[x + d1 + i][y - d1 + i] = true;
        }
    }

    static int checkZone1(int x, int y, int d1, int d2) {
        int cnt = 0; // 1구역 인구 수
        for (int i = 1; i < x + d1; ++i) {
            for (int j = 1; j <= y; ++j) {
                if (!zone[i][j])
                    cnt += map[i][j];
                else
                    break;
            }
        }
        return cnt;
    }

    static int checkZone2(int x, int y, int d1, int d2) {
        int cnt = 0; // 2구역 인구 수
        for (int i = x + d2; i >= 1; --i) {
            for (int j = N; j > y; --j) {
                if(!zone[i][j])
                    cnt += map[i][j];
                else
                    break;
            }
        }
        return cnt;
    }

    static int checkZone3(int x, int y, int d1, int d2) {
        int cnt = 0; // 3구역 인구 수
        for (int i = x + d1; i <= N; ++i) {
            for (int j = 1; j < y - d1 + d2; ++j) {
                if(!zone[i][j])
                    cnt += map[i][j];
                else
                    break;
            }
        }
        return cnt;
    }

    static int checkZone4(int x, int y, int d1, int d2) {
        int cnt = 0; // 4구역 인구 수
        for (int i = N; i > x + d2; --i) {
            for (int j = N; j >= y - d1 + d2; --j) {
                if(!zone[i][j])
                    cnt += map[i][j];
                else
                    break;
            }
        }
        return cnt;
    }

}
