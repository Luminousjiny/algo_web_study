import java.util.Scanner;
 
public class Main {
	public static boolean[][] map;
	public static int MIN = 64;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		map = new boolean[N][M];
		scanner.nextLine();
		for (int i = 0; i < N; i++) {
			String str = scanner.nextLine();
			for (int j = 0; j < M; j++) {
				if (str.charAt(j) == 'W') {
					map[i][j] = true;// W일 때는 true 
				} else {
					map[i][j] = false;// B일 때는 false
				}
			}
		}
		for (int i = 0; i < N-7; i++) {
			for (int j = 0; j < M-7; j++) {
				solve(i, j);
			}
		}
		System.out.println(MIN);
		scanner.close();
	}
	public static void solve(int x, int y) {
		int count = 0;
		boolean color = map[x][y];	// 첫 번째 칸의 색 
		for (int i = x; i < x+8; i++) {
			for (int j = y; j < y+8; j++) {
				if (map[i][j] != color) // 올바른 색이 아닐경우 count 1 증가 
					count++;
				color = !color;//색변경
			}
			color = !color;
		}
		count = Math.min(count, 64 - count);
		MIN = Math.min(MIN, count);
	}
}
 