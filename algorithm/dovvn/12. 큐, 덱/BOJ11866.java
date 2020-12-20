import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Integer> queue = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++) queue.add(i);

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while(!queue.isEmpty()){
            for(int i=1; i<K; i++){
                queue.add(queue.poll());
            }
            if(queue.size()==1) sb.append(queue.poll());
            else sb.append(queue.poll()+", ");
        }

        bw.write(sb+">");
        bw.flush();
        bw.close();
        br.close();
    }
}