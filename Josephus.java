// Josephus.java: Takes N and M from the command line and prints out the order
// in which people are eliminated (and thus would show Josephus where to sit in
// the circle).

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Josephus {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        Queue<Integer> q = new Queue<Integer>();
        //arrange people in a circle from 0 to n - 1
        for (int i = 0; i < n; i++) {
            q.enqueue(i);
        }
        while (!q.isEmpty()) {
            //cut the deck, this function reshuffles the queue without disrupting order
            for (int i = 0; i < m - 1; i++) {
                q.enqueue(q.dequeue());
            }
            StdOut.print(q.dequeue() + " ");
        }
        StdOut.println();
    }
}
