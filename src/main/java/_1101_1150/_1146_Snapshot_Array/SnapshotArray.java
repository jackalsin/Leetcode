package _1101_1150._1146_Snapshot_Array;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author jacka
 * @version 1.0 on 4/3/2020
 */
public final class SnapshotArray implements Solution {
  private int snapTime = 0;
  private final Map<Integer, TreeMap<Integer, Integer>> indexToVersionToVal = new HashMap<>();

  public SnapshotArray(int length) {

  }

  public void set(int index, int val) {
    indexToVersionToVal.computeIfAbsent(index, k -> new TreeMap<>()).put(snapTime, val);
  }

  public int snap() {
    return snapTime++;
  }

  public int get(int index, int snap_id) {
    final TreeMap<Integer, Integer> snapToVal = indexToVersionToVal.get(index);
    if (snapToVal == null) {
      return 0;
    }
    final Map.Entry<Integer, Integer> e = snapToVal.floorEntry(snap_id);
    if (e == null) {
      return 0;
    }
    return e.getValue();
  }
}
