package 분할정복;
import java.util.Scanner;

public class BOJ2630
{
	static int[][]map;
	static int color1 = 0;
	static int color2 = 0;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		map = new int[n][n];
		for(int i =0 ; i < n; i++)
		{
			for(int j = 0 ; j < n;j++)
			{
				map[i][j] = scanner.nextInt();
			}
		}
		
		divideColor(n,0,0);
		
		System.out.println(color1);
		System.out.println(color2);
		scanner.close();
	}
	private static void divideColor(int n, int front, int rear)
	{
		if(findSameColor(n,front,rear)) {
			if(map[front][rear]==0) color1++;
			else color2++;
			return;
		}
		divideColor(n/2, front, rear);
		divideColor(n/2, front+(n/2), rear);
		divideColor(n/2, front, rear+(n/2));
		divideColor(n/2, front+(n/2), rear+(n/2));
		
	}
	private static boolean findSameColor(int n, int front, int rear) {
		int temp = map[front][rear];
		for(int i = front; i< front + n; i++) {
			for(int j = rear; j < rear+n;j++)
			{
				if(temp ==map[i][j]) continue;
				else return false;
			}
		}
		return true;
	}
}