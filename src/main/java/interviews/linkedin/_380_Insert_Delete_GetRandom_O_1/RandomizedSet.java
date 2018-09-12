package interviews.linkedin._380_Insert_Delete_GetRandom_O_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
  private final Random random = new Random();
  private final Map<Integer, Integer> valToIndex = new HashMap<>();
  private final List<Integer> vals = new ArrayList<>();

  /**
   * Inserts a value to the set. Returns true if the set did not already contain the specified element.
   */
  public boolean insert(int val) {
    if (valToIndex.containsKey(val)) {
      return false;
    }
    valToIndex.put(val, vals.size());
    vals.add(val);
    return true;
  }

  /**
   * Removes a value from the set. Returns true if the set contained the specified element.
   */
  public boolean remove(int val) {
    if (!valToIndex.containsKey(val)) {
      return false;
    }
    final int toRemoveIndex = valToIndex.remove(val),
        lastIndexVal = vals.get(vals.size() - 1);
    if (toRemoveIndex != vals.size() - 1) {
      valToIndex.put(lastIndexVal, toRemoveIndex);
      vals.set(toRemoveIndex, lastIndexVal);
    }
    vals.remove(vals.size() - 1);
    return true;
  }

  /**
   * Get a random element from the set.
   */
  public int getRandom() {
    return vals.get(random.nextInt(vals.size()));
  }
}
