/**
* This program models the behavior of the Circularly Linked List
* data structure. Much of the code comes from 
* Data Structures and Algorithsm in Java, 6th Edition,
* by Goodrich, Tamassia, and Goldwasser
*
* @author  Ian Boldea
* @version 1.0
* @since   May 18, 2020
*/
public class CircularlyLinkedList<E> {
  /* This is a simple nested Node class that maintains a 
   next reference. */
   private static class Node<E> {
    private E data;
    private Node<E> next;
    public Node(E data, Node<E> next) {
      this.data = data;
      this.next = next;
    }
    public E getData() { return this.data; }
    public Node<E> getNext() { return this.next; }
    public void setNext(Node<E> next) { this.next = next; }
  }
  
  // Instance variables
  private Node<E> tail = null;
  private int size = 0;

  // Access methods
  public int size() { return this.size; }
  public boolean isEmpty() { return this.size == 0; }
  public E first() {
    if (this.isEmpty()) return null;
    return this.tail.getNext().getData(); 
  }
  public E last() { return this.tail.getData(); }

  // Update methods
  public void rotate() {
    if (this.tail != null)
      this.tail = this.tail.getNext();
  }
  public void addFirst(E data) {
    if (this.size == 0) {
      this.tail = new Node<>(data, null);
      this.tail.setNext(this.tail);
    } else {
      Node<E> newNode = new Node<>(data, this.tail.getNext());
      this.tail.setNext(newNode);
    }
    this.size++;
  }
  public void addLast(E data) {
    this.addFirst(data);
    this.tail = this.tail.getNext();
  }
  public E removeFirst() {
    if (this.isEmpty()) return null;
    Node<E> head = this.tail.getNext();
    if (head == this.tail) this.tail = null;
    else this.tail.setNext(head.getNext());
    this.size--;
    return head.getData();
  }
  public static void main(String[] args) {
    CircularlyLinkedList<String> list = new CircularlyLinkedList<>();
    list.addFirst("Ian");
    list.addLast("Boldea");
    System.out.println(list.first());
    System.out.println(list.last());
    list.rotate();
    System.out.println(list.first());
    System.out.println(list.last());
    list.removeFirst();
    System.out.println(list.first());
    System.out.println(list.last());
  }
}