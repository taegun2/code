package jaryo;
import java.util.Scanner;

//ET = Element Type

//LinearList 인터페이스
interface LinearList2<ET>{
	void insert(ET e);
	Boolean remove(ET e);
	int search(ET e);
	void show();
	ET get(int index);
	int binarySearch(int[] arr, int x);
}
class ArrayListSorted<ET> implements LinearList2<ET> {
	public ET elem[ ]; // sorted array.
	int size; // number of elements in elem[ ] 
	static final int INIT_CAPACITY = 5;
	public ArrayListSorted( ) {
		this( INIT_CAPACITY ); 
		} 
	public ArrayListSorted( int initCapacity ) {
		elem= (ET[ ]) new Object[initCapacity]; 
		}
	
	public void insert(ET theElem) {
		if(size == elem.length)
			changeCapacity(2*size);
		
		int i=0;
		Comparable<ET> e = (Comparable<ET>)theElem;
		while(i<size&&e.compareTo(elem[i])>0)
			i++;
		
		for(int j = size; j>i; j--) {
			elem[j] = elem[j-1];
		}
		elem[i]= theElem;
		size++;
	}
	public void changeCapacity(int newCapacity) {
		ET[] tmp = (ET[])new Object[newCapacity];
		for(int i =0; i<size; i++) {
			tmp[i] = elem[i];
		}
		elem = tmp;
	}
	public Boolean remove(ET theElem) {
		int i;
		for(i = 0; i<size; i++) {
			if(elem[i].equals(theElem))
				break;
		}
		if(i==size)
			return false;
		for(;i<size-1;i++)
			elem[i] = elem[i+1];
		
		size--;
		if(size <= elem.length/4)
			changeCapacity(elem.length/2);
		return true;
	}
	public int search(ET theElem) {
		int i;
		for(i=0;i<size;i++) {
			if(elem[i].equals(theElem))
				return i;
		}
		return -1;
	}
	public ET get(int index) {
		if(index < 0 || index >= size) {
			try {
			throw new ArrayIndexOutOfBoundsException("exception");
			} catch(IndexOutOfBoundsException e) {
				System.out.println("exception");
				return null;
			}
		}
			return elem[index];
		
	}
	public void show() {
		for(int i=0; i<size; i++) {
			System.out.print(elem[i] + " ");
			
		}
		System.out.println();
	}
	public int binarySearch(int[] arr, int x) {
		int p=0;
		int q = arr.length-1;
		int m;
		while(p<=q) {
			m = (p+q)/2;
			if( x == arr[m])
				return m;
			else if(x<arr[m])
				q = m-1;
			else
				p = m+1;
			}
		return -1;
		}
	
}
public class jaryo2 {

	public static void main(String[] args) {
		ArrayListSorted<Integer> al = new ArrayListSorted<Integer>();
		al.insert(40);
		al.insert(50);
		al.insert(60);
		al.insert(10);
		al.insert(20);
		al.insert(30);
		al.show();
		int[] arr = new int[];
		int r = al.search(30);
		System.out.println(r);
		int r2 = al.search(90);
		//int r3 = al.binarySearch(al, 30);
		
		System.out.println(al.get(3));
		
		al.remove(30);
		al.remove(10);
		al.remove(60);
		
		al.show();
		
		
	}

}
