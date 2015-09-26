import java.util.Iterator;

public class Deque<Item> implements Iterable<Item>
{
    private class Node<Item>
{
    private Item item;
    private Node<Item> prev;
    private Node<Item> next;
    public Node(Item item)
    {
        this.item = item;
    }
}
    private class DequeIterator implements Iterator<Item>
{
    private Node<Item> current;
    DequeIterator()
    {
        current = first;
    }
    public boolean hasNext()
    {
        return current != null;
    }
    public Item next()
    { 
        if (current == null) 
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
    private Node first = null;
    private Node last = null;
    private int length = 0;
    public Deque() { }
    public boolean isEmpty()
    { 
        return first == null;
    }
    
    public int size()
    {
        return length;
    }
    public void addFirst(Item item)
    {
        if (item == null)
        {
            throw (new java.lang.NullPointerException());
        }
        else
        {
            length++;
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
            length++;
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
        if (first != null)
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
                last = null;
            }
            length--;
            return result.item;
        }
        else
            throw (new java.util.NoSuchElementException());
    }
    public Item removeLast()
    {
        if (last == null)
            throw (new java.util.NoSuchElementException());
        else
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
                first = null;
            }
            length--;
            return out.item;
        }
    }
    public Iterator<Item> iterator() { return new DequeIterator(); }
    public static void main(String[] args)
    {
    }
}

