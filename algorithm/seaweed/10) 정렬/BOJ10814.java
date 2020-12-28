package day1208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10814 {
    static int N;
    static  Member[] members;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        members = new Member[N];

        for(int i = 0; i < N; ++i){
            st = new StringTokenizer(br.readLine(), " ");
            members[i] = new Member(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        // Arrays.sort는 stable이 보장됨
        Arrays.sort(members, (m1, m2) -> m1.age - m2.age);

        for (Member member : members) {
            sb.append(member.age).append(" ").append(member.name).append("\n");
        }
        System.out.println(sb.toString());
    }

    static class Member{
        int age;
        String name;
        public Member(int age, String name){
            this.age = age;
            this.name = name;
        }
    }
}
