/**
* This is an array based implementation of the queue ADT.
* Much of the information on implmementation came
* from Data Structures and Algorithms in Java, 6th Edition,
* by Goodrich, Tamassia, and Goldwasser.
*
* @author  Ian Boldea
* @version 1.0
* @since   May 20, 2020
*/
public class ArrayQueue<T> implements Queue<T> {
  public static int CAPACITY = 10; // default capacity
  // Instance variables
  private T[] data;
  private int f = 0; //index of the front element
  private int sz = 0;

  // Constructors
  public ArrayQueue() { this(CAPACITY); }
  public ArrayQueue(int capacity) {
    this.data = (T[]) new Object[capacity];
  }

  // Methods
  /**
   * Returns the size of the queue
   * @return the number of elements in the queue
   */
  public int size() { return this.sz; }
  /**
   * Returns whether the queue is empty or not
   * @return true if the queue is empty, false otherwise
   */
  public boolean isEmpty() { return this.sz == 0; }
  /**
   * Adds an element to the queue
   * @param data to add to the queue
   * @throws IllegalStateException if queue is full
   */
  public void enqueue(T data) throws IllegalStateException {
    if (this.sz == this.data.length) throw new IllegalStateException("Queue is full.");
    // We can incremement size in the same line, since we are adding an element
    int avail = (this.f + this.sz++)%this.data.length;
    this.data[avail] = data;
  }
  /**
   * Returns the first element added element to the queue
   * @return the first element in the queue
   */
  public T first() {
    if (this.isEmpty()) return null;
    return this.data[this.f];
  }
  /**
   * Returns and removes the first element added to the queue
   * @return the old first element in the queue
   */
  public T dequeue() {
    if (this.isEmpty()) return null;
    T answer = this.data[this.f];
    this.data[this.f] = null;
    this.f = (this.f + 1)%this.data.length;
    this.sz--;
    return answer;
  }
  public static void main(String[] args) {
    ArrayQueue<String> queue = new ArrayQueue<>();
    queue.enqueue("Oldest");
    queue.enqueue("Middle");
    queue.enqueue("Youngest");
    while (queue.size() > 0) {
      System.out.println(queue.dequeue());
    }
  }
}