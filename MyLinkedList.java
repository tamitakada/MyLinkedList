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
    if (index < 0 || index > size()) throw new IllegalArgumentException();
    if (index == size()) {
      add(value);
      return "";
    } else {
      Node toAdd = new Node(value);

      Node current = getStart();
      int count = 0;

      while (current != null && count < index) {
        current = current.getNext();
        count++;
      }

      if (current != null) {
        toAdd.setPrev(current.getPrev());
        toAdd.setNext(current.getNext());

        if (current.getNext() != null) {
          Node next = current.getNext();
          next.setPrev(toAdd);
        }

        if (current.getPrev() != null) {
          Node prev = current.getPrev();
          prev.setNext(toAdd);
        }

        if (current == getEnd()) setEnd(toAdd);
        if (current == getStart()) setStart(toAdd);
      }
      return current.getData();
    }
  }

  public String toString() {
    String s = "[";

    Node current = getStart();
    int count = 0;
    while (current != null) {
      s += current.getData();

      if (count != size() - 1) s += ", ";

      current = current.getNext();
      count++;
    }

    return s + "]";
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
