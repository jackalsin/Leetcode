package interviews.uber._381_Insert_Delete_GetRandom_O_1_Duplicates_allowed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RandomizedCollection {
  private final Map<Integer, Set<Integer>> valueToIndex = new HashMap<>();
  private final List<Integer> values = new ArrayList<>();
  private final Random random = new Random();

  /**
   * Initialize your data structure here.
   */
  public RandomizedCollection() {

  }

  /**
   * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
   */
  public boolean insert(int val) {
    if (valueToIndex.containsKey(val)) {
      final Set<Integer> indexList = valueToIndex.get(val);
      indexList.add(values.size());
      values.add(val);
      return false;
    } else {
      final Set<Integer> indexList = new LinkedHashSet<>();
      valueToIndex.put(val, indexList);
      indexList.add(values.size());
      values.add(val);
      return true;
    }
  }

  /**
   * Removes a value from the collection. Returns true if the collection contained the specified element.
   * Only remove one of them if there are multiple.
   */
  public boolean remove(int val) {
    if (valueToIndex.containsKey(val)) {
      final Set<Integer> valIndexList = valueToIndex.get(val);
      final int valIndex = valIndexList.iterator().next();
      valIndexList.remove(valIndex);

      if (valIndex != values.size() - 1) {
        final int lastVal = values.get(values.size() - 1);
        // update last value index
        final Set<Integer> lastValIndexList = valueToIndex.get(lastVal);
        lastValIndexList.remove(values.size() - 1);
        lastValIndexList.add(valIndex);

        // update values
        values.set(valIndex, lastVal);
      }
      values.remove(values.size() - 1);
      if (valIndexList.isEmpty()) {
        valueToIndex.remove(val);
      }
      return true;
    } else {
      return false;
    }
  }

  /**
   * Get a random element from the collection.
   */
  public int getRandom() {
    return values.get(random.nextInt(values.size()));
  }
}
