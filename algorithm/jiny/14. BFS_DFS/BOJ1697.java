package day1221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
// 숨바꼭질
public class BOJ1697 {
    static StringTokenizer st;
    static int N, K, sec;
    static int[] go;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 수빈지점
        K = Integer.parseInt(st.nextToken()); // 동생지점
        int ans = route(N);
        System.out.println(ans);
    }

    public static int route(int cnt) {
        Queue<Integer> qu = new LinkedList<Integer>();
        go = new int[3];
        visit = new boolean[100001];
        qu.add(cnt);
        sec = 0;
        if(cnt==K) return 0; // 같을 때
        else {
            while (!qu.isEmpty()) {
                if(visit[K]) break;
                int size = qu.size();
                for (int s = 0; s < size; s++) {
                    int now = qu.poll();
                    if (now == K)
                        break;
                    for (int i = 0; i < 3; i++) {
                        go[0] = now - 1;
                        go[1] = now + 1;
                        go[2] = now * 2;
                        int point = go[i];
                        if (point >= 0 && point <= 100000) {// 범위내에서
                            if (!visit[point]) {
                                qu.add(point);
                                visit[point] = true;
                            }
                        }
                    }
                } // size
                sec++;
            }
            return sec;
        }
    }
}
