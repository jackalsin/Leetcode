package interviews.linkedin._381_Insert_Delete_GetRandom_O_1_Duplicates_allowed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class RandomizedCollection {

  private final List<Integer> vals = new ArrayList<>();
  private final Map<Integer, Set<Integer>> valToIndex = new HashMap<>();
  private final Random random = new Random();


  /**
   * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
   */
  public boolean insert(int val) {
    if (valToIndex.containsKey(val)) {
      valToIndex.get(val).add(vals.size());
      vals.add(val);
      return false;
    } else {
      valToIndex.put(val, new HashSet<>());
      valToIndex.get(val).add(vals.size());
      vals.add(val);
      return true;
    }
  }

  /**
   * Removes a value from the collection. Returns true if the collection contained the specified element.
   */
  public boolean remove(int val) {
    if (valToIndex.containsKey(val)) {
      final Set<Integer> indexes = valToIndex.get(val);
      if (indexes.size() == 1) {
        valToIndex.remove(val);
      }
      final int toRemoveIndex = indexes.iterator().next(),
          lastIndexVal = vals.get(vals.size() - 1);
      if (lastIndexVal == val) {
        indexes.remove(val);
        vals.remove(vals.size() - 1);
      } else {
        indexes.remove(toRemoveIndex);
        final Set<Integer> lastValIndexes = valToIndex.get(lastIndexVal);
        lastValIndexes.remove(vals.size() - 1);
        lastValIndexes.add(toRemoveIndex);
        vals.set(toRemoveIndex, lastIndexVal);
        vals.remove(vals.size() - 1);
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
    return vals.get(random.nextInt(vals.size()));
  }
}
