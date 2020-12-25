import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    static int N;
    static int x;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) { //절대값이 가장 작은값 출력
                if((Math.abs(o1) == Math.abs(o2) && o1>o2) || Math.abs(o1) > Math.abs(o2)) return 1;
                else return -1;
            }
        });

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            x = Integer.parseInt(br.readLine());
            if(x==0){ //우선순위 가장 큰 값 출력
                if(queue.isEmpty()) sb.append(0+"\n");
                else sb.append(queue.poll()+"\n");
                continue;
            }
            queue.add(x);
        }

        System.out.println(sb+"");
    }
}