class HCar {

  HCar(EngineBracket argEngine) {
    myEngine = argEngine;
  }

  EngineBracket myEngine;

  void engineOn() {
    if (myEngine.startEngine()) {
      System.out.println("엔진 동작 중, 명령 무시");
    } else {
      System.out.println("엔진 시동");
    }
  }

  void engineOff() {
    if (myEngine.stopEngine()) {
      System.out.println("엔진 정지");
    } else {
      System.out.println("엔진 정지 상태, 명령 무시");
    }
  }

  public int speedUp() {
    return myEngine.acceleration();
  }

  public int speedDown() {
    return myEngine.deceleration();
  }
}

interface EngineBracket {
  boolean startEngine();
  boolean stopEngine();
  int acceleration();
  int deceleration();
}

class BEngine implements EngineBracket {

  boolean isEngineOn = false;
  int currentVelocity = 0;

  @Override
  public boolean startEngine() {
    if (!isEngineOn) {
      isEngineOn = true;
    }
    return isEngineOn;
  }

  @Override
  public boolean stopEngine() {
    if (isEngineOn) {
      isEngineOn = false;
    }
    return isEngineOn;
  }

  @Override
  public int acceleration() {
    currentVelocity++;
    return currentVelocity;
  }

  @Override
  public int deceleration() {
    if (currentVelocity > 0) {
      currentVelocity--;
    }
    return currentVelocity;
  }
}

public class Quiz12 {

  public static void main(String[] args) {
    HCar myCar = new HCar(new BEngine());
    myCar.engineOff(); // 엔진 정시 상태, 명령 무시
    myCar.engineOn(); // 엔진 시동
    System.out.println("Speed Up : " + myCar.speedUp()); // Speed up : 1
    System.out.println("Speed Up : " + myCar.speedUp()); // Speed up : 2
    System.out.println("Speed Down : " + myCar.speedDown()); // Speed down : 1
    System.out.println("Speed Down : " + myCar.speedDown()); // Speed down : 0
    System.out.println("Speed Down : " + myCar.speedDown()); // Speed down : 0
    myCar.engineOn(); // 엔진 동작 중, 명령 무시
    myCar.engineOff(); // 엔진 정지
  }
}
