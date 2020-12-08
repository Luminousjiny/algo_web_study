import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N];
		for(int i = 0 ; i < N; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(array);
		for(int i = 0 ; i < N; i++)
		{
			bw.append(array[i]+"\n");			
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
