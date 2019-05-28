package interviews.airbnb.redWhiteBall;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class DfsMemoSolution implements Solution {
  private static final int RED = 0, WHITE = 1;
  private final Map<State, Double> cache = new HashMap<>();

  @Override
  // 剩下红球
  public double getProbability(int red, int white) {
    return getProbability(red, white, RED);
  }

  private double getProbability(final int red, final int white, final int lastTime) {
    final State curState = new State(red, white, lastTime);
    if (red <= 0) {
      return 0;
    }
    if (white == 0) {
      return 1;
    }
    if (cache.containsKey(curState)) {
      return cache.get(curState);
    }
    // get red ball
    double prob = ((double) red / (red + white)) * getProbability(red - 1, white, RED);
    if (lastTime == WHITE) {
      prob += (double) white / (red + white) * getProbability(red, white - 1, WHITE);
    } else {
      prob += ((double) white / (red + white)) * getProbability(red, white, WHITE);
    }
    cache.put(curState, prob);
    return prob;
  }

  private static final class State {
    private final int red, white, lastTime;

    private State(int red, int white, int lastTime) {
      this.red = red;
      this.white = white;
      this.lastTime = lastTime;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      State state = (State) o;
      return red == state.red &&
          white == state.white &&
          lastTime == state.lastTime;
    }

    @Override
    public int hashCode() {
      return Objects.hash(red, white, lastTime);
    }

    @Override
    public String toString() {
      return "State{" +
          "red=" + red +
          ", white=" + white +
          ", lastTime=" + lastTime +
          '}';
    }
  }
}

