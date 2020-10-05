package _0901_0950._925_Long_Pressed_Name;

/**
 * @author zhixi
 * @version 1.0 on 9/21/2020
 */
public final class SolutionI implements Solution {
  @Override
  public boolean isLongPressedName(String name, String typed) {
    int j = 0;
    for (int i = 0; i < name.length(); ++i, ++j) {
      if (j >= typed.length()) return false;
      final int nameStartIndex = i,
          typedStartIndex = j;
      final char nameChr = name.charAt(nameStartIndex),
          typedChr = typed.charAt(typedStartIndex);
      if (nameChr != typedChr) return false;
      while (i + 1 < name.length() && name.charAt(i + 1) == nameChr) ++i;
      final int nameLen = i - nameStartIndex + 1;
      while (j + 1 < typed.length() && typed.charAt(j + 1) == typedChr) ++j;
      final int typedLen = j - typedStartIndex + 1;
      if (nameLen > typedLen) return false;
    }
    return j == typed.length();
  }
}
