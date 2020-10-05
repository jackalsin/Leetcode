package _0651_0700._691_Stickers_to_Spell_Word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 3/14/2020
 */
public final class TLESolution implements Solution {
  private final List<Map<Character, Integer>> countMap = new ArrayList<>();
  private final Map<Integer, Map<Map<Character, Integer>, Integer>> cache = new HashMap<>();

  public int minStickers(String[] stickers, String target) {
    for (final String s : stickers) {
      countMap.add(getCount(s));
    }
    return dfs(getCount(target), 0);
  }

  private int dfs(final Map<Character, Integer> prevCounts, final int countMapIndex) {
    if (prevCounts.isEmpty()) {
      return 0;
    }
    if (countMapIndex == countMap.size()) {
      return -1;
    }
    if (cache.getOrDefault(countMapIndex, new HashMap<>()).containsKey(prevCounts)) {
      return cache.get(countMapIndex).get(prevCounts);
    }
    final Map<Character, Integer> candidate = countMap.get(countMapIndex),
        counts = new HashMap<>(prevCounts);
    final int noUse = dfs(counts, countMapIndex + 1);
    assert counts.equals(prevCounts);
    int res = noUse == -1 ? Integer.MAX_VALUE : noUse;
    int steps = 0;
    while (true) {
      boolean hasIntersect = false;
      steps++;
      for (char chr = 'a'; chr <= 'z'; ++chr) {
        final Integer count = counts.get(chr), candidateCount = candidate.get(chr);
        if (count != null && candidateCount != null) {
          hasIntersect = true;
          final int next = count - candidateCount;
          if (next <= 0) {
            counts.remove(chr);
          } else {
            counts.put(chr, next);
          }
        }
      } // end of generate
      if (!hasIntersect) break;
      final int nextRes = dfs(counts, countMapIndex + 1);
      if (nextRes == -1) {
        continue;
      }
      res = Math.min(res, nextRes + steps);
    }
    res = res == Integer.MAX_VALUE ? -1 : res;
    cache.putIfAbsent(countMapIndex, new HashMap<>());
    cache.get(countMapIndex).put(prevCounts, res);
    return res;
  }

  private Map<Character, Integer> getCount(final String w) {
    final Map<Character, Integer> count = new HashMap<>();
    for (final char c : w.toCharArray()) {
      count.put(c, count.getOrDefault(c, 0) + 1);
    }
    return count;
  }
}
