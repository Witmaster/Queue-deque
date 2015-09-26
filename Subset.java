import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class Subset
{
    public Subset() { }
    public static void main(String[] args)
    {
        RandomizedQueue<String> rndq = new RandomizedQueue<String>();
//        while (StdIn.hasNextLine() && !StdIn.isEmpty())
//        {
//            rndq.enqueue(StdIn.readString());
//        }
        String input = StdIn.readLine();
        String[] items = input.split(" ");
        for (int index = 0; index < items.length; index++)
            rndq.enqueue(items[index]);
        int max = Integer.parseInt(args[0]);
        for (int index = 0; index < max; index++)
        {
            StdOut.println(rndq.dequeue());
        }
    }
}