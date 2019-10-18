class Node<T>{
	T data; 
	Node next; 

	public Node(T data){
		this.data = (T)data;
		this.next = null; 
	}
}

public class LinkedList<T> implements List<T>{
	
	protected Node head;
	protected int size;


	public LinkedList(){
		head = null;
		size = 0;
	} 
	public void add(T item){
		if (head==null){
			head = new Node(item);
		}
		else{
			Node node = new Node(item);
			Node prev = head;

			while(prev.next!=null)
				prev = prev.next;
			prev.next = node;
			
		}
		size++;	
	}
	public void add(int pos, T item) throws IndexOutOfBoundsException{
		if (pos>size|| pos<0)
			throw new IndexOutOfBoundsException("Position out of bounds..."); 
		if (pos == 0){
			Node node = new Node(item);
			node.next = head;
			head = node;
			++size;
		}
		else{
			Node node = new Node(item); 
			Node prev = head;
			for(int i=0; i<pos-1; i++)
				prev = prev.next;
			node.next = prev.next;
			prev.next = node;
			++size;
		}
	}
	public T get(int pos) throws IndexOutOfBoundsException{
		if(pos<0 || pos>size) {
			throw new IndexOutOfBoundsException("Position out of bounds...");
		}
		Node prev = head;
		for(int i = 0; i < pos; i++) {
			prev = prev.next;
		}
		return((T)prev.data);
	}
	public T remove(int pos) throws IndexOutOfBoundsException{
		if(pos<0 || pos>size) {
			throw new IndexOutOfBoundsException("Position out of bounds...");
		}
		if (pos == 0){
			Node node = head;
			head = head.next;
			size--;
			return (T)node.data;
		}
		else{
			Node prev = head;
			for(int i=0; i<pos-1; i++)
				prev = prev.next;
			Node node = prev.next;
			prev.next = node.next;
			size--;
			return (T)node.data;
		}
	}
	public int size(){
		return size;
	}

}