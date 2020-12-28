package day1228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1992 {
	/* 
	 * N x N (1 <= N <= 64)
	 */
	static int N;
	static char[][] map;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		compress(N, 0, 0);
		System.out.println(sb.toString());
	}
	
	static void compress(int size, int si, int sj) { // (si, sj) 에서 한 변 길이가 size인 사각형 체크
		if(size == 1) { // 1칸 짜리
			sb.append(map[si][sj]);
			return;
		}
		
		if(checkArea(size, si, sj)) { // 해당 구역 전부 같은 값인 경우
			sb.append(map[si][sj]);
			return;
		}
		
		sb.append("(");
		compress(size/2, si, sj); // 2 사분면
		compress(size/2, si, sj + size/2); // 1 사분면
		compress(size/2, si + size/2, + sj); // 3 사분면
		compress(size/2, si + size/2, sj + size/2); // 4 사분면
		sb.append(")");
	}
	static boolean checkArea(int size, int si, int sj) {
		for(int i = si; i < si + size; i++) {
			for(int j = sj; j < sj + size; j++) {
				if(map[i][j] != map[si][sj])
					return false;
			}
		}
		return true;
	}
}