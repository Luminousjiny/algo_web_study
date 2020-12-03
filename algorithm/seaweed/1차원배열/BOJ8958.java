package day1128;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ8958 {

    static int TC, totalScore, curScore;
    static char[] quizResult;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= TC; tc++){
            quizResult = br.readLine().toCharArray();
            totalScore = 0;
            curScore = 0;

            for(char ch : quizResult){
                if(ch == 'O'){
                    curScore++;
                    totalScore += curScore;
                } else {
                    curScore = 0;
                }
            }

            System.out.println(totalScore);
        }
    }
}
