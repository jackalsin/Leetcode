package linkedin._432_All_O_one_Data_Structure;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/15/18
 */
public interface AllOne {
  // TODO: Revisit

  /**
   * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
   */
  void inc(String key);

  /**
   * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
   */
  void dec(String key);

  /**
   * Returns one of the keys with maximal value.
   */
  String getMaxKey();

  /**
   * Returns one of the keys with Minimal value.
   */
  String getMinKey();
}
