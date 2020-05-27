/**
* This interface models the Tree ADT. Much of the code comes  
* from Data Structures and Algorithms in Java, 6th Edition,
* by Goodrich, Tamassia, and Goldwasser.
*
* @author  Ian Boldea
* @version 1.0
* @since   May 23, 2020
*/

import java.util.Iterator;

public interface Tree<T> extends Iterable<T> {
  Position<T> root();
  Position<T> parent(Position<T> p) throws IllegalArgumentException;
  Iterable<Position<T>> children(Position<T> p) throws IllegalArgumentException;
  int numChildren(Position<T> p) throws IllegalArgumentException;
  boolean isInternal(Position<T> p) throws IllegalArgumentException;
  boolean isExternal(Position<T> p) throws IllegalArgumentException;
  boolean isRoot(Position<T> p) throws IllegalArgumentException  ;
  int size();
  boolean isEmpty();
  Iterator<T> iterator();
  Iterable<Position<T>> positions();
}