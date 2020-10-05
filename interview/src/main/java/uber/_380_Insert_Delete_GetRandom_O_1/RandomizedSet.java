package uber._380_Insert_Delete_GetRandom_O_1;

import java.util.*;

import static java.util.Collections.swap;

public final class RandomizedSet {
  private final Map<Integer, Integer> valToId = new HashMap<>();
  private final Random rand = new Random();
  private final List<Integer> values = new ArrayList<>();


  /**
   * Inserts a value to the set. Returns true if the set did not already contain the specified element.
   */
  public boolean insert(int val) {
    if (!valToId.containsKey(val)) {
      valToId.put(val, values.size());
      values.add(val);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Removes a value from the set. Returns true if the set contained the specified element.
   */
  public boolean remove(int val) {
    if (!valToId.containsKey(val)) {
      return false;
    } else {
      final int toRemoveIndex = valToId.get(val), lastValIndex = values.size() - 1, lastVal =
          values.get(lastValIndex);
      swap(values, toRemoveIndex, lastValIndex);
      valToId.put(lastVal, toRemoveIndex);
      valToId.remove(val);
      values.remove(lastValIndex);
      return true;
    }
  }

  /**
   * Get a random element from the set.
   */
  public int getRandom() {
    final int i = rand.nextInt(values.size());
    return values.get(i);
  }
}
