package _0351_0400._352_Data_Stream_as_Disjoint_Intervals;

import definition.Interval;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author jacka
 * @version 1.0 on 10/8/2017.
 */
public class SummaryRanges {
  private final TreeMap<Integer, Interval> treeMap;
  /** Initialize your data structure here. */
  public SummaryRanges() {
    treeMap = new TreeMap<>();
  }

  public void addNum(int val) {
    if (treeMap.containsKey(val)) return;
    Integer lo = treeMap.lowerKey(val);
    Integer hi = treeMap.higherKey(val);
    Interval lowInterval = lo == null ? null : treeMap.get(lo);
    Interval highInterval = hi == null ? null :  treeMap.get(hi);
    if (lo != null && hi != null && lowInterval.end + 1 == val && hi == val + 1) {
      lowInterval.end = highInterval.end;
      treeMap.remove(hi);
    } else if (lo != null && lowInterval.end + 1 >= val) {
      lowInterval.end = Math.max(val, lowInterval.end);
    } else if (hi != null && hi == val + 1) {
      treeMap.remove(hi);
      treeMap.put(val, new Interval(val, highInterval.end));
    } else {
      treeMap.put(val, new Interval(val, val));
    }
  }

  public List<Interval> getIntervals() {
    return new ArrayList<>(treeMap.values());
  }
}
