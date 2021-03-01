import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int R;
	static int C;
	static int K;
	static int answer = 0;
	static int[][] map;
	static ArrayList<Number> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[3][3]; // 크기가 3 x 3

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			if (answer > 100) { // 100을 넘어가는 경우에는 처음 100개를 제외한 나머지는 버린다.
				answer = -1;
				break;
			}
			if (R - 1 < map.length && C - 1 < map[0].length) {// 끝자락에 도착했을때
				if (map[R - 1][C - 1] == K) {//값이 K인가?
					break;
				}
			}
			if (map.length >= map[0].length) {//행보다 열이 크거나 같으면 R연산
				rowOperation();
			} else {//작다면 C연산
				columnOperation();
			}
			answer++;
		}

		System.out.println(answer);
	}

	static void rowOperation() {
		int[][] temp = new int[101][101];
		int MAX = Integer.MIN_VALUE;

		for (int i = 0; i < map.length; i++) {
			int[] count = new int[101];
			list = new ArrayList<>();
			for (int j = 0; j < map[0].length; j++) { //현재있는 숫자들의 갯수를 계산
				if (map[i][j] != 0) {
					count[map[i][j]]++;
				}
			}
			for (int j = 1; j < count.length; j++) { // 숫자들의 갯수를 넣어 줌.
				if (count[j] != 0) {
					list.add(new Number(j, count[j]));
				}
			}
			Collections.sort(list); // Number 객체 정렬
			int z = 0;
			for (int j = 0; j < list.size(); j++) { // 사이즈만큼 반복한다.
				temp[i][z] = list.get(j).num;// list에 있는 하나씩 temp에 꺼낸다.
				temp[i][z + 1] = list.get(j).count; // 갯수도 temp에다가 넣어준다.
				z += 2;// 숫자와 갯수가 들어가기 때문에 z인덱스는 2씩 늘린다.
				MAX = Math.max(z, MAX);//사이즈의 최대갯수를 고려하자.
			}
		}
		// 행이나 열이 100이 넘는 경우
		if (MAX > 100) {
			MAX = 100;
		}
		map = new int[map.length][MAX];
		for (int i = 0; i < map.length; i++) {//값들을 하나씩 옮겨주자.
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = temp[i][j];
			}
		}
	}

	static void columnOperation() {
		int[][] temp = new int[101][101];
		int MAX = Integer.MIN_VALUE;

		for (int i = 0; i < map[0].length; i++) {
			int[] count = new int[101];
			list = new ArrayList<>();
			for (int j = 0; j < map.length; j++) {//현재있는 숫자들의 갯수를 계산
				if (map[j][i] != 0) {
					count[map[j][i]]++;
				}
			}
			for (int j = 1; j < count.length; j++) {// 숫자들의 갯수를 넣어 줌.
				if (count[j] != 0) {
					list.add(new Number(j, count[j]));
				}
			}
			Collections.sort(list); // Number 객체 정렬
			int z = 0;
			for (int j = 0; j < list.size(); j++) {//전체적인 틀은 rowOperation과 동일하나 x와 y쪽의 바뀜을 고려.
				temp[z][i] = list.get(j).num;
				temp[z + 1][i] = list.get(j).count;
				z += 2;
				MAX = Math.max(z, MAX);
			}
		}
		// 행이나 열이 100이 넘는 경우
		if (MAX > 100) {
			MAX = 100;
		}
		map = new int[MAX][map[0].length];
		for (int i = 0; i < map.length; i++) {//맵옮기기
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = temp[i][j];
			}
		}
	}
	
	static class Number implements Comparable<Number> {
		int num;
		int count;
		public Number(int num, int count) {
			this.num = num;
			this.count = count;
		}

		@Override
		public int compareTo(Number o) { // 정렬 조건
			if (this.count > o.count) { // 갯수가 더 많은 경우 오름차순을 한다.
				return 1;
			} else if (this.count == o.count) { // 만약 갯수가 같다면?
				if (this.num > o.num) { // 같으면서 수가 큰경우 오름차순.
					return 1;
				} else {
					return -1;// 같으면서 수 작다면 내림차순.
				}
			} else {//갯수가 적다면 내림차순
				return -1;
			}
		}
	}

}