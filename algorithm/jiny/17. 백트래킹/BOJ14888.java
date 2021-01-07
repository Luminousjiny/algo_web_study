package day0106;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
// 연산자 끼워넣기
public class BOJ14888 {
    static StringTokenizer st;
    static int N, max, min;
    static int[] number, cal, per;
    static boolean[] select;
    static HashSet<String> perCal;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        number = new int[N]; // N개의 숫자
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }// 숫자배열 채우기
        st = new StringTokenizer(br.readLine());
        cal = new int[N-1]; // + : 0, - : 1, * : 2, / : 3
        int idx = 0;
        for (int i = 0; i < 4; i++) {
            int c = Integer.parseInt(st.nextToken());
            for (int j = 0; j < c; j++) {
                cal[idx] = i;
                idx++;
            }
        }// 연산자배열 채우기
        // 중복된 데이터가 있으니 순열을 만들고 set 에 저장하여 중복된 결과는 제거해주기
        perCal = new HashSet<>(); // 순열을 만들고 저장할 set
        per = new int[N-1]; // 순열을 만들 배열
        select = new boolean[N-1];
        // number 과 perCal 에서 하나 뺀 것 저장한 배열 번갈아 가면서 연산 수행
        perm(0);
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        for (String arr: perCal) {
            int calId = 0, ans = number[0]; // 부호 String index, 계산 결과
            for (int j = 1; j < number.length; j++) {
                char n = arr.charAt(calId);
                if(n=='0'){ // +
                    ans += number[j];
                }else if(n=='1'){ // -
                    ans -= number[j];
                }else if(n=='2'){ // *
                    ans *= number[j];
                }else if(n=='3'){ // /
                    if(ans < 0){  // 연산 전 ans 가 음수면, 양수로 바꾸고 계산 후 음수 부호 붙임
                        ans *= -1;
                        ans /= number[j];
                        ans *= -1;
                    }else {
                        ans /= number[j];
                    }
                }
                calId++;
            }
            max = Math.max(max, ans);
            min = Math.min(min, ans);
        }
        System.out.println(max);
        System.out.println(min);
    }

    static void perm(int cnt){ // 부호 순열 구하기
        if(cnt == N-1){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N-1; i++) {
                sb.append(per[i]);
            }
            perCal.add(sb.toString());
            return;
        }
        for (int i = 0; i < N-1; i++) {
            if(select[i]) continue;
            per[cnt] = cal[i];
            select[i] = true;
            perm(cnt+1);
            select[i] = false;
        }
    }
}
