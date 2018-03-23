package interviews.uber._380_Insert_Delete_GetRandom_O_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class RandomizedSet {
  private final Map<Integer, Integer> valueToIndex = new HashMap<>();
  private final List<Integer> values = new ArrayList<>();
  private final Random random = new Random();

  /**
   * Inserts a value to the set. Returns true if the set did not already contain the specified element.
   */
  public boolean insert(int val) {
    if (!valueToIndex.containsKey(val)) {
      valueToIndex.put(val, values.size());
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
    if (valueToIndex.containsKey(val)) {
      final int valIndex = valueToIndex.get(val), toSwapIndex = values.size() - 1, toSwap = values.get(toSwapIndex);

      values.remove(toSwapIndex);
      valueToIndex.remove(val);
      if (valIndex != toSwapIndex) {
        valueToIndex.put(toSwap, valIndex);
        values.set(valIndex, toSwap);
      }
      return true;
    } else {
      return false;
    }
  }

  /**
   * Get a random element from the set.
   */
  public int getRandom() {
    final int randomIndex = random.nextInt(values.size());
    return values.get(randomIndex);
  }
}
