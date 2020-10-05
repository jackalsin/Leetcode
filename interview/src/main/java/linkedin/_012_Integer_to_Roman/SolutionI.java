package linkedin._012_Integer_to_Roman;

public final class SolutionI implements Solution {
  private static final String[] ONES = {
      "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"
  }, TENS = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}, HUNDREDS = {
      "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
      THOUSANDS = {"", "M", "MM", "MMM"};

  public String intToRoman(int num) {
    final int ones = num % 10, tens = num / 10 % 10, hundreds = num / 100 % 10,
        thousands = num / 1000 % 10;
    return THOUSANDS[thousands] + HUNDREDS[hundreds] + TENS[tens] + ONES[ones];
  }
}
