package hulu.maxRatio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2/8/2020
 */
public final class SolutionI implements Solution {
  @Override
  public double maxRatio(final double[][] points) {
    final Map<Double, Double[]> xToMinMax = new HashMap<>();
    for (final double[] p : points) {
      xToMinMax.putIfAbsent(p[0], new Double[]{Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY});
      final Double[] update = xToMinMax.get(p[0]);
      update[0] = Math.min(update[0], p[1]);
      update[1] = Math.max(update[1], p[1]);
    }
    final List<Map.Entry<Double, Double[]>> allPoints = new ArrayList<>(xToMinMax.entrySet());
    allPoints.sort((x, y) -> Double.compare(x.getKey(), y.getKey()));
    Map.Entry<Double, Double[]> prev = null;
    double max = Double.NEGATIVE_INFINITY;
    for (final Map.Entry<Double, Double[]> e : xToMinMax.entrySet()) {
      if (prev != null) {
        final double dx = e.getKey() - prev.getKey(),
            dy = e.getValue()[1] - prev.getValue()[0],
            ratio = dy / dx;
        max = Math.max(max, ratio);
      }
      prev = e;
    }
    return max;
  }
}
