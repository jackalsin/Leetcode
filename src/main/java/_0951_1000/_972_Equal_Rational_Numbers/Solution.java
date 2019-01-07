package _0951_1000._972_Equal_Rational_Numbers;

public class Solution {

  public boolean isRationalEqual(String S, String T) {
    final Fraction s = new Fraction(S), t = new Fraction(T);
//    System.out.println(s);
//    System.out.println(t);
    return s.equals(t);
  }

  private static final class Fraction {
    private final long fenzi, fenmu;

    private Fraction(final String s) {
      final String[] input = s.split("\\.");
      final String intStr = input[0], pointStr = input.length == 1 ? "" : input[1];
      final int intPart = Integer.parseInt(intStr), leftPara = pointStr.indexOf('('),
          rightPara = pointStr.indexOf(')');
      final String nonRepeatedStr = leftPara == -1 ? pointStr : pointStr.substring(0, leftPara),
          repeatedStr = leftPara == -1 ? "0" : pointStr.substring(leftPara + 1, rightPara);
      final int repeatedInt = repeatedStr.length() == 0 ? 0 : Integer.parseInt(repeatedStr),
          nonRepeatedInt = nonRepeatedStr.length() == 0 ? 0 : Integer.parseInt(nonRepeatedStr);
      int nonRepeatedTimes = (int) Math.pow(10, nonRepeatedStr.length()),
          repeatedTimes = (int) Math.pow(10, repeatedStr.length()) - 1;
      long fenmu = (long) nonRepeatedTimes * repeatedTimes;
      long fenzi = (long) repeatedInt; // 重复部分分子
      fenzi += (long) nonRepeatedInt * repeatedTimes;
      fenzi += (long) intPart * fenmu;

      final long gcd = gcd(fenzi, fenmu);
      this.fenzi = fenzi / gcd;
      this.fenmu = fenmu / gcd;
    }

    private static long gcd(long a, long b) {
      if (a < b) {
        return gcd(b, a);
      }
      while (b != 0) {
        long c = a % b;
        a = b;
        b = c;
      }
      return a;
    }

    public boolean equals(Object o) {
      if (!(o instanceof Fraction)) {
        return false;
      }
      final Fraction that = (Fraction) o;
      return fenzi == that.fenzi && fenmu == that.fenmu;
    }

    @Override
    public String toString() {
      return "Fraction{" +
          "fenzi=" + fenzi +
          ", fenmu=" + fenmu +
          '}';
    }
  }
}
