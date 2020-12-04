import java.util.Scanner;

//체스판 다시 칠하기
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
    static int Ans = Integer.MAX_VALUE;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new char[N][M];

        for (int i=0; i<N; i++){
            String s = sc.next();
            for(int j=0; j<M; j++){
                map[i][j] = s.charAt(j);
            }
        }//End input

        //1. 8*8로 자르기
        int dist = 7;

        for(int i=0; i<N; i++){
            int startR = i;
            if(i+dist>=N) break;
            int endR = i+dist;

            for(int j=0; j<M; j++){
                int startC = j;
                if(j+dist>=M) break;
                int endC = j+dist;
                //2. 다시 칠해야 하는 개수 구하기
                draw(startR, endR, startC, endC);
            }
        }

        System.out.println(Ans);
    }

    private static void draw(int startR, int endR, int startC, int endC){
        int[][] chess = new int[8][8];
        int r=0;
        int c=0;

        for(int i = startR; i<=endR; i++){
            for(int j=startC; j<=endC; j++){
                chess[r][c] = map[i][j];
                c++;
            }
            c = 0;
            r++;
        }

        int count = 0; //새로 칠해야 하는 개수

        //case1이랑 비교
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(chess[i][j] != case1[i][j]) count++;
            }
        }
        Ans = Math.min(Ans, count);

        //case2랑 비교

        count = 0;
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(chess[i][j] != case2[i][j]) count++;
            }
        }
        Ans = Math.min(Ans, count);
    }
}
