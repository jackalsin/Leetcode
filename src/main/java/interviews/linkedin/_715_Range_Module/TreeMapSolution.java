package interviews.linkedin._715_Range_Module;

import java.util.TreeMap;

/**
 * @author jacka
 * @version 1.0 on 7/27/2019
 */
public final class TreeMapSolution implements Solution {
  /**
   * start to exclusive end
   */
  private final TreeMap<Integer, Integer> treeMap = new TreeMap<>();

  public void addRange(int left, int right) {
    // 对 left 取floor
    final Integer start = treeMap.floorKey(left), end = treeMap.floorKey(right);
    if (start == null && end == null) {
      treeMap.put(left, right);
    } else if (start != null && treeMap.get(start) >= left) {
      treeMap.put(start, Math.max(right, treeMap.get(end)));
    } else {
      treeMap.put(left, Math.max(treeMap.get(end), right));
    }
    treeMap.subMap(left, false, right, true).clear();
  }

  public boolean queryRange(int left, int right) {
    final Integer start = treeMap.floorKey(left);
    if (start == null) {
      return false;
    }
    return treeMap.get(start) >= right;
  }

  public void removeRange(int left, int right) {
    final Integer start = treeMap.floorKey(left), end = treeMap.floorKey(right);
    if (start == null && end == null) {
      return;
    }
    if (end != null && treeMap.get(end) > right) {
      treeMap.put(right, treeMap.get(end));
    }
    if (start != null && treeMap.get(start) >= left) {
      assert end != null;
      treeMap.put(start, left);
    }
    treeMap.subMap(left, true, right, false).clear();
  }
}
