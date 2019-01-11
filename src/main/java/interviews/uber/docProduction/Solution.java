package interviews.uber.docProduction;

public class Solution {
  public int docProduction(final String a, final String b) {
    if (a == null) {
      throw new NullPointerException();
    }
    if (b == null) {
      throw new NullPointerException();
    }

    assert a.length() == b.length();
    int res = 0;
    for (int i = 0; i < a.length(); i++) {
      res += getValue(a.charAt(i)) * getValue(b.charAt(i));
    }
    return res;
  }


  private static int getValue(char chr) {
    return chr - 'a' + 1;
  }
}

