
package question;

public class ParanthesisChecker {
	

	public boolean isCorrect(String javaCode) { 
		
		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		Character[] charArray = new Character[javaCode.length()];		// Creating an array with the size of the input
		MyStack stack = new MyStack();					// Creating a stack object to check parenthesis
		
		for (int i = 0; i < javaCode.length(); i++) {	// First I convert the input to a character array
			charArray[i] = javaCode.charAt(i);
		}
		
		boolean apostrophe = false;			// A boolean to check if the input has apostrophe
		for (char character : charArray) {
			
			if (apostrophe) {			// If program meets an apostrophe it ignores the elements until another apostrophe is detected
				if (character == '"') {
					apostrophe = false;
					continue;
				} else {
					continue;
				}
				
			}
			if (character == '(') {		// If an element of the input is opening parenthesis
				stack.push(character);	// It adds it to the stack
			}

			if (character == '{') {
				stack.push(character);
			}
			
			if (character == ')') {		// And when it counters a closing parenthesis 
				if (stack.pop() == '(') {	// It pops the last element of the stack and compare it
					continue;	
				} else {					// If it doesn't match it means the code is wrong
					return false;
				}
				
			}

			if (character == '}') {
				if (stack.pop() == '{') {
					continue;
				} else {
					return false;
				}
			}
			if (character == '"') {		// If program meets an apostrophe it ignores the elements until another apostrophe is detected
				apostrophe = true;
				continue;
			}
		}
		
		if (stack.isEmpty()) {		// At the end, if the stack is empty, it means all parenthesis are matched and it returns true
			return true;
		} else {
			return false;
		}
		
		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
		
	}
	
}


