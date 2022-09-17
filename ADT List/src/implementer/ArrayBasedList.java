package implementer;

public class ArrayBasedList<T> implements List<T> {
	// Representation:
	private int maxSize;
	private int size;
	private int current;
	private T[] elements;
	
	public ArrayBasedList(int maxSize) {
		this.maxSize = maxSize;
		size = 0;
		current = -1;
		// Syntax for creating an array of generic types:
		elements = (T[]) new Object[maxSize]; 
	}
	
	// Implementation:
	@Override
	public void findFirst() {
		current = 0;
	}

	@Override
	public void findLast() {
		current = size-1;
	}

	@Override
	public void findNext() {
		current++;
	}

	@Override
	public void findPrevious() {
		current--;
	}

	@Override
	public T retrive() {
		return elements[current];
	}

	@Override
	public void update(T e) {
		elements[current] = e;
	}

	@Override
	public void insert(T e) {
		size++;
		current++;
		for(int i = size-1; i>current; i--)
			elements[i] = elements[i-1];
		elements[current] = e;
	}

	@Override
	public void remove() {
		for(int i = current; i<size-1; i++) 
			elements[i] = elements[i+1];
		size--;
		elements[size] = null; 
		if(current >= size)
			current = 0;
		if(size == 0)
			current = -1;
	}

	@Override
	public boolean full() {
		return size == maxSize;
	}

	@Override
	public boolean empty() {
		return size == 0;
	}

	@Override
	public boolean first() {
		return current == 0;
	}

	@Override
	public boolean last() {
		return current == size-1;
	}
	
	// For User Testing 
	public String toString() {
		String output = "[";
		for(int i = 0; i<size; i++) {
			if(i != size-1)
				output += elements[i]+", ";
			else
				output += elements[i]+"";
		}
		return output+"]";
	}
}
