package apple._380_Insert_Delete_GetRandom_O_1;

/**
 * @author jacka
 * @version 1.0 on 2/22/2021
 */
public interface RandomizedSet {

  /**
   * Inserts a value to the set. Returns true if the set did not already contain the specified element.
   */
   boolean insert(int val);

  /**
   * Removes a value from the set. Returns true if the set contained the specified element.
   */
   boolean remove(int val);

  /**
   * Get a random element from the set.
   */
   int getRandom();
}
