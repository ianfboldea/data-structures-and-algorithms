/**
* This program models the behavior of the Doubly Linked List
* data structure. Much of the code comes from 
* Data Structures and Algorithsm in Java, 6th Edition,
* by Goodrich, Tamassia, and Goldwasser
*
* @author  Ian Boldea
* @version 1.0
* @since   May 18, 2020
*/
public class DoublyLinkedList<E> {
  /* This is a simple nested Node class that maintains a 
   next and a previous reference. */
  private static class Node<E> {
    private E data;
    private Node<E> previous;
    private Node<E> next;
    public Node(E data, Node<E> previous, Node<E> next) {
      this.data = data;
      this.previous = previous;
      this.next = next;
    }
    public E getData() { return this.data; }
    public Node<E> getPrevious() { return this.previous; }
    public Node<E> getNext() { return this.next; }
    public void setPrevious(Node<E> previous) { this.previous = previous; }
    public void setNext(Node<E> next) { this.next = next; }
  }
  
  private Node<E> header;
  private Node<E> trailer;
  private int size = 0;
  /** Constructs a new empty list w/ header and trailer */
  public DoublyLinkedList() {
    this.header = new Node<>(null, null, null);
    this.trailer = new Node<>(null, this.header, null);
    this.header.setNext(this.trailer);
  }
  // Accessor Methods
  /** Returns the number of elements in the list */
  public int size() { return this.size; }
  /** Returns whether the list is empty or not */
  public boolean isEmpty() { return this.size == 0; }
  /** Fetches the first element of the lsit */
  public E first() {
    if (isEmpty()) return null;
    return this.header.getNext().getData();
  }
  /** Fetches the last element of the list */
  public E last() {
    if (isEmpty()) return null;
    return this.trailer.getPrevious().getData();
  }
  // Public Update Methods
  /** Adds element data to the front of the list */
  public void addFirst(E data) {
    this.addBetween(data, this.header, this.header.getNext());
  }
  /** Adds element data to the back of the list */
  public void addLast(E data) {
    this.addBetween(data, this.trailer.getPrevious(), this.trailer);
  }
  /** Removes and returns the first element of the list */
  public E removeFirst() {
    if (this.isEmpty()) return null;
    return remove(this.header.getNext());
  }
  /** Removes and returns the last element of the list */
  public E removeLast() {
    if (this.isEmpty()) return null;
    return remove(this.trailer.getPrevious());
  }
  // Private Update Methods
  /** Adds element data to the linked list in between the given nodes. */
  private void addBetween(E data, Node<E> predecessor, Node<E> successor) {
    Node<E> newNode = new Node<>(data, predecessor, successor);
    predecessor.setNext(newNode);
    successor.setPrevious(newNode);
    this.size++;
  }
  /** Removes the given node from the list and returns its element. */
  private E remove(Node<E> node) {
    Node<E> predecessor = node.getPrevious();
    Node<E> successor = node.getNext();
    predecessor.setNext(successor);
    successor.setPrevious(predecessor);
    this.size--;
    return node.getData();
  }

  public static void main(String[] args) {
    DoublyLinkedList<String> list = new DoublyLinkedList<>();
    list.addFirst("Ian");
    list.addLast("Boldea");
    System.out.println(list.first());
    System.out.println(list.last());
    list.removeFirst();
    System.out.println(list.first());
    System.out.println(list.last());
  }
}