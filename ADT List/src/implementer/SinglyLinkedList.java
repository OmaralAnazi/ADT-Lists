package implementer;

public class SinglyLinkedList<T> implements List<T>{
	// Representation:
	private Node<T> head;
	private Node<T> tail;
	private Node<T> current;
	
	public SinglyLinkedList() {
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
		Node<T> temp = head;
		while(temp.next != current) 
			temp = temp.next;
		current = temp;
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
		Node<T> newNode = new Node<>(e);
		if(empty()) {
			head = current = newNode;
			return;
		}
		newNode.next = current.next;
		current.next = newNode;
		current = newNode;
		if(newNode.next == null)
			tail = newNode;
	}

	@Override
	public void remove() {
		if(first() && current.next == null) 
			head = current = tail = null;
		else {
			findPrevious();
			current.next = current.next.next;
			findNext();
			if(current == null)
				current = head;
		}
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
