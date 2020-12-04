package day1204;

import java.util.ArrayList;
import java.util.Scanner;
//그룹 단어 체커
public class BOJ_1316 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String S = sc.next();
            ArrayList<Character> arr = new ArrayList<>();
            int idx = 0;
            boolean ck = true;
            arr.add(S.charAt(0));
            char ch = arr.get(idx);
            for (int j = 1; j < S.length(); j++) {
                if(S.charAt(j) == ch) continue;
                for (int k = 0; k < arr.size(); k++) {
                    if(arr.get(k) == S.charAt(j)){ // 전에 같은 알파벳이 있었음
                        ck = false;
                        break;
                    }
                }
                if(!ck)break;
                arr.add(S.charAt(j));
                ch = S.charAt(j);
            }
            if(ck) cnt++;
        }
        System.out.println(cnt);
    }
}
