package 분할정복;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


/*
 제곱수를 기준으로 분할 정복을 한다.

1 : 자기 자신을 그대로 반환한다.
짝수 : (제곱 수 / 2) 제곱을 해준 행렬를 각각 곱한다. 
홀수 : (제곱 수 - 1) 제곱을 해준 행렬과 1 제곱 행렬을 곱한다.

 */
public class BOJ10830 {
	static int N;
	static int[][]matrix;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		matrix = new int[N][N];
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		long[][] answer = multiple(B);
		for(int i = 0 ; i < N; i++) {
			for(int j = 0 ; j < N; j++) {
				bw.append(answer[i][j]% 1000 +" ");
			}
			bw.append("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	private static long[][] multiple(long B){
		long[][] answer = new long[N][N];
		long[][] temp = new long[N][N];
		
		if(B == 1) {//본인 반환
			for(int i = 0 ; i < N; i++) {
				for(int j = 0 ; j < N; j++) {
					answer[i][j] = matrix[i][j] % 1000;
				}
			}
		}else if(B % 2 == 0) {//짝수
			temp = multiple(B/2);
			for(int i = 0 ; i < N; i++) {
				for(int j = 0 ; j < N; j++) {
					int input = 0;
					for(int k = 0 ; k < N; k++) {
						input += (temp[i][k] * temp[k][j]);
					}
					answer[i][j] = input%1000;
				}
			}
		}else {//홀수
			temp = multiple(B-1);
			for(int i = 0 ; i < N; i++) {
				for(int j = 0 ; j < N; j++) {
					int input = 0;
					for(int k = 0 ; k < N; k++) {
						input += (temp[i][k] * matrix[k][j]);
					}
					answer[i][j] = input%1000;
				}
			}
		}
		return answer;
	}
}
