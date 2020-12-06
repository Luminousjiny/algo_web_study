package day1206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
// 회의실 배정
public class BOJ1931 {
    static StringTokenizer st;
    static int[][] meeting;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        meeting = new int[N][2]; //시작점, 끝점
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meeting[i][0] = start;
            meeting[i][1] = end;
        }
        // 시작점으로 정렬 -> 끝나는 시간이 같은 경우에는 시작점이 작은 순으로 해야하므로 먼저해주기
        // 시작점으로 정렬된 상태에서 끝점으로 정렬
        Arrays.sort(meeting, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])
                    return o1[0] - o2[0]; //끝나는 시간이 같으면 시작점 기준으로 정렬
                else
                    return o1[1] - o2[1]; //아니면 끝나는 시간으로 정렬
            }
        });

        count = 1;
        int time = meeting[0][1];
        for (int i = 1; i < N; i++) {
            if(time > meeting[i][0]) continue;
            count++;
            time = meeting[i][1];
        }
        System.out.println(count);

    }
}
