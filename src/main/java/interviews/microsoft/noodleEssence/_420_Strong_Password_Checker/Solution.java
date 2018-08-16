package interviews.microsoft.noodleEssence._420_Strong_Password_Checker;

public class Solution { //TODO:

  public int strongPasswordChecker(String s) {
    int add = s.length() < 6 ? 6 - s.length() : 0;
    int del = s.length() >= 20 ? 0 : s.length() - 20;

    int dupMod = 0, curDup = 0;
    for (int i = 0; i < s.length(); i++) {
      final int start = i;
      int count = 1;
      while (i + 1 < s.length() && s.charAt(i + 1) == s.charAt(start)) {
        count++;
        i++;
      }
      dupMod = count / 3;
    }

    if (add == 0) {

    }
    return 0;// todo:
  }
}
