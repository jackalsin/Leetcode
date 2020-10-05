package google._359_Logger_Rate_Limiter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 4/13/2020
 */
public final class SolutionI implements Solution {
  private final Map<String, Integer> messageToTimestamp = new HashMap<>();

  public boolean shouldPrintMessage(int timestamp, String message) {
    if (messageToTimestamp.containsKey(message)) {
      final int time = messageToTimestamp.get(message);
      if (time + 10 > timestamp) {
        return false;
      }
    }
    messageToTimestamp.put(message, timestamp);
    return true;
  }
}
