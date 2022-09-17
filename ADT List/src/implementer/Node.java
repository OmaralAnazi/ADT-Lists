package implementer;

// Used for liked list 
// For singly: only use the next and data members
// for doubly: uses all members
public class Node<T> {
	public T data;
	public Node<T> next;
	public Node<T> previous;

	public Node() {
		this(null, null, null);
	}
	
	public Node(T data) {
		this(data, null, null);
	}
	
	public Node(T data, Node<T> next, Node<T> previous) {
		this.data = data;
		this.next = next;
		this.previous = previous;
	}
}

	