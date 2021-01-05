import java.util.*;

public class LinkedTests {
  public static void main(String[] args) {
    testAddAndSizeWithGet();
  }

  public static void testAddAndSizeWithGet() {
    ArrayList<Boolean> results = new ArrayList<Boolean>();

    MyLinkedList one = new MyLinkedList();

    results.add(one.size() == 0);
    results.add(one.add("Hello world!!"));
    results.add(one.size() == 1);

    try {
      String res = one.get(0);
      results.add(res.equals("Hello world!!"));
    } catch (IllegalArgumentException e) {
      results.add(false);
    }

    results.add(one.add("##hello"));
    results.add(one.size() == 2);

    try {
      String res = one.get(1);
      results.add(res.equals("##hello"));
    } catch (IllegalArgumentException e) {
      results.add(false);
    }

    results.add(one.add("Hello world!!"));

    String[] linkedContents = {"Hello world!!", "##hello", "Hello world!!"};

    for (int i = 0; i < 3; i++) {
      try {
        String res = one.get(i);
        results.add(res.equals(linkedContents[i]));
      } catch (IllegalArgumentException e) {
        results.add(false);
      }
    }

  //  results.add(one.get(0) != one.get(2));
    Utils.showResults(results, "Test add/size/get");
  }

}
