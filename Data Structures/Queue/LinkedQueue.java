/**
* This is a SLL based implementation of the queue ADT.
* Much of the information on implmementation came
* from Data Structures and Algorithms in Java, 6th Edition,
* by Goodrich, Tamassia, and Goldwasser.
*
* @author  Ian Boldea
* @version 1.0
* @since   May 20, 2020
*/
public class LinkedQueue<T> implements Queue<T> {
  private SinglyLinkedList<T> list = new SinglyLinkedList<>();
  public int size() { return list.size(); }
  public boolean isEmpty() { return list.isEmpty(); }
  public void enqueue(T data) { list.addLast(data); }
  public T first() { return list.first(); }
  public T dequeue() { return list.removeFirst(); }
  public static void main(String[] args) {
    LinkedQueue<String> queue = new LinkedQueue<>();
    queue.enqueue("Oldest");
    queue.enqueue("Middle");
    queue.enqueue("Youngest");
    while (queue.size() > 0) {
      System.out.println(queue.dequeue());
    }
  }
}