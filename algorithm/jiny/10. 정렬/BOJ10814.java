package day1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10814 {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        User[] user = new User[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            user[i] = new User(Integer.parseInt(st.nextToken()), st.nextToken());
        }
        Arrays.sort(user);
        for (int i = 0; i < N; i++) {
            System.out.println(user[i].age + " " + user[i].name);
        }
    }
    static class User implements Comparable<User>{
        int age;
        String name;
        User(int age, String name){
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(User o) {
            return Integer.compare(this.age, o.age);
        }
    }
}
