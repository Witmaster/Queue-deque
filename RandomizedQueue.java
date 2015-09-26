import java.util.Iterator;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item>
{
    private Item[] queue = (Item[]) new Object[8];
    private int queueSize = 8;
    private int lastIndex = -1;
    public RandomizedQueue() { }
    
    private void resize(boolean updown)
    {
        if (updown)
        {
            queueSize *= 2;
            Item[] copy = (Item[]) new Object[queueSize];
            StdRandom.shuffle(queue);
            for (int index = 0; index < lastIndex; index++)
            {
                copy[index] = queue[index];
            }
            queue = copy;
        }
        else
        {
            queueSize /= 2;
            Item[] copy = (Item[]) new Object[queueSize];
            for (int index = 0; index <= lastIndex; index++)
            {
                copy[index] = queue[index];
            }
            queue = copy;
        }
    }
    
    public boolean isEmpty()
    {
        return (lastIndex == -1);
    }
    
    public int size()
    {
        return lastIndex + 1;
    }
    
    public void enqueue(Item item)
    {
        if (item != null)
        {
            lastIndex++;
            if (lastIndex == queue.length)
            {
                resize(true);
            }
            if (lastIndex > 0)
            {
                int rnd = StdRandom.uniform(0, lastIndex);
                if (rnd < lastIndex)
                {
                    queue[lastIndex] = queue[rnd];
                    queue[rnd] = item;
                }
                else 
                    queue[lastIndex] = item;
            }
            else
            queue[lastIndex] = item;
        }
        else
        {
            throw (new java.lang.NullPointerException());
        }
    }
    
    public Item dequeue()
    {
        if (lastIndex > -1)
        {
            Item result = queue[lastIndex];
            queue[lastIndex] = null;
            lastIndex--;
            if (lastIndex < queue.length/4 && lastIndex > 2)
            {
                resize(false);
            }
            return result;
        }
        else
        {
            throw (new java.util.NoSuchElementException());
        }
    }
    
    public Item sample()
    {
        if (lastIndex > -1)
        {
            if (lastIndex > 0)
                return queue[StdRandom.uniform(0, lastIndex)];
            else
                return queue[0];
        }
        else
        {
            throw (new java.util.NoSuchElementException());
        }
    }
    
    public Iterator<Item> iterator()
    { 
        return new QueueIterator();
    }
    
    private class QueueIterator implements Iterator<Item>
    {
        private Item[] rndqueue = (Item[]) new Object[lastIndex + 1];
        private int curIndex = 0;
        public QueueIterator()
        {
            for (int index = 0; index < rndqueue.length; index++)
                rndqueue[index] = queue[index];
            StdRandom.shuffle(rndqueue);
        } 
        
        public boolean hasNext()
        {
            return (curIndex < lastIndex + 1);
        }
        
        public Item next()
        {
            if (hasNext())
            {
                return rndqueue[curIndex++];
            }
            else
                throw (new java.util.NoSuchElementException());
        }
        public void remove() { throw (new java.lang.UnsupportedOperationException()); }
    }

    public static void main(String[] args) { }
}
