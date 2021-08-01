package doordash._359_Logger_Rate_Limiter;

import java.util.HashMap;
import java.util.Map;

public final class SolutionII implements Solution {
  private final Map<String, Integer> lastTimestamp = new HashMap<>();

  public boolean shouldPrintMessage(int timestamp, String message) {
    if (lastTimestamp.containsKey(message)) {
      final long prevTime = lastTimestamp.get(message);
      if (prevTime + 10 > timestamp) return false;
    }
    lastTimestamp.put(message, timestamp);
    return true;
  }
}
