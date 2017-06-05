package _051_100._067_Add_Binary;

/**
 * @author jacka
 * @version 1.0 on 4/26/2017.
 */
public class Solution {
  public String addBinary(String a, String b) {
    if (a == null || b == null || a.isEmpty() || b.isEmpty()) {
      return "";
    }
    int aLen = a.length();
    int bLen = b.length();
    int resultLen = Math.max(aLen, bLen) + 1;
    int[] result = new int[resultLen];

    for (int offset = 0; offset < result.length; offset++) {
      int resultIndex = resultLen - 1 - offset;
      int aContribution = (aLen - 1 - offset >= 0) ? a.charAt(aLen - 1 - offset) - '0': 0;
      int bContribution = (bLen - 1 - offset >= 0) ? b.charAt(bLen - 1 - offset) - '0': 0;
      int cur = result[resultIndex] + aContribution + bContribution;
      if (cur >= 2) {
        result[resultIndex - 1]++;
      }
      result[resultIndex] = cur % 2;
    }
    int startIndex = result[0] == 0 ? 1 :0;
    StringBuilder sb = new StringBuilder();
    for (int i = startIndex; i < resultLen; i++) {
      sb.append(result[i]);
    }
    return sb.toString();
  }

}
