package day1203;

import java.util.Scanner;

public class BOJ1152 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        int cnt = 0;
        if(S.length() == 0 || (S.length()==1 && S.charAt(0) == ' ') ){
            System.out.println(cnt);
        }else {
            for (int i = 0; i < S.length(); i++) {
                if(S.charAt(i) != ' '){
                    for (int j = i; j < S.length()-1; j++) {
                        if(S.charAt(j) == ' ' && S.charAt(j+1)!=' '){
                            cnt++;
                        }
                    }
                    break;
                }
            }
            System.out.println(cnt+1);
        }

    }
}
