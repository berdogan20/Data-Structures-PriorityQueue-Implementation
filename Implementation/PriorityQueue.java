package Implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class PriorityQueue<E extends Comparable<E>> 
{
	private List<E> heap;
	
	public PriorityQueue()
	{
		heap = new ArrayList<>();
	}
	
	public void add(E element)
	{
		heap.add(element);
		int index = heap.size() - 1;
		
		// heapify the above
		while (index > 0)
		{
			int parentIndex = (index - 1) / 2;
			E parent = heap.get(parentIndex);
			
			if (element.compareTo(parent) > 0)
			{
				heap.set(index, parent);
				index = parentIndex;
			}
			else
			{
				break;
			}
		}
		
		heap.set(index, element);
	}
	
	public E remove()
	{
		if (heap.isEmpty())
		{
			throw new NoSuchElementException();
		}
	
		E deleteElement = heap.get(0);
		E lastElement = heap.remove(heap.size() - 1); // removes the last element from heap, and keeps it
		
		if (!heap.isEmpty())
		{
			// move the last element in place of deleted one.
			heap.set(0, lastElement);
			
			int index = 0;
			
			// heapify the below
			while(true)
			{
				int leftChildIndex = 2 * index + 1;
				int rightChildIndex = 2 * index + 2;
				
				if (leftChildIndex >= heap.size())
				{
					// this node does not have a left child
					break;
				}
				
				// this node has a left child
				int maxChildIndex = leftChildIndex;
				
				if (rightChildIndex < heap.size() &&
						heap.get(rightChildIndex).compareTo(heap.get(leftChildIndex)) > 0)
				{
					// this node has a right child 
					// and it is greater than the left one
					maxChildIndex = rightChildIndex;
				}
				
				if (heap.get(maxChildIndex).compareTo(lastElement) > 0)
				{
					// if the child is greater than the inplaced element
					// swap them
					heap.set(index, heap.get(maxChildIndex));
					index = maxChildIndex;
				}
				else
				{
					break;
				}
			}
			
			heap.set(index, lastElement);
		}
		
		return deleteElement;
	}
	
	
	public E peek() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException();
        }
        return heap.get(0);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

	public E poll() {
		E deleteElement = remove();
		return deleteElement;
	}


	
}







