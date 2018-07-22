package _601_650._639_Decode_Ways_II;

public final class SolutionII implements Solution {
  private static final int MOD = 1_000_000_000 + 7;

  public int numDecodings(String s) {
    if (s.length() == 0) {
      return 0;
    }
    long prev = 1, prevPrev = 0;
    for (int i = 0; i < s.length(); i++) {
      long cur = 0;
      final char chr = s.charAt(i);
      // add single digit possible
      if (chr == '*') {
        cur = (prev * 9 % MOD);
      } else if (chr != '0') {
        cur = prev;
      }

      // double digit;
      if (i != 0) {
        final char prevChar = s.charAt(i - 1);
        if (prevChar == '*') {
          if (chr == '*') {
            cur += (prevPrev * 15 % MOD); // 11- 19 + 21 - 26
          } else {// e.g. *2
            // *0 -> 10, 20
            // *9 -> 19
            cur += prevPrev * ((6 >= chr - '0') ? 2 : 1) % MOD;
          }
        } else if (prevChar == '1') {
          if (chr == '*') { // 1* -> 11 ~ 19
            cur += (prevPrev * 9) % MOD;
          } else {
            cur += prevPrev;
          }
        } else if (prevChar == '2') {
          if (chr == '*') {
            cur += (prevPrev * 6) % MOD;
          } else if (chr <= '6') {
            cur += prevPrev;
          }
        }
        cur %= MOD;
      }

      prevPrev = prev;
      prev = cur;
    }

    return (int) prev;
  }


}
