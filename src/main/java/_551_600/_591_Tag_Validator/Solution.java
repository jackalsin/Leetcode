package _551_600._591_Tag_Validator;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 10/30/2017.
 */
public class Solution {
  /**
   *
   * @param code
   * @return
   */
  public boolean isValid(String code) {
    return false;
  }

  static int isValidTag(final char[] code, int leftStart, int rightEnd) {
    int firstTagLen = 0;
    for (int i = 0; i < 10; i++) {
      firstTagLen++;
      if (i == 9) {
        return -1;
      } else if (i == 0 && code[i] == '<') {
        return -1;
      } else if (code[i] == '>') {
        break;
      } else {
        if ('A' > code[i] && code[i] > 'Z') {
          return -1;
        }
      }
    }
    if (code.length - firstTagLen - 1 < 0) {
      return -1;
    }
    for (int i = code.length - 1; i >= code.length - firstTagLen - 1; i--) {
      if (i == code.length - 1) {
        if (code[i] != '>') {
          return -1;
        }
      } else if (i == code.length - firstTagLen - 1) {
        if (code[i] != '<') {
          return -1;
        }
      } else if (i == code.length - firstTagLen - 2) {
        if (code[i] != '\\') {
          return -1;
        }
      }
    }

    if (!subArrayEquals(code, 1, firstTagLen - 1, code.length - firstTagLen - 3, code.length
        - 2)) {
      return -1;
    }
    return firstTagLen;
  }

  private static boolean subArrayEquals(final char[] chars, final int leftStart, final int leftEnd,
                                        final int rightStart, final int rightEnd) {
    assert leftEnd >= leftStart;
    assert rightEnd >= rightStart;
    if (leftEnd - leftStart != rightEnd - rightStart) {
      return false;
    } else {
      for (int i = 0; i <= leftEnd; i++) {
        if (chars[leftStart + i] != chars[rightStart + i]) {
          return false;
        }
      }
      return true;
    }
  }
}
