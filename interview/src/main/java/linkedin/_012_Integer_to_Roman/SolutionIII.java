package linkedin._012_Integer_to_Roman;

/**
 * @author jacka
 * @version 1.0 on 8/3/2019
 */
public final class SolutionIII implements Solution {
  private static final String[] ONES = {
      "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"
  }, TENS = {
      "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"
  }, HUNDREDS = {
      "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"
  }, THOUSANDS = {
      "", "M", "MM", "MMM"
  };

  public String intToRoman(int num) {
    final StringBuilder sb = new StringBuilder();
    sb.append(THOUSANDS[num / 1000]);
    num -= num / 1000 * 1000;
    sb.append(HUNDREDS[num / 100]);
    num -= num / 100 * 100;
    sb.append(TENS[num / 10]);
    num -= num / 10 * 10;
    sb.append(ONES[num]);
    return sb.toString();
  }
}
