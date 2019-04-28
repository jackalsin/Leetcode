package interviews.airbnb.diceSimulation;

import java.util.Random;

public final class Dice {
  private static final int N = 6;
  private final Random rand = new Random();

  public int roll(final int times) {
    int res = 0;
    for (int i = 0; i < times; i++) {
      res += roll();
    }
    return res;
  }

  private int roll() {
    return rand.nextInt(N) + 1;
  }
}
