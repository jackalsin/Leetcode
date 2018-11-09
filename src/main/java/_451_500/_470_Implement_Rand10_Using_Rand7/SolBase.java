package _451_500._470_Implement_Rand10_Using_Rand7;

import java.util.Random;

public abstract class SolBase {
  private final Random rand = new Random();

  public int rand7() {
    return rand.nextInt(7) + 1;
  }
}
