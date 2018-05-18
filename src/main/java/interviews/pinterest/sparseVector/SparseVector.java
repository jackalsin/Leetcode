package interviews.pinterest.sparseVector;

import java.util.HashMap;
import java.util.Map;

/**
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=397465&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D33%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 */
public final class SparseVector {
  private final int capacity;
  private final Map<Integer, Double> keyToValue = new HashMap<>();

  public SparseVector(int capacity) {
    this.capacity = capacity;
  }

  public void set(int i, double value) {
    if (i >= capacity) {
      throw new IndexOutOfBoundsException("i = " + i + ", expects: [0, " + capacity + ")");
    }

    keyToValue.put(i, value);
  }

  public double get(int i) {
    if (i >= capacity || i < 0) {
      throw new IndexOutOfBoundsException("i = " + i + ", expects: [0, " + capacity + ")");
    }
    return keyToValue.getOrDefault(i, 0d);
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (int j = 0; j < capacity; j++) {
      double val = keyToValue.getOrDefault(j, 0d);
      sb.append(String.format("%.1f", val)).append(", ");
    }
    if (sb.length() > 1) {
      sb.setLength(sb.length() - 2);
    }
    sb.append("]");
    return sb.toString();
  }
}
