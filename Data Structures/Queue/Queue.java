/**
* This interface models the Queue ADT. Much of the code comes  
* from Data Structures and Algorithms in Java, 6th Edition,
* by Goodrich, Tamassia, and Goldwasser.
*
* @author  Ian Boldea
* @version 1.0
* @since   May 19, 2020
*/
public interface Queue<E> {
  /** Returns the number of elements in the queue. */
  int size();
  /** Tests whether the queue is empty. */
  boolean isEmpty();
  /** Inserts an element at the rear of the queue */
  void enqueue(E data);
  /** Returns, but does not remove, the first element of the queue (null if empty) */
  E first();
  /** Returns and removes the first element of the queue (null if empty) */
  E dequeue();
}