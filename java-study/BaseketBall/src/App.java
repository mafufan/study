class Player {

  void centerShoot() {}

  void guardShoot() {}

  void forwardShoot() {}
}

class Center extends Player {

  void centerShoot() {
    System.out.println("센터 슛");
  }
}

class Forward extends Player {

  void forwardShoot() {
    System.out.println("Forward Shoot");
  }
}

class PowerForward extends Forward {

  void forwardShoot() {
    System.out.println("PF 슛");
  }
}

class Guard extends Player {

  void guardShoot() {
    System.out.println("가드 슛");
  }
}

public class App {

  public static void main(String[] args) {
    Player playerList[] = new Player[5];
    playerList[0] = new Center();
    playerList[1] = new Guard();
    playerList[2] = new PowerForward();
    playerList[0].centerShoot();
    playerList[1].guardShoot();
    playerList[2].forwardShoot();
  }
}
