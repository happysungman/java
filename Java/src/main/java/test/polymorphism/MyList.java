package test.polymorphism;

import java.util.ArrayList;
import java.util.Arrays;

public class MyList<E> extends ArrayList<E> {
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see java.util.ArrayList#get(int)
	 */
	@Override
	public E get(int index) {
		System.out.print("MyList get Method returns = ");
		return super.get(index);
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ArrayList<String>[] listArray = new ArrayList[2];
		listArray[0] = new ArrayList<String>();
		listArray[1] = new MyList<String>();
		Arrays.stream(listArray).forEach(list -> list.add("first object"));
		Arrays.stream(listArray).forEach(list -> System.out.println(list.get(0)));
	}
}
/* 
출력
first object
MyList get Method returns = first object
*/
