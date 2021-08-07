import java.io.*;
import java.util.*;

/**

Problem Statement: https://www.hackerearth.com/practice/data-structures/queues/basics-of-queues/practice-problems/algorithm/disk-tower-b7cc7a50/
Submitted Solution: https://www.hackerearth.com/submission/61691006/



*/

class DiskTower {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        String[] arr_arr = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i_arr = 0; i_arr < arr_arr.length; i_arr++) {
            arr[i_arr] = Integer.parseInt(arr_arr[i_arr]);
        }

        ArrayList<Integer>[] out_ = Solve(arr);
        for (int i_out_ = 0; i_out_ < out_.length; i_out_++) {

            for (int j_out_ = 0; j_out_ < out_[i_out_].size(); j_out_++) {
                System.out.print(out_[i_out_].get(j_out_) + " ");
            }
            System.out.println("");
        }

        wr.close();
        br.close();
    }

    static ArrayList<Integer>[] Solve(int[] arr) {
        Queue<Integer> queue = new PriorityQueue<>((x,y) -> Integer.compare(y,x));
        ArrayList<Integer>[] ints = new ArrayList[arr.length];
        int N = arr.length;
        for(int i=0; i<arr.length; i++) {
            ArrayList<Integer> in = new ArrayList<>();
            queue.add(arr[i]);

            while(!queue.isEmpty() && N==queue.peek()) {
                in.add(queue.poll());
                N--;
            }

            ints[i]=in;
        }
        return ints;
    }
}
