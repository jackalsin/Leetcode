package interviews.microsoft.noodleEssence._420_Strong_Password_Checker;

public class Solution {

  public int strongPasswordChecker(String s) {
    int toAdd = s.length() < 6 ? 6 - s.length() : 0;
    int toDel = s.length() >= 20 ? s.length() - 20 : 0;
    int needUpper = 1, needLower = 1, needDigit = 1;

    int zero = 0, one = 0, two = 0, toReplace = 0;

    for (int i = 0; i < s.length(); i++) {
      final char chr = s.charAt(i);
      if (Character.isDigit(chr)) {
        needDigit = 0;
      } else if (Character.isLowerCase(chr)) {
        needLower = 0;
      } else if (Character.isUpperCase(chr)) {
        needUpper = 0;
      }

      final int start = i;
      int count = 1;
      while (i + 1 < s.length() && s.charAt(i + 1) == s.charAt(start)) {
        count++;
        i++;
      }
      if (count >= 3) {
        toReplace += count / 3;
        if (count % 3 == 0) {
          zero++;
        } else if (count % 3 == 1) {
          one++;
        } else {
          two++;
        }
      }
    }


    if (toAdd > 0) {
      //              at least you need add these 3
      return Math.max(needUpper + needLower + needDigit, toAdd);
    } else if (toDel > 0) {
      // For any repeating sequences with len % 3 == 0, we can reduce one replacement by deleting one character.
      // For any repeating sequences with len % 3 == 1, we can reduce one replacement by deleting two character.
      int remainDel = toDel;

      toReplace -= Math.min(remainDel, zero);
      remainDel = Math.max(0, remainDel - zero);

      toReplace -= Math.min(remainDel / 2, one);
      remainDel = Math.max(0, remainDel - 2 * one);

      toReplace -= Math.max(0, remainDel / 3);
      return toDel + Math.max(toReplace, needLower + needUpper + needDigit);
    } else {
      assert toAdd == 0 && toDel == 0;
      // no add, no del
      return Math.max(toReplace, needLower + needUpper + needDigit);
    }
  }
}
