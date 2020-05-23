/**
* This is a LinkedList based implementation of the deque ADT.
* Much of the information on implmementation came
* from Data Structures and Algorithms in Java, 6th Edition,
* by Goodrich, Tamassia, and Goldwasser.
*
* @author  Ian Boldea
* @version 1.0
* @since   May 22, 2020
*/
public class LinkedDeque<T> implements Deque<T> {
  DoublyLinkedList<T> list = new DoublyLinkedList<>();
  /** Returns the number of elements in the dequeue */
  public int size() { return list.size(); }
  /** Returns whether the dequeue is empty or not */
  public boolean isEmpty() { return list.isEmpty(); }
  /** Returns the first element of the dequeue (null if empty) */
  public T first() { return list.first(); }
  /** Returns the last element of the dequeue (null if empty) */
  public T last() { return list.last(); }
  /** Adds an element to the front of the dequeue */
  public void addFirst(T data) { list.addFirst(data); }
  /** Adds an element to the back of the dequeue */
  public void addLast(T data) { list.addLast(data); }
  /** Returns and removes the first element of the dequeue (null if empty) */
  public T removeFirst() { return list.removeFirst(); }
  /** Returns and removes the last element of the dequeue (null if empty) */
  public T removeLast() { return list.removeLast(); }

  public static void main(String[] args) {
    LinkedDeque<String> deque = new LinkedDeque<>();

    deque.addFirst("Ian");
    deque.addLast("Francis");
    deque.addLast("Boldea");

    System.out.println(deque.removeFirst() + " " + deque.removeLast());
    System.out.println(deque.first() + " " + deque.last());
  }
}