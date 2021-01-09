import java.util.Scanner;

public class Main {

	// row행, col열
	static int N; // 체스판 크기
	static int[] col; // 각 행마다 열의 위치를 기억하자
	static int Ans; //퀸을 놓는 방법의 수

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		col = new int[N];
		setQueens(0); // 0행부터 시작
		System.out.println(Ans);
	}

	static void setQueens(int r) {
		//모든 행을 돌았다면
		if(r == N) {
			Ans++;
			return; //리턴하고 나서도 값을 되돌리지 않는다(가지치기)
		}
		
		//모든 열을 경우의 수로 두기
		for(int c=0; c<N; c++) {
			col[r] = c; //r행에서 c열 선택
			if(isPromising(r)){//해당 열에서 유망한지 확인
				setQueens(r+1); //다음행 ㄱㄱ
			}//유망하지 않으면 다음 열 검색
		}
	}

	static boolean isPromising(int r) {
		// 행, 열, 대각선 검사해서 이미 다른 퀸이 존재한다면
		for (int i = 0; i < r; i++) {
			if ((col[i] == col[r]) || Math.abs(col[r] - col[i]) == r - i) {
				return false; // 유망하지 않음
			}
		}
		return true;
	}
}