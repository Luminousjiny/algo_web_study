package day1218;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class BOJ10866 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        Deque<Integer> deque = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i < N; i++) {
            String str = br.readLine();
            if(str.contains("push_back")) {
            	String[] array = str.split(" ");
                deque.addLast(Integer.parseInt(array[1]));
            }else if(str.contains("push_front")) {
            	String[] array = str.split(" ");
                deque.addFirst(Integer.parseInt(array[1]));
            }else if(str.equals("pop_front")) {
                System.out.println(deque.isEmpty()? -1 : deque.pollFirst());
            }else if(str.equals("pop_back")) {
                System.out.println(deque.isEmpty()?-1:deque.pollLast());
            }else if(str.equals("size")) {
                System.out.println(deque.size());
            }else if(str.equals("empty")) {
                System.out.println(deque.isEmpty()?1:0);
            }else if(str.equals("front")) {
                System.out.println(deque.isEmpty()?-1:deque.peekFirst());
            }else if(str.equals("back")) {
                System.out.println(deque.isEmpty()?-1:deque.peekLast());
            }
        }
    }
}
