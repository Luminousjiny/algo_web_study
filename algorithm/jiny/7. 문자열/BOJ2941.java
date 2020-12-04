package day1204;

import java.util.Scanner;
// 크로아티아 알파벳
public class BOJ2941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();

        int cnt = 0;
        for (int i = S.length()-1; i >= 0; i--) {
            if(i>=1 && S.charAt(i) == 'j' && (S.charAt(i-1) == 'l' || S.charAt(i-1) == 'n')){
                i--;
            }else if(S.charAt(i) == '='){
                if(S.charAt(i-1) == 'z' && i>=2 && S.charAt(i-2) == 'd'){
                    i-=2;
                }else if(S.charAt(i-1) == 'z' ){
                    i--;
                }else if(S.charAt(i-1) == 'c' || S.charAt(i-1) == 's'){
                    i--;
                }
            }else if(S.charAt(i) == '-' && (S.charAt(i-1) == 'c' || S.charAt(i-1) == 'd')){
                i--;
            }
            cnt++;
        }
        System.out.println(cnt);

    }
}
