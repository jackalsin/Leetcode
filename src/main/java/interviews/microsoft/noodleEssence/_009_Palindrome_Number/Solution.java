package interviews.microsoft.noodleEssence._009_Palindrome_Number;

public class Solution {
  public boolean isPalindrome(int x) {
    if (x < 0) {
      return false;
    } else if (x == 0) {
      return true;
    }
    final int len = getLen(x);
    for (int left = len - 1, right = 0; left > right; left -= 2) {
      final int leftExp = getExp(left);
      final int leftDigit = x / leftExp, rightDigit = x % 10;
      if (leftDigit != rightDigit) {
        return false;
      }
      x = (x - leftDigit * leftExp) / 10;
    }
    return true;
  }

  private static int getExp(int left) {
    int res = 1;
    while (left-- > 0) {
      res *= 10;
    }
    return res;
  }

  private static int getLen(int x) {
    int len = 0;
    while (x != 0) {
      x /= 10;
      len++;
    }
    return len;
  }
}
