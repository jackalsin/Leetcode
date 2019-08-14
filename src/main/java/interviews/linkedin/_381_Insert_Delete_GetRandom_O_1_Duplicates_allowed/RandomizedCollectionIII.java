package interviews.linkedin._381_Insert_Delete_GetRandom_O_1_Duplicates_allowed;

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
public final class RandomizedCollectionIII implements RandomizedCollection {
  private final List<Integer> vals = new ArrayList<>();
  private final Map<Integer, Set<Integer>> valToIndexList = new HashMap<>();
  private final Random rand = new Random();

  public boolean insert(int val) {
    final boolean isExist = valToIndexList.containsKey(val);
    if (!isExist) {
      valToIndexList.put(val, new HashSet<>());
    }
    valToIndexList.get(val).add(vals.size());
    vals.add(val);
    return !isExist;
  }

  public boolean remove(int val) {
    final Set<Integer> valIndexList = valToIndexList.get(val);
    if (valIndexList == null) return false;
    final int lastVal = vals.get(vals.size() - 1), lastValIndex = vals.size() - 1,
        toRemoveIndex = valIndexList.iterator().next();
    final Set<Integer> lastValIndexList = valToIndexList.get(lastVal);
    if (val == lastVal) {
      valIndexList.remove(lastValIndex);
      vals.remove(vals.size() - 1);
      if (valIndexList.isEmpty()) {
        valToIndexList.remove(val);
      }
      return true;
    }
    swap(vals, toRemoveIndex, lastValIndex);
    lastValIndexList.remove(lastValIndex);
    lastValIndexList.add(toRemoveIndex);
    vals.remove(lastValIndex);
    valIndexList.remove(toRemoveIndex);
    if (valIndexList.isEmpty()) {
      valToIndexList.remove(val);
    }
    return true;
  }

  private static void swap(final List<Integer> vals, final int left, final int right) {
    final int tmp = vals.get(left);
    vals.set(left, vals.get(right));
    vals.set(right, tmp);
  }

  public int getRandom() {
    return vals.get(rand.nextInt(vals.size()));
  }
}
