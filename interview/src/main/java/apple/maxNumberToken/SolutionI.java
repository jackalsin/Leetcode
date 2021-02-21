package apple.maxNumberToken;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 2/20/2021
 */
public final class SolutionI implements Solution {
  @Override
  public Map<String, Integer> getMaxNumberToken(final String line, final int maxNumberToken) {
    final Map<String, Integer> result = new HashMap<>();
    if (maxNumberToken == 0) {
      return result;
    }
    final String[] words = line.split("\\s");
    final Queue<StringBuilder> q = new ArrayDeque<>();
    for (final String word : words) {
      q.add(new StringBuilder());
      if (q.size() > maxNumberToken) {
        q.remove();
      }

      for (final StringBuilder sb : q) {
        if (sb.length() != 0) {
          sb.append(" ");
        }
        sb.append(word);
        final String key = sb.toString();
        result.put(key, result.getOrDefault(key, 0) + 1);
      }
    }
    return result;
  }
}
