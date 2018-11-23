package _0451_0500._484_Find_Permutation;

public class NaiveSolution implements Solution {
  private static final char D = 'D';
  private static final char I = 'I';

  public int[] findPermutation(String s) {
    final char[] sArray = s.toCharArray();
    final int[] res = new int[s.length() + 1];
    int start = 1, i = 0, sPtr = 0; // max = s.length()
    boolean isFirstAdd = true;
    while (i < res.length) {
      final int dCount = getCount(sArray, sPtr, D);
      sPtr += dCount;

      for (int j = 0; j <= dCount; j++) {
        res[i] = start + dCount - j;
        i++;
      }
      start += dCount + 1;


      int iCount = getCount(sArray, sPtr, I);
      sPtr += iCount;
      iCount -= 1;
      while (iCount-- > 0) {
        res[i++] = start++;
      }

      if (i == res.length - 1) {
        res[i++] = start++;
      }
    }

    return res;
  }

  private int getCount(char[] sArray, int start, char d) {
    int count = 0;
    for (int i = start; i < sArray.length; i++) {
      if (sArray[i] == d) {
        count++;
      } else {
        break;
      }
    }
    return count;
  }
}
