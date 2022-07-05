class Q50 {

  Q50(EngineBracket argEngine) {
    myEngine = argEngine;
  }

  EngineBracket myEngine; // Benz Engine

  void startEngine() {
    myEngine.startEngine();
  }

  void turnOffEngine() {
    myEngine.turnOffEngine();
  }
}

interface EngineBracket {
  void startEngine();

  void turnOffEngine();
}

class BenzEngine implements EngineBracket {

  @Override
  public void startEngine() {
    benzEngineOn();
  }

  @Override
  public void turnOffEngine() {
    benzEngineOff();
  }

  void benzEngineOn() {
    System.out.println("Benz엔진 On");
  }

  void benzEngineOff() {
    System.out.println("Benz엔진 Off");
  }
}

class BmwEngine implements EngineBracket {

  @Override
  public void startEngine() {
    bmwEngineOn();
  }

  @Override
  public void turnOffEngine() {
    bmwEngineOff();
  }

  void bmwEngineOn() {
    System.out.println("Bmw엔진 On");
  }

  void bmwEngineOff() {
    System.out.println("Bmw엔진 Off");
  }
}

public class Foo {

  public static void main(String[] args) {
    Q50 myCar1 = new Q50(new BenzEngine());
    Q50 myCar2 = new Q50(new BmwEngine());
    myCar1.myEngine.startEngine();
    myCar1.myEngine.turnOffEngine();
    myCar2.myEngine.startEngine();
    myCar2.myEngine.turnOffEngine();
  }
}
