package DP;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ11053 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int length = scanner.nextInt();
		int A[] = new int[length];
		int dp[] = new int[length];
		for(int i = 0 ; i < length; i++)
			A[i] = scanner.nextInt();

		for(int i = 0 ; i < length; i++)
		{
			dp[i]=1;
			for(int j = 0; j < i; j++)
			{
				if(A[j]<A[i]&&dp[i]<=dp[j])
					dp[i]= dp[j]+1;
			}
		}
		Arrays.sort(dp);
		System.out.println(dp[length-1]);
		scanner.close();
	}
}