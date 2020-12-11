import java.io.*;
import java.util.*;

//나이순 정렬
public class Main{

    static class Person{
        int age;
        String name;

        public Person(int age, String name){
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Person[] arr = new Person[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Person(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        Arrays.sort(arr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.age, o2.age);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            sb.append(arr[i].age+" "+arr[i].name).append('\n');
        }
        bw.write(sb+"");
        bw.flush();
        bw.close();
        br.close();
    }
}