public interface PositionalList<T> {
  /** Returns the position the first element of the list
   * (or null if empty) 
  */
  Position<T> first();
  /** Returns the position of the last element of the list
   * (or null if empty) 
  */
  Position<T> last();
  /** Returns the position of the element before p
   * (or null if p is the first position) 
  */
  Position<T> before(Position<T> p) throws IllegalStateException;
  /** Returns the position of the element after p
   * (or null if p is the last position) 
  */
  Position<T> after(Position<T> p) throws IllegalStateException;
  /** Adds element data at the first position of the list, 
   * returning the position of the new element
   */
  Position<T> addFirst(T data);
  /** Adds element data at the last position of the list, 
   * returning the position of the new element */
  Position<T> addLast(T data);
  /** Adds element data before position p of the list, 
   * returning the position of the new element */
  Position<T> addBefore(Position<T> p, T data) throws IllegalStateException;
  /** Adds element data after position p of the list, 
   * returning the position of the new element */
  Position<T> addAfter(Position<T> p, T data) throws IllegalStateException;
  /** Inserts element data at position p of the list, returning
   * the element formerly at position p
   */
  T set(Position<T> p, T data) throws IllegalStateException;
  /** Returns and removes data at position p of the list,
   * invalidating position p
   */
  T remove(Position<T> p) throws IllegalStateException;
  /** Returns whether the list is empty or not */
  boolean isEmpty();
  /** Returns the size of the list */
  int size();
}