package day1217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> qu = new LinkedList<>();
        int last = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if(s.contains("push")){ //push X: 정수 X를 큐에 넣는 연산이다.
                String[] w = s.split(" ");
                qu.add(Integer.parseInt(w[1]));
                last = Integer.parseInt(w[1]);
            }else if(s.equals("pop")){ //pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                if(qu.isEmpty()) sb.append(-1).append("\n");
                else sb.append(qu.poll()).append("\n");
            }else if(s.equals("size")){ //size: 큐에 들어있는 정수의 개수를 출력한다.
                sb.append(qu.size()).append("\n");
            }else if(s.equals("empty")){ //empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
                if(qu.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }else if(s.equals("front")){ //front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                if(qu.isEmpty()) sb.append(-1).append("\n");
                else sb.append(qu.peek()).append("\n");
            }else if(s.equals("back")){ //back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                if(qu.isEmpty()) sb.append(-1).append("\n");
                else sb.append(last).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
