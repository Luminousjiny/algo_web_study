import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//숫자 카드2
public class Main {

    static int N, M;
    static HashMap<Integer, Integer> counts; //나온 횟수 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        counts = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(counts.containsKey(num)) counts.put(num, counts.get(num)+1);
            else counts.put(num, 1);
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int target = Integer.parseInt(st.nextToken());
            if(counts.containsKey(target)) sb.append(counts.get(target)+" ");
            else sb.append(0+" ");
        }
        System.out.println(sb);
    }
}