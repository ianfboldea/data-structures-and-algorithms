/** An abstract base class providing some of the functionality 
 * for the BinaryTree interface. Much of the code is from Data 
 * Structures and Algorithms in Java, 6th Edition,
 * by Goodrich, Tamassia, and Goldwasser.
 */

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBinaryTree<T> extends AbstractTree<T> implements BinaryTree<T> {
  /** Returns the Position of p's sibling (or null if no sibling exists). */
  public Position<T> sibling(Position<T> p) {
    Position<T> parent = parent(p);
    if (parent == null) return null; // p is the root
    if (p == left(parent))
      return right(parent);
    else
      return left(parent);
  }

  /** Returns the number of children of position p */
  public int numChildren(Position<T> p) {
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

  /** Returns an iterable collection of the positions in breadthFirst order */
  public Iterable<Position<T>> breadthFirst() {
    List<Position<T>> snapshot = new ArrayList<>();
    if (!isEmpty()) {
      Queue<Position<T>> fringe = new LinkedQueue<>();
      fringe.enqueue(root());
      while (!fringe.isEmpty()) {
        Position<T> p = fringe.dequeue();
        snapshot.add(p);
        for (Position<T> c : children(p))
          fringe.enqueue(c);
      }
    }
    return snapshot;
  }

  /** Private helper method that adds positions of the subtree rooted at Position p to the given snapshot */
  private void inorderSubtree(Position<T> p, List<Position<T>> snapshot) {
    if (left(p) != null)
      inorderSubtree(left(p), snapshot);
    snapshot.add(p);
    if (right(p) != null)
      inorderSubtree(right(p), snapshot);
  }
  /** Returns an iterable collection of the positions of the tree in reported in inorder */
  public Iterable<Position<T>> inorder() {
    List<Position<T>> snapshot = new ArrayList<>();
    if (!isEmpty())
      inorderSubtree(root(), snapshot);
    return snapshot;
  }

  /** Adaptable positions() method (overriding the one in AbstractTree to make inorder the default for binary trees) */
  public Iterable<Position<T>> positions() { return inorder(); }
}