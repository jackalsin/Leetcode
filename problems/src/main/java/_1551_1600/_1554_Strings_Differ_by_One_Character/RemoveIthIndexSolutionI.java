package _1551_1600._1554_Strings_Differ_by_One_Character;

import java.util.HashSet;
import java.util.Set;

public final class RemoveIthIndexSolutionI implements Solution {

  public boolean differByOne(String[] dict) {
    final int strLen = dict[0].length();
    for (int i = 0; i < strLen; ++i) {
      final Set<String> visited = new HashSet<>();
      for (final String str : dict) {
        final String newString = str.substring(0, i) + str.substring(i + 1);
        if (!visited.add(newString)) return true;
      }
    }
    return false;
  }
}
