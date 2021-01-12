package DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12865 {
	public static void main(String args[]) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] w, v;
		int[][] d;		
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		w=new int[n+1];
		v=new int[n+1];
		d=new int[n+1][k+1];
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine());
			w[i]=Integer.parseInt(st.nextToken());
			v[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=0;j<=k;j++) {
				d[i][j]=d[i-1][j];
				if(j>=w[i]) {
					d[i][j]=Math.max(d[i][j], d[i-1][j-w[i]]+v[i]);
				}
			}
		}
		System.out.println(d[n][k]);
	}
}