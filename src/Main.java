import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        MaxHeap maxHeap = new MaxHeap();

        while(n > 0) {
            n--;
            int x = Integer.parseInt(br.readLine());

            if(x > 0) {
                maxHeap.insert(x);
            } else {
                if(maxHeap.getHeap().size() == 0) {
                    sb.append(0 +"\n");
                } else {
                    sb.append(maxHeap.delete() + "\n");
                }
            }
        }
        System.out.println(sb.substring(0,sb.length() - 1));
    }

    public static class MaxHeap {
        private ArrayList<Integer> heap;

        public MaxHeap() {
            heap = new ArrayList<>();
            heap.add(0);
        }

        public ArrayList<Integer> getHeap() {
            return heap;
        }

        public void insert(int val) {
            heap.add(val);
            int parent = heap.size() - 1;

            while(parent > 1 && heap.get(parent / 2) < heap.get(parent)) {
                int temp = heap.get(parent / 2);
                heap.set(parent / 2, heap.get(parent));
                heap.set(parent, temp);
            }
        }

        public int delete() {
            if(heap.size() - 1 < 1) {
                return 0;
            }

            int deleteItem = heap.get(1);

            heap.set(1, heap.get(heap.size() - 1));
            heap.remove(heap.size()-1);

            int pos = 1;
            while((pos * 2) < heap.size()) {
                int max = heap.get(pos * 2);
                int maxPos = pos * 2;

                if(((pos * 2 + 1) < heap.size()) && max < heap.get(pos * 2 + 1)) {
                    max = heap.get(pos * 2 + 1);
                    maxPos = pos * 2 + 1;
                }

                if(heap.get(pos) > max) {
                    break;
                }

                int temp = heap.get(pos);
                heap.set(pos, heap.get(maxPos));
                heap.set(maxPos, temp);
                pos = maxPos;
            }
            return deleteItem;
        }
    }
}

