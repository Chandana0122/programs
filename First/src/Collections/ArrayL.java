package Collections;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> array = new ArrayList<>();
		ArrayList<Integer> a1 = new ArrayList<>(Arrays.asList(1,2,3));
		array.add(10);
		array.add(20);
		array.add(30);
		array.add(40);
		array.add(2, 90);
		array.addFirst(5);
		array.addLast(100);
		array.addAll(a1);
		
		System.out.println("The array items are: " + array);
		array.remove(1);
		
		System.out.println("After removing the array elements are: " + array);
		

	}

}
