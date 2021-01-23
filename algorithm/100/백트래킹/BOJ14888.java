package 백트래킹;

import java.util.Scanner;

public class BOJ14888 {
	static int N;
	static int[] number;
	static int[] operator = new int[4];
	static int MIN = Integer.MAX_VALUE;
	static int MAX = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		N = scanner.nextInt();
		number = new int[N+1];
		for(int i = 0 ; i < N ; i++) {
			number[i] = scanner.nextInt();
		}
		for(int i = 0 ; i < 4; i++) {
			operator[i] = scanner.nextInt();
		}
		dfs(0,number[0],0);
		System.out.println(MAX);
		System.out.println(MIN);
	}
	public static void dfs(int num, int result, int index) {
		if(num == N-1) {
			MAX = (MAX > result) ? MAX : result;
			MIN = (MIN < result) ? MIN : result;
		}
		
		for(int i=0;i<4;i++){
            if(operator[i]>0){
                if(i==0){
                    operator[i]--;
                    dfs(num+1,result + number[index+1],index+1);
                    operator[i]++;
                }
                else if(i==1){
                    operator[i]--;
                    dfs(num+1,result - number[index+1],index+1);
                    operator[i]++;
                }
                else if(i==2){
                    operator[i]--;
                    dfs(num+1,result * number[index+1],index+1);
                    operator[i]++;
                }
                else if(i==3){
                    operator[i]--;
                    dfs(num+1,result / number[index+1],index+1);
                    operator[i]++;
                }
            }
		}
	}
}
