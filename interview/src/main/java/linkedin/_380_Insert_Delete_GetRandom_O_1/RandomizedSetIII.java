package linkedin._380_Insert_Delete_GetRandom_O_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author jacka
 * @version 1.0 on 9/4/2019
 */
public final class RandomizedSetIII implements RandomizedSet {
  private final Random rand = new Random();
  private final List<Integer> vals = new ArrayList<>();
  private final Map<Integer, Integer> valToIndex = new HashMap<>();

  public boolean insert(int val) {
    if (valToIndex.containsKey(val)) {
      return false;
    }
    valToIndex.put(val, vals.size());
    vals.add(val);
    return true;
  }

  public boolean remove(int val) {
    if (!valToIndex.containsKey(val)) {
      return false;
    }
    final int toRemoveIndex = valToIndex.get(val), lastIndex = vals.size() - 1,
        lastVal = vals.get(lastIndex);
    valToIndex.put(vals.get(lastIndex), toRemoveIndex);
    valToIndex.remove(val);
    swap(vals, toRemoveIndex, lastIndex);
    vals.remove(vals.size() - 1);
    return true;
  }

  private static void swap(final List<Integer> vals, final int i, final int j) {
    final int tmp = vals.get(i);
    vals.set(i, vals.get(j));
    vals.set(j, tmp);
  }

  public int getRandom() {
    return vals.get(rand.nextInt(vals.size()));
  }
}
