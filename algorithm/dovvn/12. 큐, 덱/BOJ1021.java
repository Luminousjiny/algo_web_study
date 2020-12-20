import java.io.*;
import java.util.*;

public class Main {

    static int N, M, Ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        for(int i=1; i<=N; i++) list.add(i);
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<M; i++){
            int num = Integer.parseInt(st.nextToken()); //뽑을 숫자
            while(true){
                if(list.get(0) == num){
                    list.remove(0);
                    break;
                }
                else{
                    if(list.indexOf(num) <= list.size()/2) list.add(list.size()-1, list.remove(0)); //오른쪽으로
                    else list.add(0, list.remove(list.size()-1)); //왼쪽으로
                    Ans++;
                }
            }//뽑기 End
        }



        System.out.println(Ans);
    }
}