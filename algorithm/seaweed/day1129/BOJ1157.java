package day1129;

import java.util.Scanner;

public class BOJ1157 {
    static String word;
    static int[] count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        word = sc.next().toUpperCase();

        count = new int[26];
        int size = word.length();
        for(int i = 0; i < size; i++){
            count[word.charAt(i) - 65]++;
        }
        // 사용횟수 최대값 찾기
        int maxCnt = 0;
        for(int i = 0; i < 26; i++){
            maxCnt = Math.max(maxCnt, count[i]);
        }
        // 가장 많이 사용된 알파벳 무엇인지 찾기
        boolean hasMany = false; // 사용 횟수 최대값인 알파벳이 여러개인지 확인
        int idx = -1;
        for(int i = 0; i < 26; i++){
            if(count[i] == maxCnt) {
                if(idx != -1){ // 중복된 경우
                    hasMany = true;
                    break;
                } else {
                    idx = i;
                }
            }
        }
        System.out.println((hasMany) ? '?' : (char)(idx + 65));
    }
}
