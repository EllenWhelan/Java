
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author  Ellen Whelan
 *  @version 09/10/18 11:13:22
 */

/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 * 
 * @param <T>
 *            This is a type parameter. T is used as a class name in the
 *            definition of this class.
 *
 *            When creating a new DoublyLinkedList, T should be instantiated
 *            with an actual class name that extends the class Comparable. Such
 *            classes include String and Integer.
 *
 *            For example to create a new DoublyLinkedList class containing
 *            String data: DoublyLinkedList<String> myStringList = new
 *            DoublyLinkedList<String>();
 *
 *            The class offers a toString() method which returns a
 *            comma-separated sting of all elements in the data structure.
 * 
 *            This is a bare minimum class you would need to completely
 *            implement. You can add additional methods to support your code.
 *            Each method will need to be tested by your jUnit tests -- for
 *            simplicity in jUnit testing introduce only public methods.
 */
class DoublyLinkedList<T extends Comparable<T>> {

	/**
	 * private class DLLNode: implements a *generic* Doubly Linked List node.
	 */
	private class DLLNode {
		public final T data; // this field should never be updated. It gets its
								// value once from the constructor DLLNode.
		public DLLNode next;
		public DLLNode prev;

		/**
		 * Constructor
		 * 
		 * @param theData
		 *            : data of type T, to be stored in the node
		 * @param prevNode
		 *            : the previous Node in the Doubly Linked List
		 * @param nextNode
		 *            : the next Node in the Doubly Linked List
		 * @return DLLNode
		 */
		public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode) {
			data = theData;
			prev = prevNode;
			next = nextNode;
		}
	}

	// Fields head and tail point to the first and last nodes of the list.
	private DLLNode head, tail;

	/**
	 * Constructor of an empty DLL
	 * 
	 * @return DoublyLinkedList
	 */
	public DoublyLinkedList() {
		head = null;
		tail = null;
	}

	/**
	 * Tests if the doubly linked list is empty
	 * 
	 * @return true if list is empty, and false otherwise
	 *
	 *         Worst-case asymptotic running time cost: Theta(1)
	 *
	 *         Justification: This fution/method has an asymptotic running time of
	 *         theta(1) which is a constant running time. There is no looping or
	 *         iteration in this function, therefore it has a constant running time.
	 */
	public boolean isEmpty() {
		if (this.head == null && this.tail == null)
			return true;
		else
			return false;

	}

	/**
	 * Inserts an element in the doubly linked list
	 * 
	 * @param pos
	 *            : The integer location at which the new data should be inserted in
	 *            the list. We assume that the first position in the list is 0
	 *            (zero). If pos is less than 0 then add to the head of the list. If
	 *            pos is greater or equal to the size of the list then add the
	 *            element at the end of the list.
	 * @param data
	 *            : The new data of class T that needs to be added to the list
	 * @return none
	 *
	 *         Worst-case asymptotic running time cost: Theta(N)
	 *
	 *         Justification: The first if and else if statements have a asymptotic
	 *         run time worst case of theta(1) and the third has a while loop
	 *         meaning a linear worst case run time of N. We add these together and
	 *         by the properties of asymptotic notation addition only keep the
	 *         highest order terms i.e. N in this case
	 */
	public void insertBefore(int pos, T data) {
		if (!isEmpty()) {
			if (pos <= 0) {// making new head
				DLLNode newHeadNode = new DLLNode(data, null, null); // creates new node with no pointers
				this.head.prev = newHeadNode;
				newHeadNode.next = this.head;
				this.head = newHeadNode;
			} else if (pos >= sizeOfList()) {// making new tail
				DLLNode newTailNode = new DLLNode(data, null, null);
				this.tail.next = newTailNode;
				newTailNode.prev = this.tail;
				this.tail = newTailNode;
			} else {// somewhere in middle of list
				int i = 0;
				DLLNode tempNode = this.head;
				while (i < pos) {
					tempNode = tempNode.next;
					i++;
				}
				DLLNode newNode = new DLLNode(data, tempNode.prev, tempNode);
				tempNode.prev.next = newNode;
				tempNode.prev = newNode;
			}
		} else {
			DLLNode newNode = new DLLNode(data, null, null);
			this.tail = newNode;
			this.head = newNode;
		}
	}

	/**
	 * Returns the data stored at a particular position
	 * 
	 * @param pos
	 *            : the position
	 * @return the data at pos, if pos is within the bounds of the list, and null
	 *         otherwise.
	 *
	 *         Worst-case asymptotic running time cost: Theta(N)
	 *
	 *         Justification: The outer if else statement has a constant running
	 *         times of theta(1) as constant coefficients are always equal to 1 in
	 *         asymptotic notation. The fist two if and else if have worst case
	 *         constant running times theta(1), as constant coefficients are equal
	 *         to 1 in asymptotic notation the third else has a while loop iteration
	 *         giving it a linear run time. In the worst case the loop would iterate
	 *         through the entirety of the list giving it an asymptotic run time of
	 *         theta(N). By the properties of asymptotic notation addition we only
	 *         count the highest order term so when we add
	 *         theta(1)+theta(1)+theta(N) we only keep theta(N).
	 *
	 */
	public T get(int pos) {
		if (!isEmpty()) {
			if (pos >= sizeOfList())
				return null;
			else if (pos < 0)
				return null;
			else {
				DLLNode tempNode = this.head;
				int i = 0;
				while (i < pos) {
					tempNode = tempNode.next;
					i++;
				}
				return tempNode.data;
			}
		} else
			return null;
	}

	/**
	 * Deletes the element of the list at position pos. First element in the list
	 * has position 0. If pos points outside the elements of the list then no
	 * modification happens to the list.
	 * 
	 * @param pos
	 *            : the position to delete in the list.
	 * @return true : on successful deletion, false : list has not been modified.
	 *
	 *         Worst-case asymptotic running time cost: Theta(N)
	 *
	 *         Justification: The if statement contains assignments which have a
	 *         constant run time of theta(1) as constant coefficients are equal to 1
	 *         in asymptotic notation and a while loop with worst case asymptotic
	 *         run time of theta(N) as in the worst case it may iterate through the
	 *         entire list. When we add these we keep only the highest order term ie
	 *         N
	 */
	public boolean deleteAt(int pos) {
		if (!isEmpty()) {
			if (pos >= 0 && pos < sizeOfList()) {// pos within list
				int i = 0;
				DLLNode tempNode = head;
				while (i < pos) {
					tempNode = tempNode.next;
					i++;
				}
				if(tempNode.prev!=null && tempNode.next!=null) { //at least three elem in list
					tempNode.prev.next = tempNode.next;
					tempNode.next.prev = tempNode.prev;
					return true;
				}
				else if(sizeOfList()==2) {//2 elem list 
					if(tempNode.next==null) {//the item is second in list
						tempNode.prev.next=null;
						tail=head;
					}
					else if (tempNode.prev==null){//item is head
						head=tempNode.next;
						head.prev=null;
						head.next=null;
						tail=head;
						
					}
					return true;
				}
				else {//list is being emptied as only one element 
					head=null;
					tail=null;
					return true;
				}

			} else
				return false;
		} else
			return false;
	}

	/**
	 * Reverses the list. If the list contains "A", "B", "C", "D" before the method
	 * is called Then it should contain "D", "C", "B", "A" after it returns.
	 *
	 * Worst-case asymptotic running time cost: Theta(N)
	 *
	 * Justification: The assignments in this function are all constant running
	 * times as constant coefficients are equal to 1 in asymptotic notation and have
	 * an asymptotic run time of theta(1). The while loop has an worst case
	 * asymptotic run time of N. By the properties of asymptotic notation addition
	 * we only keep the highest order term hence this function has an asymptotic run
	 * time of theta(N)
	 */
	public void reverse() {
		DLLNode tempNode = null;
		DLLNode currentNode = head;

		// swap next and prev for all nodes of doubly linked list
		while (currentNode != null) {
			tempNode = currentNode.prev;
			currentNode.prev = currentNode.next;
			currentNode.next = tempNode;
			currentNode = currentNode.prev;
		}

		// Before changing head, check for the cases like empty list and list with only
		// one node
		if (tempNode != null) {
			head = tempNode.prev;
		}

	}

	/**
	 * Removes all duplicate elements from the list. The method should remove the
	 * _least_number_ of elements to make all elements uniqueue. If the list
	 * contains "A", "B", "C", "B", "D", "A" before the method is called Then it
	 * should contain "A", "B", "C", "D" after it returns. The relative order of
	 * elements in the resulting list should be the same as the starting list.
	 *
	 * Worst-case asymptotic running time cost: Theta(N^2)
	 *
	 * Justification: There is a nested for loop in this function. Each for loop has
	 * an asymptotic linear run time of theta(N). We multiply the N by N as the for
	 * loops are nested to get worst case asymptotic run time of theta(N^2) for the
	 * function.
	 */
	public void makeUnique(){
		if (!isEmpty()) {
			DLLNode tempNode = head;
			DLLNode tempNode2 = null;
			T data = null;
			T data2 = null;
			for (int i = 0; i < sizeOfList(); i++) {
				tempNode2 = head;
				data = tempNode.data;
				for (int j = 0; j < sizeOfList(); j++) {
					data2 = tempNode2.data;
					if (data == data2 && i != j) {
						tempNode2.prev.next = tempNode2.next;
						if (tempNode2.next != null) {
							tempNode2.next.prev = tempNode2.prev;
						}
					}
					tempNode2 = tempNode2.next;
				}
				tempNode = tempNode.next;
			}
		}
	}

	/**
	 * Finds size of list returns int of size of list
	 * 
	 * Worst-case asymptotic running time cost:Theta(N)
	 * 
	 * Justification: The first if branch has a constant asymptotic run time of
	 * theta(1) and the else has an asymptotic run time of theta(N) as the while
	 * loop has a linear run time. As we only keep the highest order term the
	 * asymptotic run time for the fucntion is theta(N)
	 */
	public int sizeOfList() {
		if (head == null && tail == null)
			return 0; // list is empty
		else {
			int i = 1;
			DLLNode tempNode = this.head;
			while (tempNode.next != null) {
				i++;
				tempNode = tempNode.next;
			}
			return i;
		}
	}

	/*----------------------- STACK API 
	 * If only the push and pop methods are called the data structure should behave like a stack.
	 */

	/**
	 * This method adds an element to the data structure. How exactly this will be
	 * represented in the Doubly Linked List is up to the programmer.
	 * 
	 * @param item
	 *            : the item to push on the stack
	 *
	 *            Worst-case asymptotic running time cost: Theta(1)
	 *
	 *            Justification: This function contains only assignments and
	 *            therefore has a constant running time of theta(1) as constant
	 *            coefficients are equal to 1 in asymptotic notation
	 */
	public void push(T item) {
		DLLNode newNode = new DLLNode(item, null, head);
		if (!isEmpty()) {
			this.head.prev = newNode;
			head = newNode;
		} else {
			head = newNode;
		}

	}

	/**
	 * This method returns and removes the element that was most recently added by
	 * the push method.
	 * 
	 * @return the last item inserted with a push; or null when the list is empty.
	 *
	 *         Worst-case asymptotic running time cost: Theta(1)
	 *
	 *         Justification: The function contains only assignments all of which
	 *         have a constant run time and as constant coefficients are equal to 1
	 *         in asymptotic notation the worst case asymptotic run time for this
	 *         function is theta(1)
	 */
	public T pop() {
		if (!isEmpty()) {// make sure list not empty
			T returnData = head.data;
			if (head.next != null)
				head = head.next; // not just one element
			else {//one elem
				head = null;
				tail = null;
			}
			return returnData;
		} 
		else return null;
			
	}

	/*----------------------- QUEUE API
	 * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
	 */

	/**
	 * This method adds an element to the data structure. How exactly this will be
	 * represented in the Doubly Linked List is up to the programmer.
	 * 
	 * @param item
	 *            : the item to be enqueued to the stack
	 *
	 *            Worst-case asymptotic running time cost: theta(1)
	 *
	 *            Justification: This function contains only assignments and
	 *            therefore has a constant running time of theta(1) as constant
	 *            coefficients are equal to 1 in asymptotic notation
	 */
	public void enqueue(T item) {
		DLLNode newNode = new DLLNode(item, tail, null);
		if (!isEmpty()) {
			tail.next = newNode;
			tail = newNode;
		} else {
			head = newNode;
			tail = newNode;
		}
	}

	/**
	 * This method returns and removes the element that was least recently added by
	 * the enqueue method.
	 * 
	 * @return the earliest item inserted with an equeue; or null when the list is
	 *         empty.
	 *
	 *         Worst-case asymptotic running time cost: Theta(1)
	 *
	 *         Justification: The function contains only assignments all of which
	 *         have a constant run time and as constant coefficients are equal to 1
	 *         in asymptotic notation the worst case asymptotic run time for this
	 *         function is theta(1)
	 */
	public T dequeue() {
		if (head != null && tail != null) {// make sure list is non empty
			T returnData = head.data;
			if (head.next != null) { // not just one element
				head.next.prev = null;
				head = head.next;
			} else {//one element list 
				head = null;
				tail = null;
			}
			return returnData;
		} else
			return null;
	}

	/**
	 * @return a string with the elements of the list as a comma-separated list,
	 *         from beginning to end
	 *
	 *         Worst-case asymptotic running time cost: Theta(n)
	 *
	 *         Justification: We know from the Java documentation that
	 *         StringBuilder's append() method runs in Theta(1) asymptotic time. We
	 *         assume all other method calls here (e.g., the iterator methods above,
	 *         and the toString method) will execute in Theta(1) time. Thus, every
	 *         one iteration of the for-loop will have cost Theta(1). Suppose the
	 *         doubly-linked list has 'n' elements. The for-loop will always iterate
	 *         over all n elements of the list, and therefore the total cost of this
	 *         method will be n*Theta(1) = Theta(n).
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		boolean isFirst = true;

		// iterate over the list, starting from the head
		for (DLLNode iter = head; iter != null; iter = iter.next) {
			if (!isFirst) {
				s.append(",");
			} else {
				isFirst = false;
			}
			s.append(iter.data.toString());
		}

		return s.toString();
	}

}
