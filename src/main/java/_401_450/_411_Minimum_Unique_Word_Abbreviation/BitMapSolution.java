package _401_450._411_Minimum_Unique_Word_Abbreviation;

import java.util.ArrayList;
import java.util.List;

public class BitMapSolution implements Solution {

  private int targetLen = 0, minLen = Integer.MAX_VALUE, bitNum = 0, candidate = 0, minAbbr = 0;
  private List<Integer> dicts = new ArrayList<>();

  @Override
  public String minAbbreviation(String target, String[] dictionary) {
    targetLen = target.length();
    bitNum = 1 << targetLen;

    for (final String str : dictionary) {
      if (str.length() != targetLen) {
        continue;
      }
      final int wordMask = getWordMask(str, target);
      dicts.add(wordMask);
      candidate |= wordMask;
    }
    System.out.println("candidate" + "\t" + Integer.toBinaryString(candidate));
    dicts.stream().map(Integer::toBinaryString).forEach(System.out::println);
    dfs(1, 0);
    System.out.println("minAbbr" + "\t" + Integer.toBinaryString(minAbbr));
    String result = getWordFromMask(target, minAbbr);

    return result;
  }

  static String getWordFromMask(final String target, final int minAbbr) {
    StringBuilder sb = new StringBuilder();
    for (int i = target.length() - 1; i >= 0;) {
      if ((minAbbr & (1 << i)) == 0) { // start count how many zeros
        int j = i;
        while (i >= 0 && (minAbbr & (1 << i)) == 0) i--; // either ends -1 or the 1 bit
        sb.append(j - i);
      } else {
        sb.append(target.charAt(target.length() - 1 - i--));
      }
    }
    return sb.toString();
  }

  private void dfs(int startBit, int mask) {
    int abbrLen = abbrLen(mask, targetLen);
    if (abbrLen >= minLen) {
      return;
    }

    boolean isValid = true;
    for (int curWordMask : dicts) {
      if ((curWordMask & mask) == 0) {
        isValid = false;
        break;
      }
    }

    if (isValid) {
      minLen = abbrLen;
      minAbbr = mask;
    } else {
      for (int i = startBit; i < bitNum; i<<=1) {
        if ((i & candidate) != 0) {
          dfs(startBit << 1, mask + i); // don't understand
        }
      }
    }

  }


  /**
   * Return the mask between <code>str</code> and <code>target</code>.
   * The bit 1 means different, otherwise, 0.
   *
   * @param str
   * @param target
   * @return
   */
  static int getWordMask(final String str, final String target) {
    assert str.length() == target.length();
    int word = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) != target.charAt(i)) {
        word |= 1 << (str.length() - 1 - i);
      }
    }
    return word;
  }

  /**
   * Return the abbr length based on the mask.
   * For example, the mask '00001', will be 2, because eventually, it will become `4e`.
   * @param mask
   * @return
   */
  static int abbrLen(int mask, final int targetLen) {
//    int count = targetLen;
//    final int bitNum = 1 << targetLen;
//    for (int b = 0; b < bitNum; b <<= 1) {
//      if ((b & mask) == 0) {
//        count--;
//      }
//    }
//    return count;

    int count = 0, bn = 1 << targetLen;
    for (int b = 1; b < bn;) {
      if ((mask & b) == 0)
        for (; b < bn && ((mask & b) == 0); b <<= 1);
      else b <<= 1;
      count ++;
    }
    return count;
  }

}
