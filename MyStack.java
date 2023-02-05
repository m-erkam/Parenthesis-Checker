
package question;
import java.util.Arrays;
import java.util.NoSuchElementException;


public class MyStack{
	
	private Character[] a; // array of items
	
	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	
	
	public MyStack() {			// I create an instructor with an array
		a = new Character[4];
	}
	
	public boolean isEmpty() {	// A method to check whether the stack is empty
		if (a[0] == null) {		// If 0th element of stack is null it means it is empty
			return true;		
		} else {				// Otherwise it has elements
			return false;
		}
	}
	
	public int size() {			// Size method which returns the length of stack
		return a.length;
	}
	
	private void resize() {		// Resize method to double the size of stack when we add excess element 
		Character[] temp = a.clone();	// First I clone the stack
		a = null;
		a = new Character[temp.length*2];	// And I reinitialize the stack with doubled size
		for (int i = 0; i<temp.length; i++) {	// And I add the old elements
			a[i] = temp[i];
		}
	}
	
	public void push(char item) {		// Push method to add elements to the stack
		for (int j = 0; j < a.length; j++) {	
			int counter = 0;			
			if (a[j] == null) {		// The program search for the first empty space in the stack
				a[j] = item;		// And it insert the item 
				counter++;
				break;
			} 
			
			if (counter != 1 && j == a.length - 1) {	// When the stack is full, it resizes the stack
				resize();								// And continue to add the item
				j = 0;
				continue;
			}
		}
	}

			
	public char pop() {						// Pop method to remove the last element and return to it
		for (int k = 0; k<a.length; k++) {
			if (a[0] == null) 			// If stack is empty it returns the character A (which is not important)
				break;
			if (a[k] == null) {		// To find the last element, it first finds the first null element 
				char temp = a[k-1];	// And it takes the previous element
				a[k-1] = null;
				return temp;		// And returns it
			}
			if (k == a.length-1 && a[k] != null) {	// When the stack is full
				char temp = a[k];					// It takes the last element
				a[k] = null;
				return temp;
			}
		}
		return 'A';
	}
	
	public char peek() {		// Peek method to return the last element of the stack without removing it
		for (int k = 0; k<a.length; k++) {
			if (a[0] == null) 
				break;
			if (a[k] == null) {		// To find the last element, it first finds the first null element
				return a[k-1];		// And it takes the previous element
			}
			if (k == a.length-1) {
				return a[k];
			}
		}
		return 'B';
		
	}
	
	
	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
	
}

