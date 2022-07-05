import java.util.Scanner;

class MyException extends Exception {

  MyException(String msg) {
    super(msg);
  }
}

class Permutation {

  static int getInputValue(int argFrom, int argTo)
    throws MyException {
    System.out.println("양의 정수 값을 입력하세요.");
    Scanner sn = new Scanner(System.in);
    int N = sn.nextInt();
    if (N < argFrom) {
      throw new MyException(
        argFrom + " 이상의 정수를 입력 하세요"
      );
    } else if (N > argTo) {
      throw new MyException(
        argTo + " 이하의 정수를 입력하세요"
      );
    }
    return N;
  }

  static int factorial(int InputValue) {
    int result = 1;
    for (int i = InputValue; i >= 1; i--) {
      result *= i;
    }
    return result;
  }

  static void getPermutation(int InputValue) {
    int n = InputValue;
    int r = InputValue;
    int cases = factorial(n) / factorial(n - r);

    System.out.println("발생 가능한 경우의 수 :" + cases);
    int arr[] = new int[InputValue];

    for (int i = 0; i < n; i++) {
      arr[i] = i + 1;
    }
    int output[] = new int[InputValue];
    boolean visited[] = new boolean[InputValue];
    int depth = 0;
    permutation(arr, output, visited, depth, n, r);
    //permutation([1,2,3], [0,0,0], [f,f,f], 0, 3, 3);
  }

  static void permutation(
    int[] arr,
    int[] output,
    boolean[] visited,
    int depth,
    int n,
    int r
  ) {
    if (depth == r) {
      // d=0
      // per1 d=1
      // per2 d=2
      // per3 d=3
      print(output, r);
      //[1,2,3]
      //[1,3,2]
      return;
    }

    for (int i = 0; i < n; i++) {
      // a[1,2,3]
      if (visited[i] != true) {
        // d=0 i=1 v[f,t,f] o[0,0,0] a[1,2,3]
        visited[i] = true;
        output[depth] = arr[i];
        System.out.println("d:" + depth + " i:" + i + " ");

        permutation(arr, output, visited, depth + 1, n, r);
        visited[i] = false;
      }
    }
  }

  static void print(int arr[], int r) {
    for (int i = 0; i < r; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
}

public class Quiz11 {

  public static void main(String[] args) {
    while (true) {
      try {
        int InputValue = Permutation.getInputValue(1, 5);
        Permutation.getPermutation(InputValue);
        break;
      } catch (MyException e) {
        System.out.println("ERROR");
        System.out.println("에러 내용: " + e.getMessage());
      } catch (Exception e) {
        System.out.println(
          "알수 없는 예외발생, 다시 입력하세요."
        );
      }
    }
  }
}
