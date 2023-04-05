package Implementations;

public class ArrayBasedPriorityQueue<T extends Comparable<T>> {

	private T[] queue;
	private int size;
	
	public ArrayBasedPriorityQueue()
	{
		this(100);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayBasedPriorityQueue(int initialCapacity)
	{
		queue = (T[]) new Comparable[initialCapacity];
		size = 0;
	}
	
	@SuppressWarnings("unchecked")
	private void extendQueue()
	{
		T[] newQueue = (T[]) new Comparable[queue.length * 2];
		System.arraycopy(queue, 0, newQueue, 0, size);
		this.queue = newQueue;
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	public boolean isFull()
	{
		return queue.length == size;
	}
	
	public int size()
	{
		return size;
	}
	
	public void enqueue(T newElement)
	{
		if (isFull())
		{
			extendQueue();
		}
		
		int index = size;
		
		while (index > 0 && newElement.compareTo(queue[index - 1]) > 0 )
		{
			queue[index] = queue[index - 1];
			index--;
		}
		
		queue[index] = newElement;
		size++;
	}
	
	public T dequeue()
	{
		if (isEmpty())
		{
			return null;
		}
		
		T item = queue[size - 1];
		queue[size - 1] = null;
		size--;
		return item;
	}
	
	public T peek()
	{
		if (isEmpty())
		{
			return null;
		}
		
		T item = queue[size - 1];
		return item;
	}
	
	
}





