package interviews.linkedin._715_Range_Module;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author jacka
 * @version 1.0 on 9/14/2019
 */
public final class TreeMapSolutionI implements Solution {
  private final TreeMap<Integer, Integer> treeMap = new TreeMap<>();

  public void addRange(int left, int right) {
    --right;
    final Map.Entry<Integer, Integer> leftEntry = treeMap.floorEntry(left),
        rightEntry = treeMap.floorEntry(right + 1);
    final int[] toInsert = {left, right};
    // update left entry
    if (leftEntry != null && leftEntry.getValue() >= left) {
      toInsert[0] = leftEntry.getKey();
    }
    if (rightEntry != null && rightEntry.getValue() > right) {
      toInsert[1] = rightEntry.getValue();
    }
    treeMap.put(toInsert[0], toInsert[1]);
    treeMap.subMap(left, false, right + 1, true).clear();
  }

  public boolean queryRange(int left, int right) {
    --right;
    final Map.Entry<Integer, Integer> entry = treeMap.floorEntry(left);
    if (entry == null) {
      return false;
    }
    final int start = entry.getKey(), end = entry.getValue();
    return start <= left && right <= end;
  }

  public void removeRange(int left, int right) {
    --right;
//    final Integer start = treeMap.floorKey(left), end = treeMap.floorKey(right);
    final Map.Entry<Integer, Integer> leftEntry = treeMap.floorEntry(left), rightEntry = treeMap.floorEntry(right);
    if (leftEntry == null && rightEntry == null) {
      return;
    }
    if (leftEntry != null && leftEntry.getValue() >= left) {
      treeMap.put(leftEntry.getKey(), left - 1);
    }
    if (rightEntry != null && rightEntry.getValue() > right) {
      treeMap.put(right + 1, rightEntry.getValue());
    }
    treeMap.subMap(left, true, right, true).clear();
  }
}
