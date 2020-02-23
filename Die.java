import edu.princeton.cs.algs4.StdOut;
import java.util.Random;

// A data type representing a six-sided die.
public class Die implements Comparable<Die> {
    private int value; // face value

    // Roll the die.
    public void roll() {
        Random random = new Random();
        //sets value to random integer from 1 to 6
        this.value = random.nextInt(6) + 1;
    }

    // Face value of the die.
    public int value() {
        //return value, getValue()
        return this.value;
    }

    // Does the die have the same face value as that?
    public boolean equals(Die that) {
        //this value access to that value
        return this.value == that.value();
    }

    // A negative integer, zero, or positive integer depending on whether this
    // die's value is less than, equal to, or greater than the that die's value.
    public int compareTo(Die that) {
        if (this.equals(that)) {
            return 0;
        } else if (this.value > that.value()) {
            return 1;
        } else {
            return -1;
        }
    }

    // A string representation of the die giving the current face value.
    public String toString() {
        String str = "";
        //use switch to draw out the die
        switch(value){
        case 1:
            str = "   \n * \n   ";
            break;
        case 2:
            str = "*  \n   \n  *";
            break;
        case 3:
            str = "*  \n * \n  *";
            break;
        case 4:
            str = "* *\n   \n* *";
            break;
        case 5:
            str = "* *\n * \n* *";
            break;
        case 6:
            str = "***\n   \n***";
            break;
        default:
            str = "You broke my program?";
    }
        return str;
    }

    // Test client. [DO NOT EDIT]
    public static void main(String[] args) throws IllegalArgumentException {
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        int z = Integer.parseInt(args[2]);

        //statement to handle invalid input
        if(x < 0 || y < 0 || z < 0 || x > 6 || y > 6 || z > 6) {
            StdOut.printf("x: %d,", x);
            StdOut.printf("y: %d,", y);
            StdOut.printf("z: %d,", z);
            throw new IllegalArgumentException("Must input 3 arguments from 1 to 6 (inclusive)");
        }

        Die a = new Die();
        a.roll();
        while (a.value() != x) {
            a.roll();
        }
        Die b = new Die();
        b.roll();
        while (b.value() != y) {
            b.roll();
        }
        Die c = new Die();
        c.roll();
        while (c.value() != z) {
            c.roll();
        }
        StdOut.println(a);
        StdOut.println(a.equals(b));
        StdOut.println(b.equals(c));
        StdOut.println(a.compareTo(b));
        StdOut.println(b.compareTo(c));
    }
}
