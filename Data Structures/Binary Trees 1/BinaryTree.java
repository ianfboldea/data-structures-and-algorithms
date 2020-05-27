/**
* This interface models the Binary Tree ADT. Much of the code   
* comes from Data Structures and Algorithms in Java, 6th Edition,
* by Goodrich, Tamassia, and Goldwasser.
*
* @author  Ian Boldea
* @version 1.0
* @since   May 23, 2020
*/
public interface BinaryTree<T> extends Tree<T> {
  /** Returns the Position of p's left child (or null if no child exists). */
  Position<T> left(Position<T> p) throws IllegalArgumentException;
  /** Returns the Position of p's right child (or null if no child exists). */
  Position<T> right(Position<T> p) throws IllegalArgumentException;
  /** Returns the Position of p's sibling (or null if no sibling exists). */
  Position<T> sibling(Position<T> p) throws IllegalArgumentException; 
}