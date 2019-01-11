package interviews.uber._359_Logger_Rate_Limiter;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Logger {

  private final Map<String, Queue<Integer>> messageToTimes = new HashMap<>();
  private final Queue<Message> messages = new ArrayDeque<>();

  /**
   * Returns true if the message should be printed in the given timestamp, otherwise returns false.
   * If this method returns false, the message will not be printed.
   * The timestamp is in seconds granularity.
   */
  public boolean shouldPrintMessage(int timestamp, String message) {

    // clean up
    while (!messages.isEmpty() && messages.peek().time <= timestamp - 10) {
      final Message popMessage = messages.remove();
      final Queue<Integer> times = messageToTimes.get(popMessage.message);
      times.remove();
      if (times.isEmpty()) {
        messageToTimes.remove(popMessage.message);
      }
    }

    final boolean shouldPrint = !messageToTimes.containsKey(message);
    if (shouldPrint) {
      messageToTimes.computeIfAbsent(message, x -> new ArrayDeque<>()).add(timestamp);
      messages.add(new Message(message, timestamp));
    }

    return shouldPrint;
  }

  private static final class Message {
    private final String message;
    private final int time;

    private Message(String message, int time) {
      this.message = message;
      this.time = time;
    }
  }
}
