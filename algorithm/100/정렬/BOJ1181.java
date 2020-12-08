import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<String> hash = new HashSet<String>();
		int N = Integer.parseInt(br.readLine());
		for(int i =0 ; i < N; i++) {
			hash.add(br.readLine());
		}
		ArrayList<String> arraylist = new ArrayList<String>(hash);
		Collections.sort(arraylist, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length()>o2.length()) {
					return 1;
				}
				else if(o1.length() < o2.length())
					return -1;
				else
					return o1.compareTo(o2);
			}
		});
		for(String str : arraylist)
			System.out.println(str);
		
	}
}