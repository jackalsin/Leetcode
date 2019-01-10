package interviews.uber._381_Insert_Delete_GetRandom_O_1_Duplicates_allowed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * For more detailed information, check
 * https://jackalsin.gitbooks.io/algorithm/content/leetcode-solution/381.html
 */
public class RandomizedCollection {

  // 不可以用List，很难保最大的就是结尾
  private final Map<Integer, Set<Integer>> valToIndex = new HashMap<>();
  private final List<Integer> vals = new ArrayList<>();
  private final Random rand = new Random();

  /**
   * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
   */
  public boolean insert(int val) {
    final Set<Integer> prevSet = valToIndex.putIfAbsent(val, new HashSet<>());
    valToIndex.get(val).add(vals.size());
    vals.add(val);
    return prevSet == null;
  }

  /**
   * Removes a value from the collection. Returns true if the collection contained the specified element.
   */
  public boolean remove(int val) {
    if (!valToIndex.containsKey(val)) {
      return false;
    }
    final Set<Integer> curList = valToIndex.get(val);
    final int toRemoveIndex = curList.iterator().next();
    curList.remove(toRemoveIndex);
    if (curList.isEmpty()) {
      valToIndex.remove(val);
    }

    if (toRemoveIndex == vals.size() - 1) {
      vals.remove(toRemoveIndex);
      return true;
    }
    final int lastValIndex = vals.size() - 1, lastVal = vals.get(lastValIndex);
    final Set<Integer> lastValIndexSet = valToIndex.get(lastVal);
    lastValIndexSet.remove(lastValIndex);
    lastValIndexSet.add(toRemoveIndex);
    swap(vals, toRemoveIndex, lastValIndex);
    vals.remove(lastValIndex);
    return true;
  }

  private static void swap(final List<Integer> list, int i, int j) {
    final int tmp = list.get(i);
    list.set(i, list.get(j));
    list.set(j, tmp);
  }

  /**
   * Get a random element from the collection.
   */
  public int getRandom() {
    return vals.get(rand.nextInt(vals.size()));
  }
}
