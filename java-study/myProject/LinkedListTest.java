import java.util.Scanner;

class MyException extends Exception {

  MyException(String argMsg) {
    super(argMsg);
  }
}

class Node {

  int value;
  Node nextNode;

  Node(int argValue, Node argNode) {
    value = argValue;
    nextNode = argNode;
  }

  int getValue() {
    return value;
  }

  Node getNextNode() {
    return nextNode;
  }

  void setValue(int argValue) {
    value = argValue;
  }

  void setNextNode(Node argNode) {
    nextNode = argNode;
  }
}

class LinkedList {

  private Node head;
  private Node tail;

  LinkedList() {
    tail = new Node(0, null);
    head = new Node(0, tail);
  }

  void insertValue(int argValue) {
    Node temp = head;
    while (temp.getNextNode() != tail) {
      temp = temp.getNextNode();
    }
    Node newNode = new Node(argValue, tail);
    temp.setNextNode(newNode);
  }

  Node getNodeByValue(int argValue) {
    Node temp = head.getNextNode();
    while (temp.getNextNode() != null) {
      if (temp.getValue() == argValue) {
        return temp;
      }
      temp = temp.getNextNode();
    }
    return null;
  }

  void deleteValue(int argValue) {
    Node temp = head;
    Node previousNode = head;

    while (temp.getNextNode() != null) {
      if (temp.getValue() == argValue) {
        previousNode.setNextNode(temp.getNextNode());
        temp = null;
        return;
      }
      previousNode = temp;
      temp = temp.getNextNode();
    }
  }

  void printList() {
    Node temp = head.getNextNode();
    while (temp != tail) {
      System.out.print(temp.getValue() + " ");
      temp = temp.getNextNode();
    }
    System.out.println();
  }
}

public class LinkedListTest {

  static LinkedList myList = new LinkedList();

  static void selectMenu() throws MyException, Exception {
    Scanner sn = new Scanner(System.in);
    int inputMenu = 0;
    while (inputMenu != 5) {
      System.out.println("===========================");
      System.out.println("    메뉴를 선택해주세요.");
      System.out.println("\t1. 추가");
      System.out.println("\t2. 확인");
      System.out.println("\t3. 출력");
      System.out.println("\t4. 삭제");
      System.out.println("\t5. 종료");
      System.out.println("===========================");
      inputMenu = sn.nextInt();
      if (inputMenu == 1) {
        System.out.println("넣을 값을 입력 : ");
        int inputValue = sn.nextInt();
        myList.insertValue(inputValue);
      } else if (inputMenu == 2) {
        System.out.println("찾을 값 입력 : ");
        int inputValue = sn.nextInt();
        System.out.println(
          myList.getNodeByValue(inputValue)
        );
      } else if (inputMenu == 3) {
        myList.printList();
      } else if (inputMenu == 4) {
        System.out.println("제거할 값 입력 : ");
        int inputValue = sn.nextInt();
        myList.deleteValue(inputValue);
      } else if (inputMenu < 1 || inputMenu > 5) {
        throw new MyException("다시 입력해 주세요.");
      } else if (inputMenu == 5) {
        break;
      } else {
        throw new Exception();
      }
    }
  }

  public static void main(String[] args) {
    while (true) {
      try {
        selectMenu();
        System.out.println("프로그램 종료");
        break;
      } catch (MyException e) {
        System.out.println("에러 메세지" + e.getMessage());
        e.printStackTrace();
      } catch (Exception e) {
        System.out.println("에러 메세지" + e.getMessage());
        e.printStackTrace();
      }
    }
  }
}
