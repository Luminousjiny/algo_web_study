import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
 
public class Main {
	public static void main(String[] args)throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[][] arrary = new String[N][2];
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arrary[i][0] = st.nextToken();
			arrary[i][1] = st.nextToken();
		}
		Arrays.sort(arrary, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
//				return o1[0].compareTo(o2[0]);//compareTo 까서 확인해보기.
				return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
			}	
		});
		for(int i = 0; i < N; i++) {
			System.out.println(arrary[i][0] + " " + arrary[i][1]);
		}		
	}
 
}