import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//행렬 곱셈
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] B = new int[M][K];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<K; j++){
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //행렬곱셈
        int[][] ans = new int[N][K];

        for(int i=0; i<N; i++){
            for(int j=0; j<K; j++){
                for(int k=0; k<M; k++){
                    ans[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        //출력
        for(int i=0; i<N; i++){
            for(int j=0; j<K; j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }


    }
}