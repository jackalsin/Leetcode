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
 * @version 1.0 on 8/12/2019
 */
public final class RandomizedCollectionII implements RandomizedCollection {
  private final Map<Integer, Set<Integer>> valueToIndex = new HashMap<>();
  private final List<Integer> vals = new ArrayList<>();
  private final Random rand = new Random();

  public boolean insert(int val) {
    final boolean isExist = valueToIndex.containsKey(val);
    if (!isExist) {
      valueToIndex.put(val, new HashSet<>());
    }
    valueToIndex.get(val).add(vals.size());
    vals.add(val);
    return !isExist;
  }

  public boolean remove(int val) {
    if (!valueToIndex.containsKey(val)) return false;
    final Set<Integer> valIndexList = valueToIndex.get(val);
    final int valIndex = valIndexList.iterator().next(), lastVal = vals.get(vals.size() - 1),
        lastValIndex = vals.size() - 1;
    final Set<Integer> lastValIndexList = valueToIndex.get(lastVal);
    if (lastVal == val) {
      if (valIndexList.size() == 1) {
        valueToIndex.remove(val);
      } else {
        valIndexList.remove(lastValIndex);
      }
      vals.remove(lastValIndex);
      return true;
    }
    swap(vals, valIndex, lastValIndex);
    if (valIndexList.size() == 1) {
      valueToIndex.remove(val);
    } else {
      valIndexList.remove(valIndex);
    }
    lastValIndexList.remove(lastValIndex);
    lastValIndexList.add(valIndex);
    vals.remove(lastValIndex);
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
