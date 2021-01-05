package 분할정복;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 행렬 곱셈에 대해 : https://j1w2k3.tistory.com/575
 */

public class BOJ2740 {
	static int N,M,K;
	static int[][]matrix;
	static int[][]matrix2;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		matrix = new int[N][M];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M ; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st= new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		matrix2 = new int[M][K];
		for(int i = 0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < K ; j++) {
				matrix2[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ; j < K; j++) {
				bw.append(multiple(i,j) + " ");
			}
			bw.append("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	private static int multiple(int row, int col){
		int input = 0;
		for(int i = 0 ; i < M; i++) {
			input += (matrix[row][i] * matrix2[i][col]);
		}
		return input;
	}
}
