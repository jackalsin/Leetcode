package interviews.linkedin._007_Reverse_Integer;

public class Solution {
  public int reverse(int x) {
    if (x == 0) {
      return 0;
    }
    int sign = x > 0 ? 1 : -1;
    if (x == Integer.MIN_VALUE) {
      return 0;
    }
    x = Math.abs(x);
    int num = 0;
    while (x != 0) {
      final int curDigit = x % 10;
      if (num > Integer.MAX_VALUE / 10 || (num == Integer.MAX_VALUE / 10 && curDigit > Integer.MAX_VALUE % 10))
        return 0;
      num = num * 10 + curDigit;
      x /= 10;
    }

    return sign * num;
  }
}
