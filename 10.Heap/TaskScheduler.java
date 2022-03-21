package com.example.stub.unassigned;

/**
 * Problem statement: https://leetcode.com/problems/task-scheduler/
 * Submitted solution: https://leetcode.com/submissions/detail/659839548/
 *
 Input: tasks = ["A","A","A","B","B","B"], n = 2
 Output: 8
 Explanation:
 A -> B -> idle -> A -> B -> idle -> A -> B
 There is at least 2 units of time between any two same tasks.
 */

import java.util.*;

public class TaskScheduler {
    class Tuple implements Comparable<Tuple> {
        Character c;
        Integer freq;

        Tuple(Character c, Integer freq) {
            this.c = c;
            this.freq = freq;
        }

        Tuple(Tuple t) {
            this.c = t.c;
            this.freq = t.freq;
        }

        @Override
        public boolean equals(Object o) {
            Tuple t = (Tuple) o;
            return this.c == t.c && this.freq == t.freq;
        }

        @Override
        public int hashCode() {
            return 37 * this.c + this.freq;
        }

        @Override
        public int compareTo(Tuple o) {
            return this.freq.compareTo(o.freq);
        }

        @Override
        public String toString() {
            return "(" + (char) c + ", " + freq + ")";
        }
    }
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        PriorityQueue<Tuple> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(char c: tasks) {
            freq[c-'A']++;
        }
        for(int i=0; i<26; i++) {
            if(freq[i]>0) {
                char c = (char) ('A' + i);
                pq.add(new Tuple(c, freq[i]));
            }
        }

        int idle = 0;
        Queue<Tuple> tempQueue = new LinkedList<>();
        while(!pq.isEmpty() || !isEmptyOrNull(tempQueue)) {
            if(pq.size() > 0) {
                Tuple poll = pq.poll();
                poll.freq--;
                if(poll.freq == 0) {
                    // discard poll
                    tempQueue.add(null);
                }
                else {
                    tempQueue.add(new Tuple(poll));
                }
            }
            else {
                tempQueue.add(null);
                ++ idle;
            }
            if(tempQueue.size() > n) {
                Tuple t1 = tempQueue.poll();
                if(t1 != null) {
                    pq.add(t1);
                }
            }
        }
        return tasks.length + idle;
    }

    private boolean isEmptyOrNull(Queue<Tuple> tempQueue) {
        if(tempQueue == null || tempQueue.isEmpty()) return true;
        for(Tuple t: tempQueue) {
            if (t != null) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TaskScheduler t = new TaskScheduler();
//        System.out.println("8: " + t.leastInterval("AAABBB".toCharArray(), 2));
//        System.out.println("8: " + t.leastInterval("AAABBB".toCharArray(), 0));
//        System.out.println("8: " + t.leastInterval("AAAAAABCDEFG".toCharArray(), 2));
//        System.out.println("1: " + t.leastInterval("A".toCharArray(), 0));
//        System.out.println("1: " + t.leastInterval("A".toCharArray(), 1));
        System.out.println("7: " + t.leastInterval("ABCCCD".toCharArray(), 2));
        System.out.println("9: " + t.leastInterval("ABCCCD".toCharArray(), 3));
        System.out.println("9: " + t.leastInterval("DABCCCD".toCharArray(), 3));
        System.out.println("9: " + t.leastInterval("ABCCCDD".toCharArray(), 3));

//        System.out.println(t.leastInterval("AAADBBBCCDE".toCharArray(), 2));
    }
}
