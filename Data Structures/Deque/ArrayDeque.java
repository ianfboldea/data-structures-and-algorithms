/**
* This is an array based implementation of the deque ADT.
* Much of the information on implmementation came
* from Data Structures and Algorithms in Java, 6th Edition,
* by Goodrich, Tamassia, and Goldwasser.
*
* @author  Ian Boldea
* @version 1.0
* @since   May 22, 2020
*/
public class ArrayDeque<T> implements Deque<T> {
  public static int CAPACITY = 10; // default capacity
  // Instance variables
  private T[] data;
  private int f = 0; //index of the front element
  private int sz = 0;

  // Constructors
  public ArrayDeque() { this(CAPACITY); }
  public ArrayDeque(int capacity) {
    this.data = (T[]) new Object[capacity];
  }

  // Methods
  /**
   * Returns the size of the Deque
   * @return the number of elements in the Deque
   */
  public int size() { return this.sz; }
  /**
   * Returns whether the Deque is empty or not
   * @return true if the Deque is empty, false otherwise
   */
  public boolean isEmpty() { return this.sz == 0; }
  /**
   * Adds an element to front of the Deque
   * @param data to add to the Deque
   * @throws IllegalStateException if Deque is full
   */
  public void addFirst(T data) throws IllegalStateException {
    if (this.sz == this.data.length) throw new IllegalStateException("Deque is full.");
    // We can incremement size in the same line, since we are adding an element
    this.f = (this.f - 1 + this.data.length)%this.data.length;
    this.data[this.f] = data;
    this.sz++;
  }
  /**
   * Adds an element to back of the Deque
   * @param data to add to the Deque
   * @throws IllegalStateException if Deque is full
   */
  public void addLast(T data) throws IllegalStateException {
    if (this.sz == this.data.length) throw new IllegalStateException("Deque is full.");
    int avail = (this.f + this.sz)%this.data.length;
    this.sz++;
    this.data[avail] = data;
  }
  /**
   * Returns the first element added element to the Deque
   * @return the first element in the Deque
   */
  public T first() {
    if (this.isEmpty()) return null;
    return this.data[this.f];
  }
  /**
   * Returns the last element added element to the Deque
   * @return the last element in the Deque
   */
  public T last() {
    if (this.isEmpty()) return null;
    return this.data[(this.f + this.sz - 1)%this.data.length];
  }
  /**
   * Returns and removes the first element added to the Deque
   * @return the old first element in the Deque
   */
  public T removeFirst() {
    if (this.isEmpty()) return null;
    T answer = this.data[this.f];
    this.data[this.f] = null;
    this.f = (this.f + 1)%this.data.length;
    this.sz--;
    return answer;
  }
  /**
   * Returns and removes the last element added to the Deque
   * @return the old last element in the Deque
   */
  public T removeLast() {
    if (this.isEmpty()) return null;
    T answer = this.data[(this.f + this.sz - 1)%this.data.length];
    this.data[(this.f + this.sz - 1)%this.data.length] = null;
    this.sz--;
    return answer;
  }
  public static void main(String[] args) {
    ArrayDeque<String> deque = new ArrayDeque<>();
    deque.addFirst("Three");
    deque.addFirst("Two");
    deque.addFirst("One");
    deque.addLast("Four");
    deque.addLast("Five");
    while (deque.first() != null) {
      System.out.println(deque.removeFirst());
    }
    System.out.println();

    System.out.println("Size: " + deque.size());
    System.out.println("Front: " + deque.f);
    System.out.println();

    deque.addFirst("Three");
    deque.addFirst("Two");
    deque.addFirst("One");
    deque.addLast("Four");
    deque.addLast("Five");
    while (deque.last() != null) {
      System.out.println(deque.removeLast());
    }
    System.out.println();

    System.out.println("Size: " + deque.size());
    System.out.println("Front: " + deque.f);
    System.out.println();
  }
}