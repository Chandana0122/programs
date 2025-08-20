package Collections;

import java.util.HashMap;

public class HashM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "karnataka");
		map.put(2, "kerala");
		map.put(3,"hyderbad");
		System.out.println("the list is : " + map);
		
		HashMap<Integer, String> map1 = new HashMap<>() {{
			put(1,"apple");
			put(2,"orange");
			put(3,"grapes");
		}
			
		};
		System.out.println("the list is: " + map1);

	}

}
