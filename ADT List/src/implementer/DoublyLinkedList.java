package implementer;

public class DoublyLinkedList<T> implements List<T>{
	// Representation:
	private Node<T> head;
	private Node<T> tail;
	private Node<T> current;
	
	public DoublyLinkedList() {
		head = tail = current = null;
	}
	
	// Implementation:
	@Override
	public void findFirst() {
		current = head;
	}

	@Override
	public void findLast() {
		current = tail;
	}

	@Override
	public void findNext() {
		current = current.next;
	}

	@Override
	public void findPrevious() {
		current = current.previous;
	}

	@Override
	public T retrive() {
		return current.data;
	}

	@Override
	public void update(T e) {
		current.data = e;
	}

	@Override
	public void insert(T e) {
		if(empty()) {
			head = current = tail = new Node<T>(e);
			return;
		}
		Node<T> newNode = new Node<T>(e, current.next, current);
		if(current.next != null)
			current.next.previous = newNode;
		current.next = newNode;
		current = newNode;
		if(newNode.next == null)
			tail = newNode;
	}

	@Override
	public void remove() {
		// If the current is first only move right (no node before it).
		// Otherwise (there is a node before it) connect previous with next
		if(first()) 
			head = head.next;
		else 
			current.previous.next = current.next;
		
		// If the current is last only move left (no node after it).
		// Otherwise (there is a node after it) connect next with previous
		if(last())
			tail = tail.previous;
		else
			current.next.previous = current.previous;
		
		// Move current either to first (when it is last)
		// or to next
		if(current.next == null)
			current = head;
		else
			findNext();
	}

	@Override
	public boolean full() {
		return false; 	// No mix size for linked lists. Still the size is 
		  				// limited because of the Java memory limitations
	}

	@Override
	public boolean empty() {
		return head == null;
	}

	@Override
	public boolean first() {
		return current == head;
	}

	@Override
	public boolean last() {
		return current == tail;
	}
	
	// For User Testing 
	public String toString() {
		Node<T> temp = head;
		String output = "[";
		while(temp != null) {
			if(temp.next != null)
				output += temp.data+", ";
			else
				output += temp.data+"";
			temp = temp.next;
		}
		return output+"]";
	}
	
}
