class Node {

  private int value;
  private Node nextNode;

  Node(int argValue, Node argNode) {
    value = argValue;
    nextNode = argNode;
  }

  Node getNextNode() {
    return nextNode;
  }

  void setNextNode(Node argNode) {
    nextNode = argNode;
  }

  int getValue() {
    return value;
  }

  void setValue(int argValue) {
    value = argValue;
  }
}

class LinkedList {

  Node tailNode, headNode;

  LinkedList() {
    tailNode = new Node(0, null);
    headNode = new Node(0, tailNode);
  }

  void insertValue(int argValue) {
    Node temp = headNode;
    while (temp.getNextNode() != tailNode) {
      temp = temp.getNextNode();
    }

    Node newNode = new Node(argValue, tailNode);

    temp.setNextNode(newNode);
  }
}

public class test {

  public static void main(String[] args) {
    LinkedList myList = new LinkedList();
    for (int i = 0; i < 10; i++) {
      myList.insertValue(i);
    }

    Node temp = myList.headNode.getNextNode();
    while (temp != myList.tailNode) {
      System.out.println(temp.getValue());
      temp = temp.getNextNode();
    }
  }
}
