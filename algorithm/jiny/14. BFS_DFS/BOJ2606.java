package day1221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 바이러스
public class BOJ2606 {
    static StringTokenizer st;
    static boolean [][] virus;
    static boolean [] visit;
    static int start;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());//정점 수 1부터 N까지
        int K = Integer.parseInt(br.readLine());//간선 수

        virus = new boolean[N+1][N+1];//연결여부

        for(int n=1; n<K+1; n++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            virus[from][to]=virus[to][from] = true ;
        }
        start=1;

        Queue<Integer> qu = new LinkedList<Integer>();
        visit = new boolean[N+1];
        qu.add(start);
        visit[start] = true;
        int cnt =0;
        while(!qu.isEmpty()) {
            int size = qu.size();
            for(int s=0; s<size; s++) {
                int now = qu.poll();
                for(int i =0; i<N+1; i++) {
                    if(virus[now][i] && !visit[i]) {
                        qu.offer(i);
                        visit[i] = true;
                        cnt++;
                    }

                }

            }
        }//while
        System.out.println(cnt);
    }

}