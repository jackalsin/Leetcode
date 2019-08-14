package interviews.linkedin._381_Insert_Delete_GetRandom_O_1_Duplicates_allowed;

public interface RandomizedCollection {

  /**
   * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
   */
  boolean insert(int val);

  /**
   * Removes a value from the collection. Returns true if the collection contained the specified element.
   */
  boolean remove(int val);

  /**
   * Get a random element from the collection.
   */
  int getRandom();
}
