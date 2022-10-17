package jaryogoojo;

import java.util.LinkedList;

interface Stack<ET>{
	public void push(ET elem);
	public ET pop();
	public int size();
}
class SLinkedStack<ET> implements Stack<ET>{
	private Node<ET> top;
	private int size;
	
	SLinkedStack(){
		top = null; size = 0;
	}
	public void push(ET theElem) {
		top = new Node<ET>(theElem,top);
		size++;
	
	}
	public ET pop() {
		if(top == null)
			return null;
		
		Node<ET> np = top;
		top = top.next;
		size--;
		return np.elem;
	}
	public int size() {
		return size;
	}
	class Node<ET>{
		private ET elem;
		private Node<ET> next;
		
		Node(ET e, Node<ET> n){
			elem = e;
			next = n;
		}
	}
}

public class stack_Node {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
