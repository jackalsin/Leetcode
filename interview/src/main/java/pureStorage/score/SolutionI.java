package pureStorage.score;

/**
 * @author jacka
 * @version 1.0 on 10/9/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int getScore(int num) {
    final String numStr = String.valueOf(num);
    final char[] chars = numStr.toCharArray();
    int s1 = getScore1(numStr);
    int s2 = getScore2(chars);
    int s3 = getScore3(chars);
    int s4 = getScore4(num);
    int s5 = getScore5(num);
    return s1 + s2 + s3 + s4 + s5;
  }

  static int getScore5(int num) {
    int res = 0;
    while (num != 0) {
      final int curDigit = num % 10;
      num /= 10;
      if (curDigit % 2 == 0) {
        res += 3;
      }
    }
    return res;
  }

  static int getScore4(final int num) {
    return num % 3 == 0 ? 4 : 0;
  }

  static int getScore3(final char[] chars) {
    if (chars.length == 0) {
      return 0;
    }
    int res = 0, curLen = 1;
    for (int i = 1; i < chars.length; ++i) {
      if (chars[i] == chars[i - 1] - 1) {
        curLen++;
      } else {
        res += curLen * curLen;
        curLen = 1;
      }
    }
    res += curLen * curLen;
    return res;
  }

  static int getScore2(final char[] chars) {
    int res = 0;
    for (int i = 1; i < chars.length; ++i) {
      if (chars[i] == '2' && chars[i - 1] == '2') {
        res += 6;
      }
    }
    return res;
  }

  static int getScore1(String numStr) {
    int res = 0;
    for (final char chr : numStr.toCharArray()) {
      if (chr == '7') {
        res += 5;
      }
    }
    return res;
  }
}
