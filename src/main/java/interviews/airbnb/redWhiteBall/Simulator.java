package interviews.airbnb.redWhiteBall;

import java.util.Random;

public final class Simulator {
  private final Random rand = new Random();

  public double getProbability(final int r, final int w, int n) {
    int success = 0;
    for (int i = 0; i < n; i++) {
      if (getProbability(r, w)) {
        success++;
      }
    }
    return (double) success / n;
  }

  public boolean getProbability(int r, int w) {
    int total = r + w;
    boolean lastTimeWhite = false;
    while (r + w > 1) {
      final int cur = rand.nextInt(r + w);
      if (cur < w) { // white
        if (lastTimeWhite) {
          w--;
        }
        lastTimeWhite = true;
      } else {
        r--;
        lastTimeWhite = false;
      }
    }
    return r == 1;
  }
}
