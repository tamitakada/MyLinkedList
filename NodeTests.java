import java.util.ArrayList;

public class NodeTests {
  public static void main(String[] args) {
    testNodeCreationAndGet();
  }

  public static void testNodeCreationAndGet() {
    ArrayList<Boolean> results = new ArrayList<Boolean>();

    Node one = new Node("hello 12 !? hello");
    results.add(one.getData().equals("hello 12 !? hello"));

    one = new Node("");
    results.add(one.getData().equals(""));

    results.add(one.getNext() == null);
    results.add(one.getPrev() == null);

    ArrayList<String> failInfo = new ArrayList<String>();

    for (int i = 0; i < 100; i++) {
      String str = Utils.createRandomString();
      Node test = new Node(str);
      if (!test.getData().equals(str)) {
        failInfo.add(str);
        break;
      }
    }

    results.add(failInfo.isEmpty());
    Utils.showResults(results, "Test Node Creation & Get");
    Utils.showRandomResults(failInfo);
  }



}
