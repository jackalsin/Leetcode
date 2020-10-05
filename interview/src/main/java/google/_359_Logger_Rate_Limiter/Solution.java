package google._359_Logger_Rate_Limiter;

/**
 * @author jacka
 * @version 1.0 on 4/13/2020
 */
public interface Solution {
  /**
   * Returns true if the message should be printed in the given timestamp, otherwise returns false.
   * If this method returns false, the message will not be printed.
   * The timestamp is in seconds granularity.
   */
  boolean shouldPrintMessage(int timestamp, String message);
}
