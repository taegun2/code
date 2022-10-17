package jaryogoojo;

import java.util.NoSuchElementException;

class LinkedQueue <ET> {
	private Node<ET> rear;
	private int size;
	
	public LinkedQueue() {
		rear = null;
		size = 0;
	}
	
	public void add(ET elem) {
		Node<ET> cn = new Node<ET>(elem);
		if(rear == null)
			cn.next = cn;
		else {
			cn.next = rear.next;
			rear.next = cn;
		}
		rear = cn;
		size ++;
	}
	public ET remove() {
		if(size() == 0)
			try {
				throw new NoSuchElementException();
			}catch(NoSuchElementException e) {
				System.out.println("exception");
				return null;
			}
		Node<ET> front = rear.next;
		if(size == 1)
			rear = null;
		else
			rear.next = front.next;
		size--;
		return front.elem;
	}
	
	public boolean notEmpty() {
		return size() !=0;
		}
	private int size() {
		return size;
	}
	class Node<ET>{
		private ET elem;
		private Node<ET> next;
		
		public Node(ET elem) {
			this.elem = elem;
		}
	}
}


public class linked_que {

	public static void main(String[] args) {
		LinkedQueue<Integer> lq = new LinkedQueue<Integer>();
	}

}
