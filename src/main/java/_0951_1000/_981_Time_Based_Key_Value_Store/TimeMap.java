package _0951_1000._981_Time_Based_Key_Value_Store;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public final class TimeMap {

  private Map<String, TreeMap<Integer, String>> keyToTimeToValue = new HashMap<>();

  /**
   * Initialize your data structure here.
   */
  public TimeMap() {

  }

  public void set(String key, String value, int timestamp) {
    keyToTimeToValue.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
  }

  public String get(String key, int timestamp) {
    final TreeMap<Integer, String> treeMap = keyToTimeToValue.get(key);
    if (treeMap == null) return "";
    final Map.Entry<Integer, String> entry = treeMap.floorEntry(timestamp);
    if (entry == null) return "";
    return entry.getValue();
  }
}
