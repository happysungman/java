package test.polymorphism;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Overload {
	public static void get(List<?> list) {
		System.out.println("List");
	}
	
	public static void get(ArrayList<?> list) {
		System.out.println("ArrayList");
	}
	
	public static void get(LinkedList<?> list) {
		System.out.println("LinkedList");
	}
	
	public static void main(String[] args) {
		List<?>[] listArray = { new ArrayList<>(), new LinkedList<>(), new Vector<>() };
		Arrays.stream(listArray).forEach(list -> get(list));
	}
}
