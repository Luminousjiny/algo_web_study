package day1228;

import java.util.Scanner;

public class BOJ2606 {
	static int computer;
	static boolean[][] computerLink;
	static boolean[] visited;
	static int count;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		computer = scanner.nextInt();
		int M = scanner.nextInt();
		computerLink = new boolean[computer + 1][computer + 1];
		visited = new boolean[computer + 1];
		int[] value = new int[2];
		for (int i = 0; i < M; i++) {
			value[0] = scanner.nextInt();
			value[1] = scanner.nextInt();
			computerLink[value[0]][value[1]] = true;
			computerLink[value[1]][value[0]] = true;
		}
		dfs(1);
		System.out.println(count);
		scanner.close();
	}

	private static void dfs(int i) {
		if (visited[i] == true)
			return;
		visited[i] = true;
		for (int j = 1; j < computer + 1; j++) {
			if (computerLink[i][j] && !visited[j]) {
				dfs(j);
				count++;
			}
		}
	}
}
