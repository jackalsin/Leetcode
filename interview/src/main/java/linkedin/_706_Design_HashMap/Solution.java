package linkedin._706_Design_HashMap;

public interface Solution {

  /**
   * value will always be non-negative.
   */
  void put(int key, int value);

  /**
   * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
   */
  int get(int key);

  /**
   * Removes the mapping of the specified value key if this map contains a mapping for the key
   */
  void remove(int key);
}
