package google.latestArrival;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 5/5/2021
 */
public final class SolutionI implements Solution {

  @Override
  public int latestArrival(int[] shuttleArrivals, int[] capacity, int[] arrival) {
    if (shuttleArrivals == null || arrival == null) return -1;

    assert shuttleArrivals.length == capacity.length;
    final List<Capacity> capacities = new ArrayList<>();
    for (int i = 0; i < shuttleArrivals.length; ++i) {
      capacities.add(new Capacity(shuttleArrivals[i], capacity[i]));
    }
    for (int a : arrival) {
      capacities.add(new Capacity(a, -1));
    }
    capacities.sort(Comparator.comparingInt(x -> x.timestamp));

    int curCapacity = 0, res = capacities.get(0).timestamp - 1;
    for (final Capacity c : capacities) {
      if (curCapacity > 0) {
        res = c.timestamp - 1;
      }
      curCapacity += c.diff;
      if (curCapacity > 0) res = c.timestamp;
    }
    return res;
  }

  private static final class Capacity {
    private final int timestamp, diff;

    private Capacity(int timestamp, int diff) {
      this.timestamp = timestamp;
      this.diff = diff;
    }
  }
}
