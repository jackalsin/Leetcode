package interviews.uber._359_Logger_Rate_Limiter;

import java.util.HashMap;
import java.util.Map;

public class Logger {
  private final Map<String, Integer> messageToTime = new HashMap<>();

  /**
   * Returns true if the message should be printed in the given timestamp, otherwise returns false.
   * If this method returns false, the message will not be printed.
   * The timestamp is in seconds granularity.
   */
  public boolean shouldPrintMessage(int timestamp, String message) {
    final Integer time = messageToTime.get(message);
    boolean res = false;
    if (time == null || time <= timestamp) {
      res = true;
      messageToTime.put(message, timestamp + 10);
    }
    return res;
  }
}
