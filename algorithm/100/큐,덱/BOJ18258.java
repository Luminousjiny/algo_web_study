package day1218;
import java.io.*;
import java.util.*;

public class BOJ18258 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int pushValue = 0;
		
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			String command = br.readLine();
			int result = 0;

			if (command.contains("push")) {
				String[] commandPush = command.split(" ");
				pushValue = Integer.parseInt(commandPush[1]);
				queue.add(pushValue);
			} else {
				switch (command) {
				case "pop":
					if (queue.isEmpty()) {
						result = -1;
					} else {
						result = queue.poll();
					}
                    bw.write(result + "\n");
					break;
				case "size":
					bw.write(queue.size() + "\n");
					break;
				case "empty":
					if (queue.isEmpty()) {
						result = 1;
					} else {
						result = 0;
					}
                    bw.write(result + "\n");
					break;
				case "front":
					if (!queue.isEmpty()) {
						result = queue.peek();
					} else {
						result = -1;
					}
                    bw.write(result + "\n");
					break;
				case "back":
					if (!queue.isEmpty()) {
						result = pushValue;
					} else {
						result = -1;
					}
                    bw.write(result + "\n");
					break;
				}
			}
		}
        bw.flush();
        br.close();
        bw.close();
	}
}