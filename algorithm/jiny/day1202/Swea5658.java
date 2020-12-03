package day1202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

// 보물상자 비밀번호
// TreeSet + 시계방향(오른쪽) 으로 밀기 방법이용
public class Swea5658 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int TC = 1; TC <= T; TC++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 들어오는 숫자 개수 N : 8-28
            int C = N/4; // 한변의 길이 : 2-7 -> 회전회수 결정
            int K = Integer.parseInt(st.nextToken()); // 내림차순 정렬 후 뽑을 자리 수
            char[] nums = br.readLine().toCharArray(); // 읽어서 배열에 하나씩 넣기

            // 1. 내림차순정렬 + 중복혀용 안함 -> TreeSet이용하여 구현
            TreeSet<String> set = new TreeSet<String>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o2.compareTo(o1); // 내림차순 -> 정수이면 o2- o1
                } // 16진수에서 알파벳이 앞에 있으면 숫자도 크므로 그 성질을 이용하여 정렬
            });

            //2. 다시 원상태가 되기 전까지 회전하기
            int c = 0;
            while (c++ < C){ // 회전은 C번
                //3. 현 상태에서 각 변의 길이만큼의 문자열 비밀번호 추출하여 set에 넣기
                for (int i = 0; i < N; i+=C) {
                    String s = "";
                    for (int j = 0; j < C; j++) {
                        s += nums[i+j];
                    }
                    set.add(s);
                }

                //4. 시계방향(일차원배열에서 오른쪽)으로 이동
                char temp = nums[N-1];
                for (int i = N-1; i > 0; i--) {
                    nums[i] = nums[i-1];
                }
                nums[0] = temp;
            } // while 끝


            int k = 0, ans = 0;
            for (String s : set) {
                if(++k == K){
                    ans  = Integer.parseInt(s, 16); // 5. s 문자를 16진수로 바꿔주자
                    break;
                }
            }
            System.out.println("#"+TC+ " " + ans);
        }

    }
}
