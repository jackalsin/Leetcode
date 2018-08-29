package dynamicProgramming.tutorials.fibonacci;

public final class RecursionSolution implements Solution {
  @Override
  public int fib(int i) {
    if (i < 0) {
      throw new IllegalArgumentException("i needs to be non negative");
    }
    return fibHelper(i);
  }

  private static int fibHelper(int n) {
    if (n <= 1) {
      return n;
    }
    return fibHelper(n - 1) + fibHelper(n - 2);
  }
}
