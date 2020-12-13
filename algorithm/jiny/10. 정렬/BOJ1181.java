package day1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Word> word = new ArrayList<>();
        String start = br.readLine();
        word.add(new Word(start, start.length()));
        for (int i = 1; i < N; i++) {
            String S = br.readLine();
            boolean ck = true;
            for (int j = 0; j < word.size(); j++) {
                if(word.get(j).w.equals(S)) {
                    ck = false;
                    break;
                }
            }
            if(ck) word.add(new Word(S, S.length())); // 단어랑 길이랑
        }

        Collections.sort(word);
        for (int i = 0; i < word.size(); i++) {
            System.out.println(word.get(i).w);
        }
    }
    static class Word implements Comparable<Word>{
        String w;
        int len;
        Word(String w, int len){
            this.w = w;
            this.len = len;
        }

        @Override
        public int compareTo(Word o) {
            if(this.len == o.len) return this.w.compareTo(o.w); // 사전 순 정렬은 compareTo 사용
            else return Integer.compare(this.len, o.len); // 오름차순
        }
    }
}
