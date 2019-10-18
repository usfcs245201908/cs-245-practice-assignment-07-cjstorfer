class Node<T>{
	T data; 
	Node next; 

	public Node(Object data){
		this.data = (T) data; 
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
	public void add(int pos, T item){
		if (pos>size|| pos<0)
			throw new Exception("Position out of bounds..."); 
		if (pos == 0){
			Node node = new Node(item);
			node.next = head;
			head = node;
			size++;
		}
		else{
			Node prev = head;
			for(int i=0; i<pos-1; i++)
				prev = prev.next;
			Node node = new Node(item)
			node.next = prev.next;
			prev.next = node;
		}
	}
	public T get(int pos){
		if(pos<0 || pos>size) {
			throw new Exception("Position out of bounds...");
			return null;
		}
		Node prev = head;
		for(int i = 0; i < pos; i++) {
			prev = prev.next;
		}
		return(prev.data);
	}
	public T remove(int pos){
		if(pos<0 || pos>size) {
			throw new Exception("Position out of bounds...");
			return null;
		}
		if (pos == 0){
			Node node = new Node(item);
			head = head.next;
			size--;
		}
		else{
			Node prev = head;
			for(int i=0; i<pos; i++)
				prev = prev.next;
			Node node = prev.next;
			prev.next = node.next;
			size--;
		}
		return node.data;
	}
	public int size(){
		return size;
	}

}