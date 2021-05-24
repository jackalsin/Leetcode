package _0351_0400._379_Design_Phone_Directory;

public interface PhoneDirectory {

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
