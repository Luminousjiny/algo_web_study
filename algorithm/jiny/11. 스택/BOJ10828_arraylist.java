package day1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
// ArrayList 사용
public class BOJ10828_arraylist {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String S = br.readLine();
            if(S.contains("push")){ //push X: 정수 X를 스택에 넣는 연산이다.
                String[] push = S.split(" ");
                arr.add(Integer.parseInt(push[1]));
            }else if(S.equals("pop")){ //pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                    if(arr.size() == 0){
                        System.out.println(-1);
                    }else{
                        System.out.println(arr.get(arr.size()-1));
                        arr.remove(arr.size()-1); // 지우고
                    }
            }else if(S.equals("size")){ //size: 스택에 들어있는 정수의 개수를 출력한다.
                    System.out.println(arr.size());
            }else if(S.equals("empty")){ //empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
                    if(arr.size() == 0){
                        System.out.println(1);
                    }else{
                        System.out.println(0);
                    }
            }else if(S.equals("top")){ //top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                    if(arr.size() == 0){
                        System.out.println(-1);
                    }else{
                        System.out.println(arr.get(arr.size()-1));
                    }
            }
        }
        
    }
}
