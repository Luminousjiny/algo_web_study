package day1208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11650 {
    static int N;
    static Point[] points;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        points = new Point[N];
        for(int i = 0; i < N; ++i){
            st = new StringTokenizer(br.readLine(), " ");
            points[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(points);

        for(Point point : points){
            sb.append(point.x).append(" ").append(point.y).append("\n");
        }
        System.out.println(sb.toString());
    }

    static class Point implements Comparable<Point>{
        int x, y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if(this.x == o.x){
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }
}
