package 분할정복;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1992 {
	static int N;
	static int[][] map;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];// N,N행렬
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = temp.charAt(j) - '0';
			}
		}

		Point start = new Point(0, 0);
		if (checkMap(start, N) == true)
			sb.append(map[start.x][start.y]);
		else {
			recur(start, N);
		}

		System.out.println(sb.toString());
	}

	public static void recur(Point start, int size)// 0,0에서 size는 8
	{
		if(size == 1) {
			sb.append(map[start.x][start.y]);
			return;
		}
		else if (size != 1) {
			sb.append("(");
			Point temp1 = new Point(start.x, start.y); // 좌상, 우상, 좌하 , 우하 시작점을 temp에
			divide(temp1, size / 2);
			Point temp2 = new Point(start.x, start.y + size / 2);
			divide(temp2, size / 2);
			Point temp3 = new Point(start.x + size / 2, start.y);
			divide(temp3, size / 2);
			Point temp4 = new Point(start.x + size / 2, start.y + size / 2);
			divide(temp4, size / 2);
			sb.append(")");
		} 
	}

	public static void divide(Point temp, int size) {
		if (checkMap(temp, size) == true) {
			sb.append(map[temp.x][temp.y]);
			return;
		} else {
			recur(temp, size);
		}

	}

	public static boolean checkMap(Point start, int size) {
		int temp = map[start.x][start.y];// 처음걸 빼내와보자
		for (int i = start.x; i < start.x + size; i++) {
			for (int j = start.y; j < start.y + size; j++) {
				if (map[i][j] != temp)
					return false; // 처음값과 다르다면 false를 반납하자
			}
		}
		return true;// 다 나왔는데 같다면true를 반납하자
	}

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}