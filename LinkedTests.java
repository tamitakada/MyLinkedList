import java.util.*;

public class LinkedTests {
  public static void main(String[] args) {
    testAddAndSizeWithGet();
    testAddWithIndex();
    testToString();
    testSet();
  }

  public static void testRemove() {

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
    } catch (IndexOutOfBoundsException e) {
      results.add(false);
    }

    results.add(one.add("##hello"));
    results.add(one.size() == 2);

    try {
      String res = one.get(1);
      results.add(res.equals("##hello"));
    } catch (IndexOutOfBoundsException e) {
      results.add(false);
    }

    results.add(one.add("Hello world!!"));

    String[] linkedContents = {"Hello world!!", "##hello", "Hello world!!"};

    for (int i = 0; i < 3; i++) {
      try {
        String res = one.get(i);
        results.add(res.equals(linkedContents[i]));
      } catch (IndexOutOfBoundsException e) {
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
      } catch (IndexOutOfBoundsException e) {
        results.add(false);
      }
    }

    for (int i = 0; i < oneData.length; i++) {
      try {
        results.add(one.get(i).equals(oneData[i]));
      } catch (IndexOutOfBoundsException e) {
        results.add(false);
      }
    }

    try {
      results.add(one.add(3, "mice"));
    } catch (IndexOutOfBoundsException e) {
      results.add(false);
    }

    try {
      results.add(one.add(2, "Snakes"));
    } catch (IndexOutOfBoundsException e) {
      results.add(false);
    }

    try {
      results.add(one.add(0, "dogs"));
    } catch (IndexOutOfBoundsException e) {
      results.add(false);
    }

    oneData = new String[]{"dogs", "dogs", "?cats?", "Snakes", "Guinea pigs", "mice", " RATS! "};

    for (int i = 0; i < oneData.length; i++) {
      boolean res = true;
      try {
        res = one.get(i).equals(oneData[i]);
      } catch (IndexOutOfBoundsException e) {
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
    } catch (IndexOutOfBoundsException e) {
      results.add(true);
    }

    try {
      one.add(19, "Yay");
      results.add(false);
    } catch (IndexOutOfBoundsException e) {
      results.add(true);
    }

    Utils.showResults(results, "Test add w/ index");
  }

  public static void testToString() {
    ArrayList<Boolean> results = new ArrayList<Boolean>();

    MyLinkedList one = new MyLinkedList();
    String[] oneData = {"Fusili", "penne", "farfalle", "linguini"};

    results.add(true);

    for (int i = 0; i < oneData.length; i++) {
      try {
        one.add(oneData[i]);
      } catch (IndexOutOfBoundsException e) {
        results.set(0, false);
        break;
      }
    }

    results.add(one.toString().equals("[Fusili, penne, farfalle, linguini]"));

    try {
      results.add(one.add(1, "ziti"));
    } catch (IndexOutOfBoundsException e) {
      results.add(false);
    }

    try {
      results.add(one.add(3, "rigatoni"));
    } catch (IndexOutOfBoundsException e) {
      results.add(false);
    }

    results.add(one.toString().equals("[Fusili, ziti, penne, rigatoni, farfalle, linguini]"));

    MyLinkedList two = new MyLinkedList();
    results.add(two.toString().equals("[]"));

    two.add("pasta!");
    results.add(two.toString().equals("[pasta!]"));

    ArrayList<String> failInfo = new ArrayList<String>();

    for (int i = 0; i < 100; i++) {
      String[] test = Utils.createRandomStrArr();
      MyLinkedList testList = new MyLinkedList();

      for (int j = 0; j < test.length; j++) {
        try {
          testList.add(test[j]);
        } catch (IndexOutOfBoundsException e) {
          failInfo.add("Array - " + Arrays.toString(test));
          break;
        }
      }

      if (failInfo.size() > 0) {
        results.add(false);
        break;
      } else if (!Arrays.toString(test).equals(testList.toString())) {
        failInfo.add("To String fail -" + Arrays.toString(test));
        results.add(false);
        break;
      } else if (i == 99) results.add(true);
    }

    Utils.showResults(results, "Test to string");
    Utils.showRandomResults(failInfo);
  }

  public static void testSet() {
    ArrayList<Boolean> results = new ArrayList<Boolean>();

    MyLinkedList one = new MyLinkedList();
    String[] oneData = {"Fusili", "penne", "farfalle", "linguini"};

    results.add(true);

    for (int i = 0; i < oneData.length; i++) {
      try {
        one.add(oneData[i]);
      } catch (IndexOutOfBoundsException e) {
        results.set(0, false);
        break;
      }
    }

    try {
      results.add(one.set(1, "ziti").equals("penne"));
    } catch (IndexOutOfBoundsException e) {
      results.add(false);
    }

    try {
      results.add(one.set(3, "rigatoni").equals("linguini"));
    } catch (IndexOutOfBoundsException e) {
      results.add(false);
    }

    try {
      one.set(10, "tagliatelle");
      results.add(false);
    } catch (IndexOutOfBoundsException e) {
      results.add(true);
    }

    try {
      one.set(-1, "spaghetti");
      results.add(false);
    } catch (IndexOutOfBoundsException e) {
      results.add(true);
    }

    try {
      results.add(one.set(4, "angel hair").equals(""));
    } catch (IndexOutOfBoundsException e) {
      results.add(false);
    }

    results.add(one.toString().equals("[Fusili, ziti, farfalle, rigatoni, angel hair]"));

    MyLinkedList two = new MyLinkedList();

    try {
      two.set(1, "marinara");
      results.add(false);
    } catch (IndexOutOfBoundsException e) {
      results.add(true);
    }

    try {
      results.add(two.set(0, "lasagna").equals(""));
    } catch (IndexOutOfBoundsException e) {
      results.add(false);
    }

    results.add(two.toString().equals("[lasagna]"));

    Utils.showResults(results, "Test set");
  }

}
