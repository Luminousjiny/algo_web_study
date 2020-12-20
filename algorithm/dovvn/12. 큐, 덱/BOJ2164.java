import java.io.*;
import java.util.LinkedList;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<Integer> queue = new LinkedList<>();
        N = Integer.parseInt(br.readLine());
        for(int i=1; i<=N; i++) queue.add(i);

        if(N==1) bw.write(1+"\n");
        else if(N==2) bw.write(2+"\n");
        else while(true){
            queue.poll();
            int num = queue.poll();
            if(queue.size()==1){
                bw.write(num+"");
                break;
            }
            queue.add(num);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}