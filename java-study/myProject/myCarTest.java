class MyCar {

  EngineBracket myEngine;

  MyCar(EngineBracket argEngine) {
    myEngine = argEngine;
  }

  public void EngineOn() {
    if (!myEngine.EngineStart()) {
      System.out.println("이미 켜짐, 명령 무시");
      return;
    }
    System.out.println("시동 켜짐");
  }

  public void EngineOff() {
    if (!myEngine.EngineStop()) {
      System.out.println("이미 꺼짐, 명령 무시");
      return;
    }
    System.out.println("시동 꺼짐");
  }

  public int speedUp() {
    return myEngine.Acceleration();
  }

  public int speedDown() {
    return myEngine.Deceleration();
  }
}

interface EngineBracket {
  boolean EngineStart();
  boolean EngineStop();
  int Acceleration();
  int Deceleration();
}

class AEngine implements EngineBracket {

  boolean engineState = false;
  int currentSpeed = 0;

  public boolean EngineStart() {
    if (!engineState) {
      engineState = true;
      return true;
    }
    return false;
  }

  public boolean EngineStop() {
    if (engineState) {
      engineState = false;
      return true;
    }
    return false;
  }

  public int Acceleration() {
    if (engineState) {
      currentSpeed++;
    }
    return currentSpeed;
  }

  public int Deceleration() {
    if (currentSpeed > 0) {
      currentSpeed--;
    }
    return currentSpeed;
  }
}

public class myCarTest {

  public static void main(String[] args) {
    MyCar NewCar = new MyCar(new AEngine());
    NewCar.EngineOff();
    NewCar.EngineOn();
    System.out.println("speedUp : " + NewCar.speedUp());
    System.out.println("speedUp : " + NewCar.speedUp());
    System.out.println("speedUp : " + NewCar.speedUp());
    System.out.println("speedDown : " + NewCar.speedDown());
    System.out.println("speedDown : " + NewCar.speedDown());
    System.out.println("speedDown : " + NewCar.speedDown());
    System.out.println("speedDown : " + NewCar.speedDown());
    NewCar.EngineOn();
    NewCar.EngineOff();
  }
}
