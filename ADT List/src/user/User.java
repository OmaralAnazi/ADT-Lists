package user;

import implementer.List;
import implementer.ArrayBasedList;
import implementer.SinglyLinkedList;
import implementer.DoublyLinkedList;

import java.util.Scanner;

public class User {
	public static void main(String[] args) {
		
		// This is the only line change when we need to
		// change the ADT list to another ADT list.
		List<String> list = new DoublyLinkedList<>();
//		List<String> list = new SinglyLinkedList<>();
//		List<String> list = new ArrayBasedList<>(5);
		
		// The output is always the same whatever the ADT list 
		// above, but the implementation details are different.

		list.insert("A");
		list.insert("B");
		list.insert("C");
		list.insert("D");
		list.insert("E");
		list.findPrevious();
		list.findPrevious();
		list.remove();
		list.findFirst();
		list.findNext();
		String str = list.retrive();
		list.findLast();
		list.update(str);
		System.out.println(list); 
		System.out.println("Length: "+getLength(list));
		if(findIndex(list, 2))
			System.out.println("Index 2: "+list.retrive());
		if(findIndex(list, 5))
			System.out.println("Index 5: "+list.retrive());
		System.out.println("Is 'C' exists? "+findElement(list, "C"));

		// OUTPUT: 
		// [A, B, D, B]
		// Length: 4
		// Index 2: D
		// Is 'C' exists? false
	}
	
	// The following methods are implemented by the user of the ADT lists.
	// The only way the user can apply new operations to the ADT, is by writing
	// a new operation using the ADT operations themselves.
	
	
	// Result: Return the number of existing elements in the list. If the list is empty 
	// current doesn't change. Otherwise, the current becomes the first element
	// Time complexity: O(n)
	public static <T> int getLength(List<T> list) {
		int length = 0;
		if(!list.empty()) {	// Requirement!
			list.findFirst();
			while(!list.last()) {
				length++;
				list.findNext();
			}
			length++;
			list.findFirst();
		}
		return length;
	}
	
	
	// Result: Search for the element e. If exist, make the current point to e and
	// return true. Otherwise, return false and current points to first element.
	// Time complexity: O(n)
	public static <T> boolean findElement(List<T> list, T e) {
		if(!list.empty()) {	// Requirement!
			list.findFirst();
			while(!list.last()) {
				if(list.retrive().equals(e))
					return true;
					list.findNext();
			}
			if(list.retrive().equals(e))
				return true;
		}
		list.findFirst();
		return false;
	}
	
	
	// Result: Search for index i. If the list is empty or the index i is not  
	// valid, then return false, and the current doesn't change. If index i 
	// exist, return true and make the current point to index i.
	// Time complexity: O(n)
	public static <T> boolean findIndex(List<T> list, int i) {
		if(list.empty() || (i < 0 || i > getLength(list)-1)) 
			return false;
						  
		int count = 0;	  
		list.findFirst(); 
		while(!list.last()) {
			list.findNext();
			count++;
			if(count==i)
				return true;
		}
		return false; 
	}
	
}
