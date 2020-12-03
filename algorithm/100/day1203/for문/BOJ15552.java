import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t=Integer.parseInt(br.readLine());

		for(int i=0;i<t;i++)
		{
            String [] word = br.readLine().split(" ");
            bw.write((Integer.parseInt(word[0])+Integer.parseInt(word[1])) + "\n");	
		}
		bw.flush();
		br.close();
		bw.close();
	}
}

