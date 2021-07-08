

/**
 * Problem Statement: https://www.hackerearth.com/practice/algorithms/graphs/topological-sort/practice-problems/algorithm/oliver-and-the-game-3/
 * Submitted Solution: https://www.hackerearth.com/submission/key/9fbe97cc43a74a77b4a8bdd48eefaae6/?theme=light width='100%' height='3266px' frameborder='0' allowtransparency='true' scrolling='yes'
 *
 */

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class OliverAndTheGame {
    private static final PrintWriter pw = new PrintWriter(System.out);
    private static int N, Q, BXY[];
    private static final Reader s = new Reader();

    public static void main(String[] args) throws IOException {
        new OliverAndTheGame().runner();
    }

    private void runner() throws IOException {
        N = nextInt();
        int adj[] = new int[N-1];

        for ( int i=0; i<N-1; i++ ) {
            int t0 = nextInt()-1;
            int t1 = nextInt()-1;
            adj[t1-1]=t0;
        }

        Q = nextInt();

        outerloop:
        for ( int i=0; i<Q; i++ ) {
            int from, to;
            int BXY0 = nextInt();
            int BXY1 = nextInt();
            int BXY2 = nextInt();
            --BXY1; --BXY2;

            if(BXY0 == 0) {
                from = BXY2;
                to = BXY1;
            }
            else {
                from = BXY1;
                to = BXY2;
            }
            while (from != to && from != 0) {
                from = adj[from-1];
            }
            pw.println(from == to ? "YES" : "NO");
        }
        pw.flush();
    }

    private int nextInt() throws IOException {
        return s.nextInt();
    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
}
