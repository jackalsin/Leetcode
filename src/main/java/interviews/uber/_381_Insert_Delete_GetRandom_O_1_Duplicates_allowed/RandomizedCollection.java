package interviews.uber._381_Insert_Delete_GetRandom_O_1_Duplicates_allowed;

import java.util.*;

public class RandomizedCollection {
  private final Map<Integer, Set<Integer>> valToIndex = new HashMap<>();
  private final List<Integer> values = new ArrayList<>();
  private final Random random = new Random();

  /**
   * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
   */
  public boolean insert(int val) {
    final boolean res = !valToIndex.containsKey(val);
    final Set<Integer> valIndex = valToIndex.getOrDefault(val, new HashSet<>());
    valIndex.add(values.size());
    values.add(val);
    valToIndex.put(val, valIndex);
    return res;
  }

  /**
   * Removes a value from the collection. Returns true if the collection contained the specified element.
   */
  public boolean remove(int val) {
    if (valToIndex.containsKey(val)) {
      final Set<Integer> valIndexSet = valToIndex.get(val);
      final int valIndex = valIndexSet.iterator().next(), lastValIndex = values.size() - 1,
          lastVal = values.get(values.size() - 1);
      if (val == lastVal) {
        valIndexSet.remove(lastValIndex);
        values.remove(lastValIndex);
      } else {
        final Set<Integer> lastValIndexSet = valToIndex.get(lastVal);
        // delete from index set
        lastValIndexSet.remove(lastValIndex);
        lastValIndexSet.add(valIndex);
        valIndexSet.remove(valIndex);

        // delete form value list
        values.remove(lastValIndex);
        values.set(valIndex, lastVal);
      }

      if (valIndexSet.isEmpty()) {
        valToIndex.remove(val);
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
    final int i = random.nextInt(values.size());
    return values.get(i);
  }
}
