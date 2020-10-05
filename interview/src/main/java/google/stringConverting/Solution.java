package google.stringConverting;

/**
 * size=14.6667px]第二题，给一个函数和一系列的输入输出，string convert(int number, string system) functio
 * // 123, “012X456789” -> “12X”
 * // 255, “0123456789ABCDEF” -> “FF”
 * // 7, “01” -> “111”.
 * // 7, “AB” -> “BBB”
 *
 * @author jacka
 * @version 1.0 on 1/10/2018.
 */
public final class Solution {

  public String stringConvert(int num, String pattern) {
    int mod = pattern.length();
    StringBuilder sb = new StringBuilder();
    if (num == 0) {
      return "0";
    }
    while (num != 0) {
      int digit = num % mod;
      sb.append(pattern.charAt(digit));
      num /= mod;
    }
    return sb.reverse().toString();
  }
}
