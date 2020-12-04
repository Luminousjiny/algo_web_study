
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static char[][] map;
    static char[][] case1 = {
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
    };

    static char[][] case2 = {
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'}

    };
    static int Ans = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i=0; i<N; i++){
                map[i] = br.readLine().toCharArray();
        }//End input

        //1. 8*8로 잘랐을때 첫 시작 위치 구하기
        for(int i=0; i<N-7; i++){
            for(int j=0; j<M-7; j++){
                //2. 다시 칠해야 하는 개수 구하기
                draw(i, j);
            }
        }

        System.out.println(Ans);
    }

    private static void draw(int ni, int nj){
        int count1=0;
        int count2=0;

        for(int i = ni; i<=ni+7; i++){
            for(int j=nj; j<=nj+7; j++){
                if(map[i][j] != case1[i-ni][j-nj]) count1++;
                if(map[i][j] != case2[i-ni][j-nj]) count2++;
            }
        }

        Ans = Math.min(Ans, count1);
        Ans = Math.min(Ans, count2);
    }
}