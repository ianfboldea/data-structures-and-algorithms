/** An abstract base class providing some of the functionality 
 * for the Tree interface. Much of the code is from Data 
 * Structures and Algorithms in Java, 6th Edition,
 * by Goodrich, Tamassia, and Goldwasser.
 */
public abstract class AbstractTree<T> implements Tree<T> {
  // Initial simple methods
  public boolean isInternal(Position<T> p) { return numChildren(p) > 0; }
  public boolean isExternal(Position<T> p) { return numChildren(p) == 0; }
  public boolean isRoot(Position<T> p) { return p == root(); }
  public boolean isEmpty() { return size() == 0; }

  /** 
   * Returns the number of levels separating Position p from the 
   * root in O(n) worst case time
   *  */
  public int depth(Position<T> p) {
    if (isRoot(p))
      return 0;
    else
      return 1 + depth(parent(p));
  }

  /** Returns the height of the subtree rooted at position p
   * Runs in O(1) time
   */
  public int height(Position<T> p) {
    int h = 0;

    // Split the tree into subtrees until each subtree is on its 
    // base level, returning 1 + the method called on the subtree
    // for each level of depth the recursive method travels. 
    // Return whichever subtree has the highest height
    for (Position<T> c: children(p))
      h = Math.max(h, 1 + height(c));
    
    return h;
  }

  // Traversal algorithms

  // Preoder Traversal
  /** Private helper method that adds the positions of the subtree rooted at Position p to the given snapshot */
  private void preorderSubtree(Position<T> p, List<Position<T>> snapshot) {
    snapshot.add(p); // For preorder, we "visit" the root node first
    for (Position<T> c : children(p))
      preorderSubtree(c, snapshot);
  }
  /** Returns an iterable collection of positions of the tree, reported in preorder. */
  public Iterable<Position<T>> preoder() {
    List<Position<T>> snapshot = new ArrayList<>();
    if (!isEmpty())
      preorderSubtree(root(), snapshot);
    return snapshot;
  }

  // Postorder Traversal
  /** Private helper method that adds the positions of the subtree rooted at Position p to the given snapshot */
  private void postorderSubtree(Position<T> p, List<Position<T>> snapshot) {
    for (Position<T> c : children(p))
      postorderSubtree(c, snapshot);
    snapshot.add(p); // For postorder, we "visit" the root node last
  }
  /** Returns an iterable collection of positions of the tree, reported in postorder. */
  public Iterable<Position<T>> postorder() {
    List<Position<T>> snapshot = new ArrayList<>();
    if (!isEmpty())
      postorderSubtree(root(), snapshot);
    return snapshot;
  }

  /** Adaptable positions() method */
  public Iterable<Position<T>> positions() { return preorder(); }
}