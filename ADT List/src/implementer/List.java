package implementer;

// Good practice for implementing different ADTs 
// with the same operations
public interface List<T> {
	public void findFirst();
	public void findLast();
	public void findNext();
	public void findPrevious();
	public T retrive();
	public void update(T e);
	public void insert(T e);
	public void remove();
	public boolean full();
	public boolean empty();
	public boolean first();
	public boolean last();
}

	
	