public class MyLinkedList{
  private int size;
  private Node start,end;

  public MyLinkedList() {
    size = 0;
    start = null;
    end = null;
  }

  public int size() {
    return size;
  }

  public boolean add(String value) {
    Node next = new Node(value);

    if (getEnd() != null) {
      next.setPrev(end);
      end.setNext(next);
    }

    setEnd(next);
    if (getStart() == null) setStart(next);
    setSize(size() + 1);

    return true;
  }

  public boolean add(int index, String value) {
    return true;
  }

  public String get(int index) {
    if (index < 0 || index >= size()) throw new IllegalArgumentException();
    Node current = getStart();
    for (int i = 0; i < index; i++) {
      current = current.getNext();
    }
    return current.getData();
  }

  public String set(int index, String value) {
    return "";
  }
  public String toString() {
    return "";
  }

  private void setSize(int newSize) {
    size = newSize;
  }

  private Node getStart() {
    return start;
  }

  private Node getEnd() {
    return end;
  }

  private void setStart(Node start) {
    this.start = start;
  }

  private void setEnd(Node newEnd) {
    this.end = newEnd;
  }
}
