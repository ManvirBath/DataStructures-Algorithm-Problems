// KthString.java: Takes a command-line argument k and prints
// the kth string from the end found on standard input,
// assuming that standard input has k or more strings.

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class KthString {
    public static void main(String[] args) {

        Queue<String> q = new Queue<String>();
        String kth = "";
        int i = Integer.parseInt(args[0]);
        while (!StdIn.isEmpty()) {  //while standard input is not empty, continue reading input
            String k = StdIn.readString();
            q.enqueue(k); //k string pushed into queue till empty
        }
        int size = q.size();
        //loops through and gets you kth item from end of the queue, mutates your queue
        for (int j = 0; j < size - i + 1; j++) {
            kth = q.dequeue();
        }
        StdOut.println(kth);
    }
}





