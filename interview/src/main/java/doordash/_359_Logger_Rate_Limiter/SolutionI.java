package doordash._359_Logger_Rate_Limiter;

import java.util.HashMap;
import java.util.Map;

public final class SolutionI implements Solution {
  private final Map<String, Integer> messageToId = new HashMap<>();
  private static final int INTERVAL = 10;

  public boolean shouldPrintMessage(int timestamp, String message) {
    final int nextAllowTime = messageToId.getOrDefault(message, timestamp - INTERVAL) + INTERVAL;
    if (timestamp < nextAllowTime) return false;
    messageToId.put(message, timestamp);
    return true;
  }
}
