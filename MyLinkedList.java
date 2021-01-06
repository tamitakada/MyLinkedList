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
      getEnd().setNext(next);
      setEnd(next);
    } else if (getStart() != null) {
      next.setPrev(getStart());
      getStart().setNext(next);
      setEnd(next);
    } else setStart(next);

    setSize(size() + 1);

    return true;
  }

  public boolean add(int index, String value) {
    if (index < 0 || index > size()) throw new IllegalArgumentException();
    Node toAdd = new Node(value);

    Node current = getStart();
    int count = 0;

    while (current != null && count < index - 1) {
      current = current.getNext();
      count++;
    }

    if (current != null) {
      if (current.getNext() != null) {
        Node next = current.getNext();
        next.setPrev(toAdd);
        toAdd.setNext(next);
      }

      toAdd.setPrev(current);
      current.setNext(toAdd);

      setSize(size() + 1);
    } else {
      add(value);
    }

    return true;
  }

  public String get(int index) {
    if (index < 0 || (index >= size() && size() != 0)) throw new IllegalArgumentException();
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
    Node current = getStart();
    while (current != null) {
      System.out.println(current);
      System.out.println("data: " + current.getData());
      System.out.println("next: " + current.getNext());
      System.out.println("prev: " + current.getPrev());
      System.out.println();
      current = current.getNext();
    }
/*
    String s = "[";

    int count = 0;
    while (current != null && current.getNext() != null && count < size() - 1) {
      s += current.getData() + ", ";
      current = current.getNext();
      count++;
    }

    if (getEnd() != null) s += getEnd().getData() + "]";
    else s += "]";
*/
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
