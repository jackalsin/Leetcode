package _401_450._411_Minimum_Unique_Word_Abbreviation;

import java.util.ArrayList;
import java.util.List;

public class BitMapSolution implements Solution {

  private int targetLen = 0, minLen = Integer.MAX_VALUE, bitNumExclusive = 0, candidate = 0, minAbbr = 0;
  private List<Integer> dicts = new ArrayList<>();

  @Override
  public String minAbbreviation(String target, String[] dictionary) {
    targetLen = target.length();
    bitNumExclusive = 1 << targetLen;
    minLen = targetLen;
    for (final String str : dictionary) {
      if (str.length() != targetLen) {
        continue;
      }
      final int wordMask = toMask(str, target);
      dicts.add(wordMask);
      candidate |= wordMask;
    }
//    System.out.println("candidate" + "\t" + toBinaryString(candidate));
//    dicts.stream().map(BitMapSolution::toBinaryString).forEach(x -> System.out.print( x + "\t"));
//    System.out.println();
    dfs(1, 0);
//    System.out.println("minAbbr" + "\t" + toBinaryString(minAbbr));
    String result = toWord(target, minAbbr);

    return result;
  }


  /**
   * The DFS is looking for a <code>mask</code> with the shortest length that can guarantee all
   * <code>existingWordMask & mask > 0 </code>
   *
   * @param startBit
   * @param mask
   */
  private void dfs(int startBit, int mask) {
//    System.out.println("[DFS Log]\t\t" + toBinaryString(startBit) + "\t" + toBinaryString(mask));
    int abbrLen = abbrLen(mask, targetLen);
    if (abbrLen >= minLen) {
      return;
    }

    boolean isValid = true;
    for (int existingWordMask : dicts) {
      // all 0 bit will become digits, which cannot help to generate the unique. At least one of the 1 bit in target
      // must exist to keep the mask and existingWordMask different.
      if ((existingWordMask & mask) == 0) {
        isValid = false;
        break;
      }
    }

    if (isValid) {
      minLen = abbrLen;
      minAbbr = mask;
    } else {  // current start bit must exist since if not exist, the mask won't become valid.
      for (int i = startBit; i < bitNumExclusive; i <<= 1) {
        if ((i & candidate) != 0) {
          dfs(i << 1, mask + i);
        }
      }
    }

  }

  static String toWord(final String target, final int minAbbr) {
    StringBuilder sb = new StringBuilder();
    for (int i = target.length() - 1; i >= 0; ) {
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

  /**
   * Return the mask between <code>str</code> and <code>target</code>.
   * The bit 1 means different, otherwise, 0.
   *
   * @param str
   * @param target
   * @return
   */
  static int toMask(final String str, final String target) {
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
   * The definition is a bit wired here: if there is a 2-digit number in the string, it counts as 1
   * [Example 1], the mask '00001', will be 2, because eventually, it will become `4e`;
   * [Example 2], the mask '0b01_0000_0000_0001_0010', will be <code>"1a11a2a1".length() - 1</code>
   *
   * @param mask
   * @return
   */
  static int abbrLen(int mask, final int targetLen) {
    return smartAddLen(mask, targetLen);
//    return naiveAddLen(mask, targetLen);
  }

  /**
   * This algorithm is based on a such idea:
   * 1. Set the count to targetLen
   * 2. Using <code>3 & mask</code> to compare
   * 2.1 If compare result is 0, it means the corresponding position in mask it `11`, which indicates the current bit
   * is 0 and the previous bit is also 0, which means both bits are digits and can be consider as length 1.
   *
   * @param mask
   * @param targetLen
   * @return
   */
  private static int smartAddLen(final int mask, final int targetLen) {
    int count = targetLen, bitNum = 1 << targetLen;
    for (int b = 3; b < bitNum; b <<= 1) {
      if ((b & mask) == 0) {
        count--;
      }
    }
    return count;
  }


  private static int naiveAddLen(int mask, final int targetLen) {
    int count = 0, bn = 1 << targetLen;
    for (int b = 1; b < bn; ) {
      if ((mask & b) == 0)
        for (; b < bn && ((mask & b) == 0); b <<= 1) ;
      else b <<= 1;
      count++;
    }
    return count;
  }


  /**
   * Return the binary string of int <code>i</code> with leading zeros
   *
   * @param i
   * @return
   */
  private static String toBinaryString(int i) {
    return String.format("%16s", Integer.toBinaryString(i)).replace(' ', '0');
  }
}
