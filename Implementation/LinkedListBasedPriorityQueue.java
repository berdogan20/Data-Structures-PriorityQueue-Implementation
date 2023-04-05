package Implementations;

public class LinkedListBasedPriorityQueue<T extends Comparable<T>> {

	private class Node
	{
		T data;
		int priority;
		Node next;
	
		public Node(T data, int priority)
		{
			this.data = data;
			this.priority = priority;
		}
	}
	
	private Node head;
	private int size;
	
	public LinkedListBasedPriorityQueue()
	{
		head = null;
		size = 0;
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
	public void enqueue(T item, int priority)
	{
		Node newNode = new Node(item, priority);
		
		if (isEmpty() || priority > head.priority)
		{
			newNode.next = head;
			head = newNode;
		}
		else
		{
			Node current = head;
			
			while (current.next != null && current.next.priority < newNode.priority)
			{
				current = current.next;
			}
			
			newNode.next = current.next;
			current.next = newNode;
		}
		
		size++;
	}
	
	public T dequeue()
	{
		if (isEmpty())
		{
			return null;
		}
		
		T item = head.data;
		head = head.next;
		size--;
		return item;
	}
	
	public T peek()
	{
		if (isEmpty())
		{
			return null;
		}
		
		T item = head.data;
		return item;
	}
	
	public int size()
	{
		return size;
	}
}









