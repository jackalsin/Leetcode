package _0351_0400._380_Insert_Delete_GetRandom_O_1;

import java.util.*;

/**
 * @author jacka
 * @version 1.0 on 11/9/2017.
 */
public class RandomizedSet {
  /* All the values currently in the set */
  private final List<Integer> nums;
  /* vals to index */
  private final Map<Integer, Integer> locations;
  private final Random random;

  /**
   * Initialize your data structure here.
   */
  public RandomizedSet() {
    nums = new ArrayList<>();
    locations = new HashMap<>();
    random = new Random();
  }

  /**
   * Inserts a value to the set. Returns true if the set did not already contain the specified element.
   */
  public boolean insert(int val) {
    boolean contains = locations.containsKey(val);
    if (contains) return false;
    nums.add(val);
    locations.put(val, nums.size() - 1);
    return true;
  }

  /**
   * Removes a value from the set. Returns true if the set contained the specified element.
   */
  public boolean remove(int val) {
    final boolean contains = locations.containsKey(val);
    if (!contains) {
      return false;
    }
    int location = locations.get(val);
    if (location != nums.size() - 1) {
      // swap to the last one
      final int lastOneVal = nums.get(nums.size() - 1);
      nums.set(location, lastOneVal);
      locations.put(lastOneVal, location);
    }
    nums.remove(nums.size() - 1);
    locations.remove(val);
    return true;
  }

  /**
   * Get a random element from the set.
   */
  public int getRandom() {
    return nums.get(random.nextInt(nums.size()));
  }
}
