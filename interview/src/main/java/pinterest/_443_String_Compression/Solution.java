package pinterest._443_String_Compression;

public class Solution {

  private int arrayPointer = 0;

  /**
   * Time Complexity: O(N)
   * Space Complexity: O(N)
   * <p>
   * 70 / 70 test cases passed.
   * Status: Accepted
   * Runtime: 8 ms
   *
   * @param chars
   * @return
   */
  public int compress(char[] chars) {
    if (chars.length <= 1) {
      return chars.length;
    }
    char curVal = chars[0];
    int curCount = 1;
    for (int i = 1; i < chars.length; i++) {
      if (curVal == chars[i]) {
        curCount++;
      } else {
        // update array
        updateArray(chars, curVal, curCount);
        curVal = chars[i];
        curCount = 1;
      }
    }
    if (curCount != 0) {
      updateArray(chars, curVal, curCount);
    }
    return arrayPointer;
  }

  private void updateArray(char[] chars, char curVal, int curCount) {
    chars[arrayPointer++] = curVal;
    if (curCount != 1) {
      char[] digits = String.valueOf(curCount).toCharArray();
      System.arraycopy(digits, 0, chars, arrayPointer, digits.length);
      arrayPointer += digits.length;
    }
  }

}
