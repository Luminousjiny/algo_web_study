package day1202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

// 보물상자 비밀번호
// 밀지 않는 방법 -> 인덱스의 이동 이용
public class Swea5658_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int TC = 1; TC <= T; TC++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 들어오는 숫자 개수 N : 8-28
            int C = N / 4; // 한변의 길이 : 2-7 -> 회전회수 결정
            int K = Integer.parseInt(st.nextToken()); // 내림차순 정렬 후 뽑을 자리 수

            String nums = br.readLine();
            nums = nums.concat(nums); // 1. 이동처리를 하지 않기위해 문자열 붙임

            // 1. 내림차순정렬 + 중복혀용 안함 -> TreeSet이용하여 구현
            TreeSet<String> set = new TreeSet<String>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o2.compareTo(o1); // 내림차순 -> 정수이면 o2- o1
                } // 16진수에서 알파벳이 앞에 있으면 숫자도 크므로 그 성질을 이용하여 정렬
            });

            //2. 다시 원상태가 되기 전까지 회전하기
            int c = 0, start = 0; // start : 시작점 이동
            while (c++ < C){ // 회전은 C번
                //3. 현 상태에서 각 변의 길이만큼의 문자열 비밀번호 추출하여 set에 넣기
                for (int i = start, j=0; j < 4; i+=C, ++j) { // i는 시작, j는 횟수
                    set.add(nums.substring(i, i+C));
                }
                ++start; //기준위치 말기
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
