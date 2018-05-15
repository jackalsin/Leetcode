package interviews.pinterest._067_Add_Binary;

public class Solution {
  /**
   * 294 / 294 test cases passed.
   * Status: Accepted
   * Runtime: 4 ms
   *
   * @param a
   * @param b
   * @return
   */
  public String addBinary(String a, String b) {
    final StringBuilder sb = new StringBuilder();
    int carry = 0;
    for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0 || carry != 0; i--, j--) {
      int aDigit = i >= 0 ? (a.charAt(i) - '0') : 0, bDigit = j >= 0 ? (b.charAt(j) - '0') : 0,
          curDigit = aDigit + bDigit + carry;
      if (curDigit >= 2) {
        curDigit -= 2;
        carry = 1;
      } else {
        carry = 0;
      }
      sb.append(curDigit);
    }
    return sb.reverse().toString();
  }
}
