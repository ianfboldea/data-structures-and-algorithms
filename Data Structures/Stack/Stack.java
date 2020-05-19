/**
* This interface models the Stack ADT. Much of the code comes  
* from Data Structures and Algorithsm in Java, 6th Edition,
* by Goodrich, Tamassia, and Goldwasser.
*
* @author  Ian Boldea
* @version 1.0
* @since   May 19, 2020
*/
public interface Stack<E> {
  /**
   * Returns the number of elements in the stack
   * @return number of elements in the stack
   */
  int size();

  /**
   * Tells whether the stack is empty or not
   * @return true if the stack is empty, false if not
   */
  boolean isEmpty();

  /**
   * Pushes a new piece of data onto the stack
   * @param data is the piece of data to be inserted
   */
  void push(E data);

  /**
   * Returns the element last pushed onto the stack
   * @return the element at the top of the stack
   */
  E top();

  /**
   * Removes and returns the last element pushed onto the stack
   * @return the element previously at the top of the stack
   */
  E pop();
}