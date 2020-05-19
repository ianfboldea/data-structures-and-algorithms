public class LinkedStack<E> implements Stack<E> {
  private SinglyLinkedList<E> list = new SinglyLinkedList<>();
  public int size() { return this.list.size(); }
  public boolean isEmpty() { return this.list.isEmpty(); }
  public void push(E data) { this.list.addFirst(data); }
  public E top() { return this.list.first(); }
  public E pop() { return this.list.removeFirst(); }
  public static void main(String[] args) {
    // Main method provided by textbook listed in interface header
    Stack<Integer> S = new LinkedStack<>(); 
    S.push(5); 
    S.push(3);
    System.out.println(S.size());
    System.out.println(S.pop());
    System.out.println(S.isEmpty());
    System.out.println(S.pop());
    System.out.println(S.isEmpty());
    System.out.println(S.pop());
    S.push(7);
    S.push(9);
    System.out.println(S.top());
    S.push(4);
    System.out.println(S.size());
    System.out.println(S.pop());
    S.push(6);
    S.push(8);
    System.out.println(S.pop());
  }
}