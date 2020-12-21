import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int tc=0; tc<T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); //문서 개수
            int M = Integer.parseInt(st.nextToken()); //궁금한 문서idx

            List<Doc> docs = new ArrayList<Doc>(); //문서 리스트

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) docs.add(new Doc(i, Integer.parseInt(st.nextToken())));

            int cnt=0;//M까지 오는데 인쇄한 횟수
            while(true){
                boolean isFind = false;

                for(int i=1; i<docs.size(); i++){ //더 큰 우선순위 있는지 찾기
                    if(docs.get(0).priority < docs.get(i).priority){
                        isFind = true;
                        break;
                    }
                }

                if(!isFind){ //더 큰게 없다면 ex) 1 1 1 1 1
                    cnt++; //무조건 인쇄
                    if(docs.get(0).idx == M){ //M이 인쇄될 차례이면
                        sb.append(cnt+"\n");
                        break;
                    }else docs.remove(0);
                }else{ //더 큰게 있다면 뒤로 보내주기
                    docs.add(docs.remove(0));
                }
            }//End 인쇄
        }//End tc
        System.out.println(sb+"");


    }
    static class Doc{
        int idx;
        int priority;

        public Doc(int idx, int priority){
            this.idx = idx;
            this.priority = priority;
        }
    }
}