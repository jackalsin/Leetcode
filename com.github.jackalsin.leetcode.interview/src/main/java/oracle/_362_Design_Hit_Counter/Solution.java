package oracle._362_Design_Hit_Counter;

/**
 * @author jacka
 * @version 1.0 on 10/14/2019
 */
public interface Solution {
  /**
   * Record a hit.
   *
   * @param timestamp - The current timestamp (in seconds granularity).
   */
  void hit(int timestamp);

  /**
   * Return the number of hits in the past 5 minutes.
   *
   * @param timestamp - The current timestamp (in seconds granularity).
   */
  int getHits(int timestamp);
}
