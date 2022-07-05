class far {

  void prtFar() {
    System.out.println("Far");
  }
}

class par extends far {

  void prtFar() {
    System.out.println("Farasd");
  }
}

public class DBindTest {
  far obj = new par();
  obj.prtFar();
}
