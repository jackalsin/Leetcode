package apple._380_Insert_Delete_GetRandom_O_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author jacka
 * @version 1.0 on 2/22/2021
 */
public final class RandomizedSetI implements RandomizedSet {

  private final Random random = new Random();
  private final Map<Integer, Integer> valToIndex = new HashMap<>();
  private final List<Integer> vals = new ArrayList<>();

  public boolean insert(int val) {
    if (valToIndex.containsKey(val)) {
      return false;
    }
    valToIndex.put(val, vals.size());
    vals.add(val);
    return true;
  }

  public boolean remove(int val) {
    if (!valToIndex.containsKey(val)) return false;
    final int index = valToIndex.get(val);
    if (index == valToIndex.size() - 1) {
      valToIndex.remove(val);
      vals.remove(vals.size() - 1);
    } else {
      final int lastVal = vals.get(vals.size() - 1),
          lastIndex = vals.size() - 1;
      swap(vals, lastIndex, index);
      valToIndex.put(lastVal, index);
      valToIndex.remove(val);
      vals.remove(lastIndex);
    }
    return true;
  }

  private static void swap(final List<Integer> list, final int i, final int j) {
    final int tmp = list.get(i);
    list.set(i, list.get(j));
    list.set(j, tmp);
  }

  public int getRandom() {
    return vals.get(random.nextInt(vals.size()));
  }

}
