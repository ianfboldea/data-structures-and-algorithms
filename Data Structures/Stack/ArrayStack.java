public class ArrayStack<E> implements Stack<E> {
  public static final int CAPACITY=1000;
  private E[] data;
  private int t = -1; // size-1
  public ArrayStack() { this(CAPACITY); }
  public ArrayStack(int capacity) {
    this.data = (E[]) new Object[capacity];
  }
  public int size() { return (this.t + 1); }
  public boolean isEmpty() { return (this.t == -1); }
  public void push(E data) throws IllegalStateException {
    if (this.size() == this.data.length) throw new IllegalStateException("Stack is full");
    this.data[++this.t] = data;
  }
  public E top() {
    if (this.isEmpty()) return null;
    return this.data[this.t];
  }
  public E pop() {
    if (this.isEmpty()) return null;
    E answer = this.data[this.t];
    this.data[this.t] = null;
    this.t--;
    return answer;
  }
  public static void main(String[] args) {
    // Main method provided by textbook listed in interface header
    Stack<Integer> S = new ArrayStack<>(); 
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