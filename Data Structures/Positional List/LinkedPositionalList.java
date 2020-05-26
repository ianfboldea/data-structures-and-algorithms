public class LinkedPositionalList<T> implements PositionalList<T> {
  private static class Node<T> implements Position<T> {
    private E element;
    private Node<E> prev;
    private Node<E> next;
    public Node(T data, Node<E> p, Node<E> n) {
      this.element = data;
      this.prev = p;
      this.next = n;
    }
    public T getElement() throws IllegalStateException {
      if (this.next == null)
        throw new IllegalStateException("Position no longer valid");
      return this.element;
    }
    public Node<T> getPrev() {
      return this.prev;
    }
    public Node<T> getNext() {
      return this.next;
    }
    public void setElement(T data) {
      this.element = data;
    }
    public void setPrev(Node<T> p) {
      this.prev = p;
    } 
    public void setNext(Node<T> n) {
      this.next = n;
    }
  }

  private Node<E> header;
  private Node<E> trailer;
  private int size = 0;

  public LinkedPositionalList() {
    this.header = new Node<>(null, null, null);
    this.trailer = new Node<>(null, this.header, null);
    this.header.setNext(this.trailer);
  }
}