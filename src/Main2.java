import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        int n = Integer.parseInt(br.readLine());

        while(n > 0) {
            n--;
            int x = Integer.parseInt(br.readLine());

            if(x > 0) {
                priorityQueue.add(x);
            } else {
                if(priorityQueue.size() == 0) {
                    sb.append(0 + "\n");
                } else {
                    sb.append(priorityQueue.remove() + "\n");
                }
            }

        }

        System.out.println(sb.substring(0, sb.length() - 1));

    }
}
