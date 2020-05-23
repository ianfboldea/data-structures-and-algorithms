/**
* This interface models the Deque ADT. Much of the code comes  
* from Data Structures and Algorithms in Java, 6th Edition,
* by Goodrich, Tamassia, and Goldwasser.
*
* @author  Ian Boldea
* @version 1.0
* @since   May 21, 2020
*/
public interface Deque<T> {
  /** Returns the number of elements in the dequeue */
  int size();
  /** Returns whether the dequeue is empty or not */
  boolean isEmpty();
  /** Returns the first element of the dequeue (null if empty) */
  T first();
  /** Returns the last element of the dequeue (null if empty) */
  T last();
  /** Adds an element to the front of the dequeue */
  void addFirst(T data);
  /** Adds an element to the back of the dequeue */
  void addLast(T data);
  /** Returns and removes the first element of the dequeue (null if empty) */
  T removeFirst();
  /** Returns and removes the last element of the dequeue (null if empty) */
  T removeLast();
}