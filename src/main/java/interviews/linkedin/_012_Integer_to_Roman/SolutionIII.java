package interviews.linkedin._012_Integer_to_Roman;

/**
 * @author jacka
 * @version 1.0 on 8/3/2019
 */
public final class SolutionIII implements Solution {
  //  I             1
//  V             5
//  X             10
//  L             50
//  C             100
//  D             500
//  M             1000;
  private static final String[] THOUSANDS = {
      "", "M", "MM", "MMM"
  }, HUNDREDS = {
      "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"
  }, TENS = {
      "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"
  }, ONES = {
      "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"
  };

  public String intToRoman(int num) {
    final StringBuilder sb = new StringBuilder();
    sb.append(THOUSANDS[num / 1000]);
    sb.append(HUNDREDS[(num / 100) % 10]);
    sb.append(TENS[(num / 10) % 10]);
    sb.append(ONES[num % 10]);
    return sb.toString();
  }
}
