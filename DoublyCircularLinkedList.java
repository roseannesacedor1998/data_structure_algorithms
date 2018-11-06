package linkedlist;

public class DoublyCircularLinkedList<E> {
	// ---------------- nested Node class ----------------
	private static class Node<E> {
		private E element; // reference to the element stored at this node
		private Node<E> prev; // reference to the previous node in the list
		private Node<E> next; // reference to the subsequent node in the list

		public Node(E e, Node<E> p, Node<E> n) {
			element = e;
			prev = p;
			next = n;
		}

		public E getElement() {
			return element;
		}

		public Node<E> getPrev() {
			return prev;
		}

		public Node<E> getNext() {
			return next;
		}

		public void setPrev(Node<E> p) {
			prev = p;
		}

		public void setNext(Node<E> n) {
			next = n;
		}
	} // ----------- end of nested Node class -----------

	// instance variables of the DoublyLinkedList
	private Node<E> tail; // trailer sentinel
	private int size = 0; // number of elements in the list

	/** Constructs a new empty list. */
	public DoublyCircularLinkedList() {
	}

	/** Returns the number of elements in the linked list. */
	public int size() {
		return size;
	}

	/** Tests whether the linked list is empty. */
	public boolean isEmpty() {
		return size == 0;
	}

	/** Returns (but does not remove) the first element of the list. */
	public E first() {
		if (isEmpty())
			return null;
		return tail.getNext().getElement(); // first element is beyond header
	}

	/** Returns (but does not remove) the last element of the list. */
	public E last() {
		if (isEmpty())
			return null;
		return tail.getElement(); // last element is before trailer
	}

	// public update methods
	public void rotate() { // rotate the first element to the back of the list
		if (tail != null) // if empty, do nothing
			tail = tail.getNext(); // the old head becomes the new tail
	}

	public void rotateBackwards() { //
		if (tail != null) // if empty, do nothing
			tail = tail.getPrev(); //
	}

	/** Adds element e to the front of the list. */
	public void addFirst(E e) {
		if (isEmpty()) {
			tail = new Node<E>(e, null, null);
			tail.setNext(tail);
			tail.setPrev(tail);
			size++;
		}
		else
			addBetween(e, tail, tail.getNext());
	}

	/** Adds element e to the end of the list. */
	public void addLast(E e) {
		addFirst(e); // insert new element at front of list
		tail = tail.getNext(); // now new element becomes the tail
	}

	/** Removes and returns the first element of the list. */
	public E removeFirst() {
		if (isEmpty())
			return null; // nothing to remove
		return remove(tail.getNext());
	}

	/** Removes and returns the last element of the list. */
	public E removeLast() {
		if (isEmpty())
			return null; // nothing to remove
		remove(tail);
		E element = tail.getElement();
		tail = tail.getPrev();
		return element;
	}

	// private update methods
	/** Adds element e to the linked list in between the given nodes. */
	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		// create and link a new node
		Node<E> newest = new Node<>(e, predecessor, successor);
		predecessor.setNext(newest);
		successor.setPrev(newest);
		size++;
	}

	/** Removes the given node from the list and returns its element. */
	private E remove(Node<E> node) {
		Node<E> predecessor = node.getPrev();
		Node<E> successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;
		return node.getElement();
	}
}
