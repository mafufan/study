class MyCar {

  EngineBracket myEngine;

  MyCar(EngineBracket argEngine) {
    myEngine = argEngine;
  }

  void onEngine() {
    if (myEngine.startEngine()) {
      System.out.println("시동 커짐");
    } else {
      System.out.println("이미 커져있음");
    }
  }

  void stopEngine() {
    if (myEngine.stopEngine()) {
      System.out.println("시동 꺼짐");
    } else {
      System.out.println("이미 꺼저있음");
    }
  }

  int speedUp() {
    return myEngine.acceleration();
  }

  int speedDown() {
    return myEngine.deceleration();
  }
}

interface EngineBracket {
  boolean startEngine();
  boolean stopEngine();
  int acceleration();
  int deceleration();
}

class SuperEngine implements EngineBracket {

  boolean isEngineOn = false;
  int currentVelocity = 0;

  public boolean startEngine() {
    if (!isEngineOn) {
      isEngineOn = true;
      return true;
    }
    return false;
  }

  public boolean stopEngine() {
    if (isEngineOn) {
      isEngineOn = false;
      return true;
    }
    return false;
  }

  public int acceleration() {
    if (isEngineOn) {
      currentVelocity++;
    }
    return currentVelocity;
  }

  public int deceleration() {
    if (isEngineOn && currentVelocity > 0) {
      currentVelocity--;
    }
    return currentVelocity;
  }
}

public class CarEngine {

  public static void main(String[] args) {
    MyCar myCar = new MyCar(new SuperEngine());
    myCar.onEngine();
    myCar.onEngine();

    System.out.println("브레이크 : " + myCar.speedDown());
    System.out.println("가속 : " + myCar.speedUp());
    System.out.println("가속 : " + myCar.speedUp());
    System.out.println("브레이크 : " + myCar.speedDown());
    System.out.println("브레이크 : " + myCar.speedDown());
    myCar.stopEngine();
    myCar.stopEngine();
  }
}
