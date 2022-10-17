package jaryogoojo;
import java.util.*;
interface Stack<ET>{
	public void push(ET elem);
	public ET pop();
	public int size();
}
class ArrayStack<ET> implements Stack<ET>{
	private ET[] elem;
	private int top;
	final static int INIT_CAPACITY = 5;
	
	public ArrayStack() {
		this(INIT_CAPACITY);
	}
	public ArrayStack(int initCapacity) {
		if(initCapacity<0)
			try {
				throw new IllegalArgumentException("Initial capacity > 0");
			}catch(IllegalArgumentException e) {
				System.out.println("exception");
			}
		elem = (ET[]) new Object[initCapacity];
		top = -1;
	}
	
	public void push(ET e) {
		if(top == elem.length-1)
			doubleCapacity();
		top++;
		elem[top] = e;
	}
	public ET pop() {
		if( top == -1)
			try {
				throw new EmptyStackException();
			}catch(EmptyStackException e) {
				System.out.println("exception2");
				return null;
			}
		ET e = elem[top];
		elem[top] = null;
		top--;
		return e;
	}
	public int size() {
		return top +1;
	}
	private void doubleCapacity() {
		Object [] tmp = elem;
		elem = (ET[]) new Object[2*tmp.length];
		
		int size = top +1;
		System.arraycopy(tmp, 0, elem, 0, size);
	}
}



public class stack_array {

	public static void main(String[] args) {
		ArrayStack<Integer> as = new ArrayStack<Integer>();
		as.push(20);
		as.push(60);
		as.push(30);
		System.out.println(as.pop());
		System.out.println(as.pop());
		System.out.println(as.pop());
		System.out.println(as.pop());
		System.out.println(as.pop());
		
	}

}
