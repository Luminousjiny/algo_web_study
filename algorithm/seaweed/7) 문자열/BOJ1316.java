package day1129;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ1316 {
    static int groupCnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int TC = sc.nextInt();
        groupCnt = 0;
        for(int tc = 1; tc <= TC; tc++){
            String word = sc.next();
            int size = word.length();
            boolean isGroup = true;
            Set<Character> set = new HashSet<>(); // 중복 확인용 set

            char prev = word.charAt(0);
            set.add(prev);
            for(int i = 1; i < size; i++){
                char curr = word.charAt(i);

                if(prev != curr){
                    if(set.contains(curr)){
                        // 이미 체크했던 문자가 다시 들어옴 -> 그룹문자 아님
                        isGroup = false;
                        break;
                    }
                    set.add(curr); // 새 단어 set에 넣음
                    prev = curr;
                }
            }
            if(isGroup)
                groupCnt++;
        }
        System.out.println(groupCnt);
    }
}
