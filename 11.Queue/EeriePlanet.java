
/**

 Problem Statement: https://www.hackerearth.com/practice/data-structures/queues/basics-of-queues/practice-problems/algorithm/weird-planet-2000a170/
 Submitted Solution: https://www.hackerearth.com/submission/61707478/

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class EeriePlanet {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {
        int H = nextInt(), C = nextInt(), Q = nextInt();

        int hours[] = new int[H+1];

        for (int i=0; i<C; i++) {
            int hi = nextInt(), Si = nextInt(), Ei = nextInt();

            for(int j=Si; j<=Ei; j++) {
                if(hours[j] == 0) hours[j] = hi;
                else hours[j] = Math.max(hours[j], hi);
            }
        }

        for (int i=0; i<Q; i++) {
            int hi = nextInt(), ti = nextInt();

            if(hours[ti] == 0 || hours[ti] < hi) pw.println("YES");
            else pw.println("NO");
        }

        pw.flush();
    }

    static int nextInt() {
        int read = 0, num=0;
        try {
            while(read < '0' || read > '9') read=br.read();
            while(read >= '0') {
                num = num*10 + read-'0';
                read=br.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return num;
    }
}

