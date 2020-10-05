package facebook._067_Add_Binary;

public class Solution {

  public String addBinary(String a, String b) {
    assert a.length() != 0 && b.length() != 0;
    final StringBuilder sb = new StringBuilder();
    int carry = 0;
    for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0 || carry != 0; j--, i--) {
      final int digit1 = i >= 0 ? a.charAt(i) - '0' : 0,
          digit2 = j >= 0 ? b.charAt(j) - '0' : 0;
      final int sum = digit1 + digit2 + carry;
      sb.append(sum % 2);
      carry = sum / 2;
    }
    return sb.reverse().toString();
  }

}
