package _0351_0400._359_Logger_Rate_Limiter;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author jacka
 * @version 1.0 on 10/12/2017.
 */
public class Logger {

  private final TreeMap<Integer, Set<String>> queue;

  /**
   * Initialize your data structure here.
   */
  public Logger() {
    queue = new TreeMap<>();
  }

  /**
   * Returns true if the message should be printed in the given timestamp, otherwise returns false.
   * If this method returns false, the message will not be printed. The timestamp is in seconds
   * granularity.
   */
  public boolean shouldPrintMessage(int timestamp, String message) {
    Map.Entry<Integer, Set<String>> firstEntry = queue.firstEntry();
    if (firstEntry != null && firstEntry.getKey() <= timestamp - 10) {
      queue.remove(firstEntry.getKey());
    }
    boolean result = true;
    for (Map.Entry<Integer, Set<String>> entry : queue.entrySet()) {
      Set<String> candidates = entry.getValue();
      if (candidates != null && candidates.contains(message)) {
        result = false;
        break;
      }
    }
    if (result) {
      queue.putIfAbsent(timestamp, new HashSet<>());
      queue.get(timestamp).add(message);
    }
    return result;
  }
}
