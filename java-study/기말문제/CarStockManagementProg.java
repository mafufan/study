import java.util.Scanner;

class StockMngr {

  Stock stock_list[];

  public StockMngr(int argStockBucketSize) {
    stock_list = new Stock[argStockBucketSize];
  }

  int insertStock(Stock argStock) {
    return 0;
  }

  void printStockList() {}

  void printStockList(String argType) {}
}

interface Stock {
  int getId();

  String getType();

  String getProductName();

  String getProductColor();

  int getProductPrice();
}

public class CarStockManagementProg {

  StockMngr myStock;
  static int id = 0;

  public CarStockManagementProg() {
    myStock = new StockMngr(10);
  }

  static int insertCar(
    String argType,
    String argName,
    int argPrice,
    String argColor
  ) {
    if (argName.equals("GV80")) {
      GV80 gv80 = new GV80(argPrice, argColor);
      myStock.insertStock(gv80);
    }
    return 0;
  }

  public static void main(String[] args) {
    String carType = "SUV";
    String carName = "GV80";
    int carPrice = 50000;
    String carColor = "RED";
    int id = insertCar(carType, carName, carPrice, carColor);
  }
}

class GV80 implements Stock {

  String carName = "GV80";
  String carType = "SUV";
  int carPrice = 0;
  String carColor = "";

  GV80(int argPrice, String argColor) {
    carPrice = argPrice;
    carColor = argColor;
  }

  public int getId() {
    return 0;
  }

  public String getType() {
    return carType;
  }

  public String getProductName() {
    return carName;
  }

  public String getProductColor() {
    return carColor;
  }

  public int getProductPrice() {
    return carPrice;
  }
}

class SORENTO implements Stock {

  String carName = "SORENTO";
  String carType = "SUV";
  int carPrice;
  String carColor;

  SORENTO(int argPrice, String argColor) {
    carPrice = argPrice;
    carColor = argColor;
  }

  public int getId() {
    return 0;
  }

  public String getType() {
    return carType;
  }

  public String getProductName() {
    return carName;
  }

  public String getProductColor() {
    return carColor;
  }

  public int getProductPrice() {
    return carPrice;
  }
}

class EV6 implements Stock {

  String carName = "EV6";
  String carType = "SEDAN";
  int carPrice;
  String carColor;

  EV6(int argPrice, String argColor) {
    carPrice = argPrice;
    carColor = argColor;
  }

  public int getId() {
    return 0;
  }

  public String getType() {
    return carType;
  }

  public String getProductName() {
    return carName;
  }

  public String getProductColor() {
    return carColor;
  }

  public int getProductPrice() {
    return carPrice;
  }
}

class G90 implements Stock {

  String carName = "G90";
  String carType = "SEDAN";
  int carPrice;
  String carColor;

  G90(int argPrice, String argColor) {
    carPrice = argPrice;
    carColor = argColor;
  }

  public int getId() {
    return 0;
  }

  public String getType() {
    return carType;
  }

  public String getProductName() {
    return carName;
  }

  public String getProductColor() {
    return carColor;
  }

  public int getProductPrice() {
    return carPrice;
  }
}
