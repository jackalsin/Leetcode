package _351_400._393_UTF_8_Validation;

/**
 * @author jacka
 * @version 1.0 on 11/10/2017.
 */
public class Solution {
  public boolean validUtf8(int[] data) {
    int count = 0;
    for (int dataChild : data) {
      if (count == 0) {
        if ((dataChild >> 5) == 0b110) count = 1;
        else if ((dataChild >> 4) == 0b1110) count = 2;
        else if ((dataChild >> 3) == 0b11110) count = 3;
        else if ((dataChild >> 7) != 0) return false;
      } else {
        if ((dataChild >> 6) != 0b10) {
          return false;
        }
        count--;
      }
    }
    return count == 0;
  }
}
