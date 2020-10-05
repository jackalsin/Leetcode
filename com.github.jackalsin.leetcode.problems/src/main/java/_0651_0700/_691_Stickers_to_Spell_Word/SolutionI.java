package _0651_0700._691_Stickers_to_Spell_Word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 3/14/2020
 */
public final class SolutionI implements Solution {
  private final Map<Map<Character, Integer>, Integer> cache = new HashMap<>();
  private final List<Map<Character, Integer>> candidates = new ArrayList<>();

  public int minStickers(String[] stickers, String target) {
    for (final String s : stickers) {
      candidates.add(getCount(s));
    }
    return minStickers(getCount(target));
  }

  private int minStickers(final Map<Character, Integer> target) {
    if (target.isEmpty()) {
      return 0;
    }
    if (cache.containsKey(target)) {
      return cache.get(target);
    }
    int res = Integer.MAX_VALUE;
    // it's an optimization. If the candidate doesn't contains the key, we ignore
    final char mustHave = target.entrySet().iterator().next().getKey();
    for (final Map<Character, Integer> candidate : candidates) {
      if (!candidate.containsKey(mustHave)) continue;
      final Map<Character, Integer> nextTarget = new HashMap<>(target);
      for (final Map.Entry<Character, Integer> e : candidate.entrySet()) {
        final char key = e.getKey();
        final int candidateCount = e.getValue();
        final Integer curCount = nextTarget.get(key);
        if (curCount != null) {
          final int nextCount = curCount - candidateCount;
          if (nextCount <= 0) {
            nextTarget.remove(key);
          } else {
            nextTarget.put(key, nextCount);
          }
        }
      } // end of for
      final int nextStep = minStickers(nextTarget);
      if (nextStep == -1) {
        continue;
      }
      res = Math.min(res, nextStep + 1);
    }
    res = res == Integer.MAX_VALUE ? -1 : res;
    cache.put(target, res);
    return res;
  }

  private static Map<Character, Integer> getCount(final String target) {
    final Map<Character, Integer> result = new HashMap<>();
    for (final char c : target.toCharArray()) {
      result.put(c, result.getOrDefault(c, 0) + 1);
    }
    return result;
  }
}
