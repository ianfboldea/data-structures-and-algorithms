/**
* This class implements the BinaryTree ADT. Much of the code   
* comes from Data Structures and Algorithms in Java, 6th Edition,
* by Goodrich, Tamassia, and Goldwasser.
*
* @author  Ian Boldea
* @version 1.0
* @since   May 25, 2020
*/
public class LinkedBinaryTree<T> extends AbstractBinaryTree<T> {
  // We create this statically because we do not need to access
  // the outer class within the inner class. It is protected so 
  // that the class may be subclassed and still access the Node 
  // class.
  protected static class Node<T> implements Position<T> {
    // Instance variables
    private T data;
    private Node<T> parent;
    private Node<T> left;
    private Node<T> right;

    // Constructor
    public Node(T data, Node<T> parent, Node<T> left, Node<T> right) {
      this.data = data;
      this.parent = parent;
      this.left = left;
      this.right = right;
    }

    // Accessor Methods
    public T getElement() { return this.element; }
    public Node<T> getParent() { return this.parent; }
    public Node<T> getLeft() { return this.left; }
    public Node<T> getRight() { return this.right; }

    // Update Methods
    public void setElement(T data) { this.data = data; }
    public setParent(Node<T> parent) { this.parent = parent; }
    public setLeft(Node<T> left) { this.left = left; }
    public setRight(Node<T> right) { this.right = right; }
  }

  /** Factory function to create a new node storing element data */
  protected Node<T> createNode(T data, Node<T> parent, Node<T> left, Node<T> right) {
    return new Node<T>(data, parent, left, right);
  }

  // Instance variables
  protected Node<T> root = null;
  private int size = 0;

  // Constructor (not needed)
  public LinkedBinaryTree() {}

  // Non-public Utility Method
  /** 
   * Validates the position and returns the node at the position. */
  protected Node<T> validate(Positon<T> p) throws IllegalArgumentException {
    if (!(p instanceof Node))
      throw new IllegalArgumentException("Not a valid position type.");
    Node<T> node = (Node<T>)p; // safe cast
    if (node.getParent() == null) // convention for defunct node
      throw new IllegalArgumentException("Position no longer in the tree.");
    return node;
  }

  // Accessor Methods (in addition to the ones in the AbstractBinaryTree)
  /** Returns the number of nodes in the tree */
  public int size() { return this.size; }

  /** Returns the position of the root node (or null if tree is empty) */
  Position<T> root() { return this.root; }

  /** Return p's left child's position (or null if no child exists) */
  Position<T> left(Position<T> p) {
    Node<T> node = this.validate(p);
    return node.getLeft();
  }

  /** Return p's right child's position (or null if no child exists) */
  Position<T> right(Position<T> p) {
    Node<T> node = this.validate(p);
    return node.getRight();
  }

  // Update Methods Supported by this Class
  /** Places element data at the root of the list and returns its new Position */
  public Position<T> addRoot(T data) throws IllegalArgumentException {
    if (!this.isEmpty()) throw new IllegalArgumentException("Tree is not empty.");
    this.root = this.createNode(data, null, null, null);
    this.size = 1;
    return this.root;
  }

  /** Creates a new left child of Position p storing element data; returns its Position */
  public Position<T> addLeft(Position<T> p, T data) throws IllegalArgumentException {
    Node<T> parent = validate(p);
    if (parent.getLeft() != null)
      throw new IllegalArgumentException("Position already has a left child.");
    Node<T> child = this.createNode(data, parent, null, null);
    parent.setLeft(child);
    this.size++;
    return child;
  }

  /** Creates a new right child of Position p storing element data; returns its Position */
  public Position<T> addRight(Position<T> p, T data) throws IllegalArgumentException {
    Node<T> parent = validate(p);
    if (parent.getRight() != null)
      throw new IllegalArgumentException("Position already has a right child.");
    Node<T> child = this.createNode(data, parent, null, null);
    parent.setRight(child);
    this.size++;
    return child;
  }

  /** Replaces the element at Position p with data and returns the replaced element */
  public T set(Position<T> p, E data)throws IllegalArgumentException {
    Node<T> node = validate(p);
    E temp = node.getElement();
    node.setElement(data);
    return temp;
  }

  /** Attaches t1 and t2 as left and right subtrees of external p */
  public void attach(Position<T> p, LinkedBinaryTree<T> t1, LinkedBinaryTree<T> t2) throws IllegalArgumentException {
    Node<T> node = validate(p);
    if (isInternal(p)) throw new IllegalArgumentException("Position must be a leaf");
    this.size += t1.size() + t2.size();
    if (!t1.isEmpty()) {
      t1.root.setParent(node);
      node.setLeft(t1.root);
      // Free up t1 to be garbage collected
      t1.root = null;
      t1.size = 0;
    }
    if (!t2.isEmpty()) {
      t2.root.setParent(node);
      node.setRight(t2.root);
      // Free up t2 to be garbage collected
      t2.root = null;
      t2.size = 0;
    }
  }

  /** Removes the node at Position p and replaces it with its child, if any. */
  public T remove(Position<T> p) throws IllegalArgumentException {
    Node<T> node = validate(p);
    if (numChildren(p) == 2)
      throw new IllegalArgumentException("Position has two children");
    Node<T> child = (node.getLeft() == null ? node.getRight() : node.getLeft());
    if (child != null)
      child.setParent(node.getParent());
    if (node == this.root)
      this.root = child;
    else {
      Node<T> parent = node.getParent();
      if (node == parent.getLeft())
        parent.setLeft(child);
      else
        parent.setRight(child);
    }
    this.size--;
    T temp = node.getElement();
    node.setElement(null); // help garbage collection
    node.setLeft(null);
    node.setRight(null);
    node.setParent(node); // convention for defunct node
    return temp;
  }

  // Traversals

  /* This class adapts the iteration produced by positions() to return elements. */
  private class ElementIterator implements Iterator<T> {
    Iterator<Position<T>> posIterator = positions().iterator();
    public boolean hasNext() { return posIterator.hasNext(); }
    public T next() { return posIterator.next().getElement(); } // return element!
    public void remove() { posIterator.remove(); }
  }
  /** Returns an iterator of the elements stored in the tree. */
  public Iterator<T> iterator() { 
    return new ElementIterator(); 
  }
}