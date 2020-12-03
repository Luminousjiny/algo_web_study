package day1129;

import java.util.Scanner;

public class BOJ5622 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.next();
        int time = 0;

        // 정규표현식 이용해 변환 후 계산
        word = word.replaceAll("[ABC]", "2");
        word = word.replaceAll("[DEF]", "3");
        word = word.replaceAll("[GHI]", "4");
        word = word.replaceAll("[JKL]", "5");
        word = word.replaceAll("[MNO]", "6");
        word = word.replaceAll("[PQRS]", "7");
        word = word.replaceAll("[TUV]", "8");
        word = word.replaceAll("[WXYZ]", "9");

        for(int i = 0; i < word.length(); i++){
            time += (word.charAt(i) - '0' + 1);
        }
        System.out.println(time);
        // switch 문 사용한 경우
//
//        int size = word.length();
//        for(int i = 0; i < size; i++){
//            char ch = word.charAt(i);
//
//            switch (ch){
//                case 'A':
//                case 'B':
//                case 'C':
//                    time += 3;
//                    break;
//                case 'D':
//                case 'E':
//                case 'F':
//                    time += 4;
//                    break;
//                case 'G':
//                case 'H':
//                case 'I':
//                    time += 5;
//                    break;
//                case 'J':
//                case 'K':
//                case 'L':
//                    time += 6;
//                    break;
//                case 'M':
//                case 'N':
//                case 'O':
//                    time += 7;
//                    break;
//                case 'P':
//                case 'Q':
//                case 'R':
//                case 'S':
//                    time += 8;
//                    break;
//                case 'T':
//                case 'U':
//                case 'V':
//                    time += 9;
//                    break;
//                case 'W':
//                case 'X':
//                case 'Y':
//                case 'Z':
//                    time += 10;
//                    break;
//            }
//        }
//        System.out.println(time);
    }
}
