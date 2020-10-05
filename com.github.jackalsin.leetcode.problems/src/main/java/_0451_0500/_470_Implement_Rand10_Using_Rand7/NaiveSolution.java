package _0451_0500._470_Implement_Rand10_Using_Rand7;

public final class NaiveSolution extends Solution {

  public int rand10() {
    int sum = 0;
    for (int i = 0; i < 7; i++) {
      sum += rand7();
    }
    return sum % 10 + 1;
  }
}
