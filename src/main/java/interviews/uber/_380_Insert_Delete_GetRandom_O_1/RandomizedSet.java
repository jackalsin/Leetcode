package interviews.uber._380_Insert_Delete_GetRandom_O_1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public final class RandomizedSet {
  private final Map<Integer, Integer> valueToIndex = new HashMap<>();
  private final List<Integer> valueList = new LinkedList<>();
  private final Random random = new Random();

  /**
   * Initialize your data structure here.
   */
  public RandomizedSet() {
  }

  /**
   * Inserts a value to the set. Returns true if the set did not already contain the specified element.
   */
  public boolean insert(int val) {
    if (valueToIndex.containsKey(val)) {
      return false;
    } else {
      valueToIndex.put(val, valueList.size());
      valueList.add(val);
      return true;
    }
  }

  /**
   * Removes a value from the set. Returns true if the set contained the specified element.
   */
  public boolean remove(int val) {
    /*
     * Swap the current value to the last one in valueList,
     * Then delete the last one.
     */
    if (valueToIndex.containsKey(val)) {
      int valIndex = valueToIndex.get(val);
      int lastValueIndex = valueList.size() - 1;
      int lastValue = valueList.get(lastValueIndex);
      if (valIndex != lastValueIndex) {
        valueList.set(valIndex, lastValue);
        valueToIndex.put(lastValue, valIndex);
      }

      valueToIndex.remove(val);
      valueList.remove(valueList.size() - 1);
      return true;
    } else {
      return false;
    }
  }

  private void swap(List<Integer> valueList, int i, int j) {
    int tmp = valueList.get(i);
    valueList.set(i, valueList.get(j));
    valueList.set(j, tmp);
  }

  /**
   * Get a random element from the set.
   */
  public int getRandom() {
    final int i = random.nextInt(valueList.size());
    return valueList.get(i);
  }
}
