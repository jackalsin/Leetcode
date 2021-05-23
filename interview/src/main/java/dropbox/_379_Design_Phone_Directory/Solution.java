package dropbox._379_Design_Phone_Directory;

/**
 * @author jacka
 * @version 1.0 on 5/23/2021
 */
public interface Solution {

  /**
   * Provide a number which is not assigned to anyone.
   *
   * @return - Return an available number. Return -1 if none is available.
   */
  int get();

  /**
   * Check if a number is available or not.
   */
  boolean check(int number);

  /**
   * Recycle or release a number.
   */
  void release(int number);
}
