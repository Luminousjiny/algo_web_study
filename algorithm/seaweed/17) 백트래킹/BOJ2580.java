package day0109;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2580 {
    /**
     * 9 x 9 스도쿠
     * 1. 가로 보고 넣을 수 있는 수 찾기
     * 2. 세로 보고 넣을 수 있는 수 찾기
     * 3. 3x3 보고 넣을 수 있는 수 찾기
     */
    static int[][] sudoku; // 매 시도마다 사용할 사본
    static final int SIZE = 9; // 스도쿠 사이즈
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        sudoku = new int[SIZE][SIZE];

        for(int i = 0; i < SIZE; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < SIZE; j++){
                sudoku[i][j] = Integer.parseInt(st.nextToken());
            }
        } // 입력 끝

        solve(0, 0);

        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                sb.append(sudoku[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
        br.close();
    }

    // 스도쿠 풀기(dfs)
    static boolean solve(int si, int sj){
        if((si == SIZE - 1 && sj == SIZE - 1 && sudoku[si][sj] != 0) || si == SIZE){
            // 1. 맨끝까지 왔는데 빈 칸이 아닌 경우
            // 2. 맨끝까지 값을 채워 넣은 경우
            return true;
        }

        if(sudoku[si][sj] == 0){ // 빈칸인 경우 넣을 수 있는 숫자 찾아서 넣어봄
            boolean[] check = new boolean[10];
            checkRow(si, check); // 가로줄 확인
            checkCol(sj, check); // 세로 확인
            checkRect((si / 3) * 3, (sj / 3) * 3, check); // 3x3 확인

            int num = getUsableNum(check); // 현재 넣을 수 있는 숫자 중 가장 작은 숫자 선택
            while(num != -1){
                sudoku[si][sj] = num;
                int nj = (sj + 1) % SIZE;
                int ni = (nj == 0) ? si + 1 : si;

                if(solve(ni, nj)) {
                    return true;
                }
                num = getUsableNum(check);
            }
            // 넣을 수 있는 숫자 다 넣어봤는데 통과 못한경우
            sudoku[si][sj] = 0;
            return false;
        } else { // 빈 칸 아닌 경우 다음 칸으로 진행
            int nj = (sj + 1) % SIZE;
            int ni = (nj == 0) ? si + 1 : si;

            return solve(ni, nj);
        }
    }

    // 해당 행 체크
    static void checkRow(int r, boolean[] check){
        for(int c = 0; c < SIZE; c++){
            check[sudoku[r][c]] = true;
        }
    }

    // 해당 열 체크
    static void checkCol(int c, boolean[] check){
        for(int r = 0; r < SIZE; r++){
            check[sudoku[r][c]] = true;
        }
    }

    // 3x3 체크
    static void checkRect(int r, int c, boolean[] check){
        for(int i = r; i < r + 3; i++){
            for(int j = c; j < c + 3; j++){
                check[sudoku[i][j]] = true;
            }
        }
    }

    // 사용할 수 있는 수 반환
    static int getUsableNum(boolean[] check){
        int result = -1;
        for(int i = 1; i <= SIZE; i++){
            if(!check[i]){
                result = i;
                check[i] = true;
                break;
            }
        }
        return result;
    }
}
