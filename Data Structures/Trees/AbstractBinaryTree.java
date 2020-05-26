/** An abstract base class providing some of the functionality 
 * for the BinaryTree interface. Much of the code is from Data 
 * Structures and Algorithms in Java, 6th Edition,
 * by Goodrich, Tamassia, and Goldwasser.
 */
public abstract class AbstractBinaryTree<T> extends AbstractTree<T> implements BinaryTree<T> {
  /** Returns the Position of p's sibling (or null if no sibling exists). */
  public Positon<T> sibling(Position<T> p) {
    Positon<T> parent = parent(p);
    if (parent == null) return null; // p is the root
    if (p == left(parent))
      return right(parent);
    else
      return left(parent);
  }

  /** Returns the number of children of position p */
  public int numChildren(Positon<T> p) {
    int count = 0;
    if (left(p) != null)
      count++;
    if (right(p) != null)
      count++;
    return count;
  }

  /** Returns an iterable collection of the Positions representing p's children */
  public Iterable<Position<T>> children(Position<T> p) {
    List<Position<T>> snapshot = new ArrayList<>(2);
    
    if (left(p) != null)
      snapshot.add(left(p));
    if (right(p) != null)
      snapshot.add(right(p));

    return snapshot;
  }

  /** Returns the Position of p's left child (or null if no child exists). */
  public Positon<T> left(Position<T> p) {

  }
  /** Returns the Position of p's right child (or null if no child exists). */
  public Positon<T> right(Positon<T> p) {
    
  }
}