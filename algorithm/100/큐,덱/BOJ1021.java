package day1218;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1021 {
	public static void main(String[] args)throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> deque = new ArrayList<>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int count = 0;
		for (int i = 1; i <= N; i++) deque.add(i);
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			while(true) {
				if(num == deque.get(0)) {//첫원소 뽑기
					deque.remove(0);
					break;
				}else if((deque.size()/2) >= deque.indexOf(num)) {
					deque.add(deque.size()-1, deque.remove(0));//끝에다가 첫번째꺼 옮기기(왼)
					count++;	
				}else {
					deque.add(0, deque.remove(deque.size()-1));//첫번째에 끝에꺼 옮기기(오)
					count++;
				}
			}
		}
		System.out.println(count);
		br.close();
	}

}