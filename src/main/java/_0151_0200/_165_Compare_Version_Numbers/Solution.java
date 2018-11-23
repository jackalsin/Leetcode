package _0151_0200._165_Compare_Version_Numbers;

/**
 * @author jacka
 * @version 1.0 on 7/27/2017.
 */
public class Solution {

  public int compareVersion(String version1, String version2) {
    String[] num1 = version1.split("\\.");
    String[] num2 = version2.split("\\.");
    int len = Math.max(num1.length, num2.length);
    for(int i = 0; i < len; i++) {
      int candidate1 = i >= num1.length ? 0 : Integer.parseInt(num1[i]);
      int candidate2 = i >= num2.length ? 0 : Integer.parseInt(num2[i]);
      if (candidate1 > candidate2) {
        return 1;
      } else if (candidate1 < candidate2) {
        return -1;
      }
    }
    return 0;
  }
}
