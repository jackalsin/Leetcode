package airbnb._756_Pyramid_Transition_Matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 9/4/2021
 */
public final class SolutionI implements Solution {
  private final Map<String, List<Character>> map = new HashMap<>();
  private final Map<String, Boolean> cache = new HashMap<>();

  public boolean pyramidTransition(String bottom, List<String> allowed) {
    for (final String allow : allowed) {
      map.computeIfAbsent(allow.substring(0, 2), k -> new ArrayList<>()).add(allow.charAt(2));
    }
    return pyramidTransition(bottom, 0, new StringBuilder());
  }

  private boolean pyramidTransition(final String bottom,
                                    final int index, final StringBuilder sb) {
    if (bottom.length() == 1) return true;
    if (cache.containsKey(bottom)) return cache.get(bottom);
    if (index == bottom.length() - 1) {
      final boolean res = pyramidTransition(sb.toString(), 0, new StringBuilder());
      cache.put(sb.toString(), res);
      return res;
    }
    final int len = sb.length();
    final List<Character> children = map.getOrDefault(bottom.substring(index, index + 2), Collections.emptyList());
    for (final char c : children) {
      sb.append(c);
      if (pyramidTransition(bottom, index + 1, sb)) {
        return true;
      }
      sb.setLength(len);
    }
    return false;
  }
}
