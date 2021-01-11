package day0111;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int cnt = 0;
        Queue<Integer> qu = new LinkedList<>();
        qu.add(N); //시작 숫자를 넣음
        loop:
        while (!qu.isEmpty()){
            int size = qu.size();
            for (int s = 0; s < size; s++) {
                int now = qu.poll();
                if(now == 1) break loop;
                if(now%3 == 0){
                    qu.add(now/3);
                }
                if(now%2 ==0){
                    qu.add(now/2);
                }
                qu.add(now-1);
            }//size
            cnt++; //연산횟수
        }
        System.out.println(cnt);

    }
}
