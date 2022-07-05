abstract class Player {

  abstract void shoot();
}

class Center extends Player {

  void shoot() {
    System.out.println("Center Shoot");
  }
}

class Guard extends Player {
  /* void shoot() {
    System.out.println("Guard Shoot");
  } */
}

public class foo5 {

  public static void main(String[] args) {
    Player playerList[] = new Player[3];
    playerList[0] = new Center();
    playerList[1] = new Guard();

    playerList[0].shoot();
    // playerList[1].shoot();
  }
}
