import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

public class Deque<Item> implements Iterable<Item>
{
    private class Node<Item>
{
    Item item;
    Node<Item> prev;
    Node<Item> next;
    public Node(Item item)
    {
        this.item = item;
    }
}
    private class dequeIterator implements Iterator<Item>
{
    Node<Item> current;
    dequeIterator()
    {
        current = first;
    }
    public boolean hasNext(){
        if (current.next == null)
            return false;
            else
            return true;
    }
    public Item next(){ 
        if (current.next == null) 
            throw (new java.util.NoSuchElementException());
        else
        {
            Item result = current.item;
            current = current.next;
            return result;
        }
    }
    public void remove()
    {
        throw (new java.lang.UnsupportedOperationException());
    }
    
}
    private Node first;
    private Node last;
    public Deque(){}
    public boolean isEmpty(){ if (first==null) return true; else return false; }
    public int size()
    {
        dequeIterator iter = new dequeIterator();
        int counter = 0;
        while (iter.hasNext())
        {
            counter++;
            iter.next();
        }
        return counter;
    }
    public void addFirst(Item item)
    {
        if (item == null)
        {
            throw (new java.lang.NullPointerException());
        }
        else
        {
            Node<Item> newNode = new Node(item);
            if (first == null)
            {
                first = newNode;
                if (last == null) last = newNode;
            }
            else
            {
                newNode.next = first;
                first.prev = newNode;
                first = newNode;
            }
        }
    }
    public void addLast(Item item)
    {
        if (item == null)
        {
            throw (new java.lang.NullPointerException());
        }
        else
        {
            Node<Item> newNode = new Node(item);
            if (last == null)
            {
                last = newNode;
                if (first == null) first = newNode;
            }
            else
            {
                newNode.prev = last;
                last.next = newNode;
                last = newNode;
            }
        }
    }
    public Item removeFirst()
    {
        Node<Item> result = first;
        if (first.next != null)
        {
            first = first.next;
            first.prev = null;
        }
        else
        {
            first.next = null;
            first.prev = null;
            first = null;
        }
        return result.item;
    }
    public Item removeLast()
    {
        Node<Item> out = last;
        if (last.prev != null)
        {
            last = last.prev;
            last.next = null;
        }
        else
        {
            last.next = null;
            last.prev = null;
            last = null;
        }
        return out.item;
    }
    public Iterator<Item> iterator(){ return new dequeIterator(); }
    public static void main(String args[])
    {
    }
}

