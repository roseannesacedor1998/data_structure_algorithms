package linkedlist;

import linkedlist.SingularlyLinkedList;

public class boxer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingularlyLinkedList<String> boxers= new SingularlyLinkedList <String>();
		
		boxers.addFirst("Abrigo");
		boxers.addFirst("Tadea");
		boxers.addFirst("Torlao");
		boxers.addFirst("Mediana");
		
		System.out.println("size : " + boxers.size());
		
	}

}
 