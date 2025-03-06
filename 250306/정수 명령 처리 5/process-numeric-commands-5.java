import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken(); // 명령어 가져오기
            
            if (command.equals("push_back")) {
                list.add(Integer.parseInt(st.nextToken())); // 숫자 추가
            } else if (command.equals("pop_back")) {

     if (!list.isEmpty()) { // 리스트가 비어있지 않을 때만 삭제
                    list.remove(list.size() - 1);
                }
                
            } else if (command.equals("size")) {
                sb.append(list.size()).append('\n');
            } else if (command.equals("get")) {


                    sb.append(list.get(Integer.parseInt(st.nextToken())-1)).append('\n');
                
            }
        }

        System.out.print(sb.toString());
    }
}
