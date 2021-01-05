import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//종이의 개수
public class Main {

    static int N;
    static int[][] map;
    static int[][] ansArr = new int[1][3];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }//End input

        divide(0, 0, N);
        for(int i=0; i<3; i++) System.out.println(ansArr[0][i]);
    }

    static void divide(int x, int y, int size) {

        if(size==1){
            ansArr[0][map[x][y]+1]++;
            return;
        }

        if (!check(x, y, size)) { //현재 종이가 모두 같은값인지 체크
            for (int i = 0; i < 3; i++) {//9개 분할
                for (int j = 0; j < 3; j++) {
                    divide(x + size/3*i, y + size/3*j, size/3);
                }
            }
        }
    }

    static boolean check(int x, int y, int size) {
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(map[x][y] != map[x+i][y+j]) return false;
            }
        }

        //더이상 자를필요 없으므로 종이수 추가
        ansArr[0][map[x][y]+1]++;
        return true;
    }
}