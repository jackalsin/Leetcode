package _0551_0600._551_Student_Attendance_Record_I;

/**
 * @author jacka
 * @version 1.0 on 12/18/2017.
 */
public class Solution {
  public boolean checkRecord(String s) {
    int aCount = 0, continusL = 0;
    final char[] chars = s.toCharArray();
    for (int i = 0; i < s.length(); i++) {
      final char chr = chars[i];
      if (chr == 'A') {
        continusL = 0;
        aCount++;
        if (aCount > 1) {
          return false;
        }
      } else if (chr == 'L') {
        continusL++;
        if (continusL > 2) {
          return false;
        }
      } else {
        continusL = 0;
      }
    }
    return true;
  }
}
