import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//회의실배정
public class Main {

	static class Meeting implements Comparable<Meeting> {
		int start;
		int end;

		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			return Integer.compare(this.end, o.end);
		}
	}

	static class MeetingComperator implements Comparator<Meeting> { // 시작시간 정렬
		@Override
		public int compare(Meeting o1, Meeting o2) {
			return o1.start - o2.start;
		}
	}

	static int N; // 회의개수
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		Meeting[] meetings = new Meeting[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			meetings[i] = new Meeting(start, end);
		}

		//시작시간 오름차순 하고 나서
		Arrays.sort(meetings, new MeetingComperator());
		//끝나는 시점이 빠른 것부터 정렬
		Arrays.sort(meetings);

		int Ans = 1; // 최대 회의 개수
		int idx = 1; // 다음 미팅 인덱스
		Meeting now = meetings[0]; // 종료시간이 가장 짧은 회의
		while (idx < N) {
			// 현재 미팅 종료시간보다 다음 미팅 시작시간이 같거나 크다면
			if (now.end <= meetings[idx].start) {
				// 다음 미팅을 현재 미팅으로 바꿔주고
				now = meetings[idx];
				Ans++;
			}
			idx++;
		}
		System.out.println(Ans);
	}
}