package uber._342_Power_of_Four;

/**
 * @author jacka
 * @version 1.0 on 3/23/2018.
 */
public class Solution {

  public boolean isPowerOfFour(int num) {
    if (num <= 0) {
      return false;
    }
    if ((num & (num - 1)) != 0) {
      return false;
    }

    return (num & 0x5555_5555) != 0;
  }
}
