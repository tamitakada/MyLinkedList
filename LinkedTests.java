import java.util.*;

public class LinkedTests {
  public static void main(String[] args) {
    testAddAndSizeWithGet();
    testAddWithIndex();
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

    Utils.showResults(results, "Test add/size/get");
  }

  public static void testAddWithIndex() {
    ArrayList<Boolean> results = new ArrayList<Boolean>();

    MyLinkedList one = new MyLinkedList();
    String[] oneData = {"dogs", "?cats?", "Guinea pigs", " RATS! "};

    for (int i = 0; i < oneData.length; i++) {
      try {
        results.add(one.add(i, oneData[i]));
      } catch (IllegalArgumentException e) {
        results.add(false);
      }
    }

    for (int i = 0; i < oneData.length; i++) {
      try {
        results.add(one.get(i).equals(oneData[i]));
      } catch (IllegalArgumentException e) {
        results.add(false);
      }
    }

    try {
      results.add(one.add(3, "mice"));
    } catch (IllegalArgumentException e) {
      results.add(false);
    }

    try {
      results.add(one.add(2, "Snakes"));
    } catch (IllegalArgumentException e) {
      results.add(false);
    }

    try {
      results.add(one.add(0, "dogs"));
    } catch (IllegalArgumentException e) {
      results.add(false);
    }

    oneData = new String[]{"dogs", "dogs", "?cats?", "Snakes", "Guinea pigs", "mice", " RATS! "};

    for (int i = 0; i < oneData.length; i++) {
      boolean res = true;
      try {
        res = one.get(i).equals(oneData[i]);
      } catch (IllegalArgumentException e) {
        res = false;
      }

      if (!res) {
        results.add(false);
        break;
      } else if (i == oneData.length - 1) {
        results.add(true);
      }
    }

    try {
      one.add(-2, "ahasda");
      results.add(false);
    } catch (IllegalArgumentException e) {
      results.add(true);
    }

    try {
      one.add(19, "Yay");
      results.add(false);
    } catch (IllegalArgumentException e) {
      results.add(true);
    }

    Utils.showResults(results, "Test add w/ index");
  }

}
