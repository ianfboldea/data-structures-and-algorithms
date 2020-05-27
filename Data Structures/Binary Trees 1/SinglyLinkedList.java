/**
* This program models the behavior of the Singly Linked List
* data structure. Much of the code comes from 
* Data Structures and Algorithsm in Java, 6th Edition,
* by Goodrich, Tamassia, and Goldwasser
*
* @author  Ian Boldea
* @version 1.0
* @since   May 18, 2020
*/
public class SinglyLinkedList<E> {
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
  
  private Node<E> head = null, tail = null;
  private int size = 0;
  public int size() { return this.size; }
  public boolean isEmpty() { return this.size == 0; }
  public E first() {
    if (isEmpty()) return null;
    return head.getData();
  }
  public E last() {
    if (isEmpty()) return null;
    return tail.getData();
  }
  public void addFirst(E data) {
    this.head = new Node<>(data, this.head);
    if (this.size == 0) this.tail = this.head;
    this.size++;
  }
  public void addLast(E data) {
    Node<E> newNode = new Node<>(data, null);
    if (this.isEmpty())
      this.head = newNode;
    else
      this.tail.setNext(newNode);
    this.tail = newNode;
    this.size++;
  }
  public E removeFirst() {
    if (this.isEmpty()) return null;
    E answer = this.head.getData();
    this.head = this.head.getNext();
    this.size--;
    if (this.size == 0) {
      this.tail = null;
    }
    return answer;
  }
  public static void main(String[] args) {
    SinglyLinkedList<String> list = new SinglyLinkedList<>();
    list.addFirst("Ian");
    list.addLast("Boldea");
    System.out.println(list.first());
    System.out.println(list.last());
    list.removeFirst();
    System.out.println(list.first());
    System.out.println(list.last());
  }
}