import java.util.Arrays;

public class ArrayList<T> implements List<T>{
	
	protected T[] array;
	protected int size;


	public ArrayList() {
		array = (T[]) new Object[10];
		size = 0;
	}


	public void add(T item){
		if (size == array.length)
			growArray();
		array[size++] = item;
	}
	public void add(int pos, T item) throws IndexOutOfBoundsException{
		if (pos<0 || pos>size)
			throw new IndexOutOfBoundsException("Position out of bounds...");
		if (size == array.length)
			growArray();
		for (int i = size; i>pos; i--){
			array[i] = array[i-1];
		}
		array[pos] = item;
		size++;
	}
	public T get(int pos) throws IndexOutOfBoundsException{
		if (pos<0 || pos>size)
			throw new IndexOutOfBoundsException("Position out of bounds...");
		return array[pos];
	}
	public T remove(int pos) throws IndexOutOfBoundsException{
		if (pos<0 || pos>size)
			throw new IndexOutOfBoundsException("Position out of bounds...");
		if (size == 0)
			throw new IndexOutOfBoundsException("Position out of bounds...");
		T temp = array[pos];
		for (int i = pos; i<size; i++){
			array[i] = array[i+1];
		}
		array[size] = null;
		size--;
		return temp;
	}
	public int size(){
		return size;
	}
	public void growArray(){
		array = Arrays.copyOf(array, size+1);
	}

}