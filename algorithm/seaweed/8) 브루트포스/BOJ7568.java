package day1202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ7568 {
    /**
     * 덩치 등수를 출력하시오
     * 덩치 : 키도 크고 몸무게도 커야함
     */
    static int N; // 사람 수
    static int[][] people; // 사람들 키, 몸무게
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        people = new int[N][2]; // [[몸무게, 키], [몸무게, 키], ... ]

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            people[i][0] = Integer.parseInt(st.nextToken());
            people[i][1] = Integer.parseInt(st.nextToken());
        } // 입력 끝

        for(int i = 0; i < N; i++){
            int cnt = 1; // 덩치 큰 사람 아무도 없으면 1
            for(int j = 0; j < N; j++){
                if(i == j) continue; // 자기 자신이랑 비교하는 경우는 무시
                if(people[i][0] < people[j][0] && people[i][1] < people[j][1])
                    cnt++;
            }
            sb.append(cnt).append(" ");
        }
        System.out.println(sb.toString());
    }
}
