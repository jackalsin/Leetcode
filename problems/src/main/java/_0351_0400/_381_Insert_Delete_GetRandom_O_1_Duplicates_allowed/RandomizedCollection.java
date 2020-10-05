package _0351_0400._381_Insert_Delete_GetRandom_O_1_Duplicates_allowed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 11/9/2017.
 */
public class RandomizedCollection {
  private final List<Integer> vals;
  private final Map<Integer, Set<Integer>> index;
  private final Random random;

  /**
   * Initialize your data structure here.
   */
  public RandomizedCollection() {
    vals = new ArrayList<>();
    index = new HashMap<>();
    random = new Random();
  }

  /**
   * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
   */
  public boolean insert(int val) {
    boolean result = !index.containsKey(val);
    index.putIfAbsent(val, new HashSet<>());
    Set<Integer> curValIndex = index.get(val);
    if (result) {
      result = !curValIndex.contains(val);
    }
    curValIndex.add(vals.size());
    vals.add(val);
    return result;
  }

  /**
   * Removes a value from the collection. Returns true if the collection contained the specified element.
   */
  public boolean remove(int val) {
    if (!index.containsKey(val)) {
      return false;
    }
    Set<Integer> curValIndexSet = index.get(val);
    if (curValIndexSet.isEmpty()) {
      return false;
    }
    int removedIndex = curValIndexSet.iterator().next();
    curValIndexSet.remove(removedIndex);
    if (removedIndex != vals.size() - 1) {
      final int lastOneVal = vals.get(vals.size() - 1);
//      if (val != lastOneVal) {
      Set<Integer> lastOneValIndexSet = index.get(lastOneVal);
      final int lastOneValIndex = vals.size() - 1;
      lastOneValIndexSet.remove(lastOneValIndex);
      lastOneValIndexSet.add(removedIndex);
      vals.set(removedIndex, lastOneVal);
//      }
    }
    vals.remove(vals.size() - 1);
    return true;
  }

  /**
   * Get a random element from the collection.
   */
  public int getRandom() {
    return vals.get(random.nextInt(vals.size()));
  }
}
