package _451_500._470_Implement_Rand10_Using_Rand7;

public final class AdvanceSolutionI extends Solution {

  public int rand10() {
    int res = 10;
    while (res >= 10) {
      res = 7 * (rand7() - 1) + (rand7() - 1);
    }
    return res + 1;
  }
}
