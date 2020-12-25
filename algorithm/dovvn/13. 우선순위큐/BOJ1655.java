import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

//최소힙, 최대힙 개념 이해가 필요한 문제
public class Main {

    static int N;
    static int x;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        //가운데를 기준으로 내림차순(최대힙), 오름차순(최소힙)으로 나눠주기
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> min = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            x = Integer.parseInt(br.readLine());
            //max에 먼저 넣어주고, 번걸아가면서 넣어주기
            if(max.size() == min.size()) max.add(x);
            else min.add(x);

            //가운데값 구하기
            if(!max.isEmpty() && !min.isEmpty()){
                if(max.peek() > min.peek()){ //max값이 min값보다 크다면 바꿔줘야함
                    int tmp = min.poll();
                    min.add(max.poll());
                    max.add(tmp);
                }
            }
            sb.append(max.peek()+"\n");
        }

        System.out.println(sb+"");
    }
}