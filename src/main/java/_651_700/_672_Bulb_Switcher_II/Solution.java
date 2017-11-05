package _651_700._672_Bulb_Switcher_II;

/**
 * @author jacka
 * @version 1.0 on 10/30/2017.
 */
public class Solution {
  public int flipLights(int n, int m) {
    if (n == 0 || m == 0) return 1;
    if (m >= 3) {
      if (n >= 3) return 8;
      else if (n == 2) return 4;
      else {  // if (n == 1)
         return 2;
      }
    } else if (m == 2) {
      if (n >= 3) return 7;
      else if (n == 2) return 4;
      else {  // if (n == 1) {
        return 2;
      }
    } else { // m == 1
      if (n >= 3) return 4;
      else if (n == 2) return 3; // no 0, 0
      else {  //(n == 1)
        return 2;
      }
    }
  }
}
