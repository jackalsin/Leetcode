package microsoft._387_First_Unique_Character_in_a_String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class SolutionI implements Solution {
  public int firstUniqChar(String s) {
    final Map<Character, List<Integer>> charToSeen = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      final char chr = s.charAt(i);
      charToSeen.putIfAbsent(chr, new ArrayList<>());
      charToSeen.get(chr).add(i);
    }

    int i = s.length();
    for (final Map.Entry<Character, List<Integer>> entry : charToSeen.entrySet()) {
      final List<Integer> indexList = entry.getValue();
      if (indexList.size() == 1) {
        i = Math.min(i, indexList.get(0));
      }
    }
    return i == s.length() ? -1 : i;
  }
}
