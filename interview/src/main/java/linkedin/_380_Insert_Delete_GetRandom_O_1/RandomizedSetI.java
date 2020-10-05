package linkedin._380_Insert_Delete_GetRandom_O_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author jacka
 * @version 1.0 on 7/21/2019
 */
public final class RandomizedSetI implements RandomizedSet {
  private final Random rand = new Random();

  private final List<Integer> vals = new ArrayList<>();

  private final Map<Integer, Integer> valToIndex = new HashMap<>();

  /**
   * Inserts a value to the set. Returns true if the set did not already contain the specified element.
   */
  public boolean insert(int val) {
    final boolean existBefore = valToIndex.containsKey(val);
    if (!existBefore) {
      valToIndex.put(val, vals.size());
      vals.add(val);
    }
    return !existBefore;
  }

  /**
   * Removes a value from the set. Returns true if the set contained the specified element.
   */
  public boolean remove(int val) {
    final boolean contains = valToIndex.containsKey(val);
    if (contains) {
      final int toRemoveIndex = valToIndex.get(val),
          toSwapIndex = vals.size() - 1,
          toSwapValue = vals.get(toSwapIndex);
      valToIndex.put(toSwapValue, toRemoveIndex);
      valToIndex.remove(val);
      vals.set(toRemoveIndex, toSwapValue);
      vals.remove(toSwapIndex);
    }
    return contains;
  }

  /**
   * Get a random element from the set.
   */
  public int getRandom() {
    return vals.get(rand.nextInt(vals.size()));
  }
}
