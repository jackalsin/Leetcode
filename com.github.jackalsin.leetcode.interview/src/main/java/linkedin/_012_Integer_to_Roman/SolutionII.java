package linkedin._012_Integer_to_Roman;

public final class SolutionII implements Solution {
  private static final String[] THOUSANDS = {"", "M", "MM", "MMM"}, HUNDREDS = {
      "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"
  }, TENS = {
      "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"
  }, ONES = {
      "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"
  };

  public String intToRoman(int num) {
    final int one = num % 10, ten = (num / 10) % 10, hundred = (num / 100) % 10, thousand = num / 1000;
    return THOUSANDS[thousand] + HUNDREDS[hundred] + TENS[ten] + ONES[one];
  }
}
