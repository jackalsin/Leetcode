package linkedin._381_Insert_Delete_GetRandom_O_1_Duplicates_allowed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 8/13/2019
 */
public final class RandomizedCollectionIV implements RandomizedCollection {
  private final List<Integer> vals = new ArrayList<>();
  private final Map<Integer, Set<Integer>> valToIndex = new HashMap<>();
  private final Random rand = new Random();

  public boolean insert(int val) {
    final boolean exist = valToIndex.containsKey(val);
    valToIndex.computeIfAbsent(val, k -> new HashSet<>()).add(vals.size());
    vals.add(val);
    return !exist;
  }

  public boolean remove(int val) {
    if (!valToIndex.containsKey(val)) {
      return false;
    }
    final int lastIndex = vals.size() - 1, lastVal = vals.get(lastIndex);
    final Set<Integer> valIndexes = valToIndex.get(val),
        lastValIndexes = valToIndex.get(lastVal);
    final int toRemoveIndex = valIndexes.iterator().next();
    valIndexes.remove(toRemoveIndex);
    lastValIndexes.remove(lastIndex);
    if (lastIndex != toRemoveIndex) {
      lastValIndexes.add(toRemoveIndex);
    }
    if (valIndexes.isEmpty()) {
      valToIndex.remove(val);
    }
    swap(vals, lastIndex, toRemoveIndex);
    vals.remove(vals.size() - 1);
    return true;
  }

  public int getRandom() {
    return vals.get(rand.nextInt(vals.size()));
  }

  private static void swap(final List<Integer> vals, final int i, final int j) {
    final int tmp = vals.get(i);
    vals.set(i, vals.get(j));
    vals.set(j, tmp);
  }
}
