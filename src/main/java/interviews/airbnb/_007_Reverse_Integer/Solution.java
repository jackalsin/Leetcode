package interviews.airbnb._007_Reverse_Integer;

public class Solution {
  public int reverse(int x) {
    if (x == Integer.MIN_VALUE) {
      return 0;
    } else if (x < 0) {
      return -reverse(-x);
    }

    int res = 0;
    while (x != 0) {
      if (res > Integer.MAX_VALUE / 10) {
        return 0;
      } else if (res == Integer.MAX_VALUE / 10 && x > Integer.MAX_VALUE % 10) {
        return 0;
      }
      res = res * 10 + x % 10;
      x /= 10;
    }
    return res;
  }
}
