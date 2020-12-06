package day1206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 잃어버린 괄호
public class BOJ1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine(); //S의 최대길이는 50
        String[] str = S.split("-"); // -를 구분자로 나눠주기
        int sum = 0;
        for (int i = 0; i < str.length; i++) {
            int num = 0;
            if(str[i].contains("+")){
                String[] plus = str[i].split("\\+"); // +는 특수문자이므로 \\붙이기
                for (int j = 0; j < plus.length; j++) {
                    num += Integer.parseInt(plus[j]);
                }
                if(i==0) sum = num;
                else sum -= num;

            }else{
                if(i==0) sum= Integer.parseInt(str[i]);
                else sum -= Integer.parseInt(str[i]);

            }
        }

        System.out.println(sum);

    }
}
