package day1228;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1697{
	static int N, K;
	static int visited[] = new int[100001];
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		N = scanner.nextInt();//수빈이의 위치
		K = scanner.nextInt();//동생의 위치
		bfs();
	}
	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(N);// 수빈이가 있는 위치의 숫자를 큐에 넣어버립니다.
		visited[N]=0;
		while(!queue.isEmpty()) {//큐가 비어있는게 아니라면
			N = queue.poll();// (수빈이의 위치값을) 하나 꺼내서 
			if(N == K) // 수빈이와 동생이 만났는지를 확인하고,
				break;
			if(N+1 <= 100000 && visited[N+1]==0) // 만나지 못했다면 아래의 조건식들을 확인합시다.
			{
				queue.add(N+1); // X+1로 이동했다면? 그 값을 넣어줍니다.
				visited[N+1]= visited[N]+1; //그리고 해당 위치에 대한 visit 값을 현재값보다 1 더해줍시다.
			}
			if(N-1 >= 0 && visited[N-1]==0) // X-1로 이동했다면
			{
				queue.add(N-1);// 값을 넣어주고,
				visited[N-1]= visited[N]+1; // visit에도 역시 현재값보다 1 더해줍시다.
			}
			if(N*2 <= 100000 && visited[N*2]==0)// 순간이동을 한 경우입니다.
			{
				queue.add(N*2); // X * 2로  이동한 상황이기에 넣어주고,
				visited[N*2]= visited[N]+1;//해당위치에 대한 visit 값을 현재값보다 1 더해줍니다. 
			}
		}
		System.out.println(visited[K]);//그럼 종료하고 나온 K번째에는 몇번만에 나왔는지가 보이게 됩니다. 
	}
}