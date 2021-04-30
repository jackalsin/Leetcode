package google._833_Find_And_Replace_in_String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 4/29/2021
 */
public final class SolutionII implements Solution {
  public String findReplaceString(String s, int[] indexes, String[] sources, String[] targets) {
    if (s == null || s.isEmpty() || indexes == null || indexes.length == 0) return s;
    final List<Pair> pairs = new ArrayList<>();
    for (int i = 0; i < indexes.length; ++i) {
      pairs.add(new Pair(indexes[i], sources[i], targets[i]));
    }
    Collections.sort(pairs, (x, y) -> Integer.compare(x.index, y.index));
    final StringBuilder sb = new StringBuilder();
    for (int i = 0, j = 0; i < s.length(); ) {
      while (j < indexes.length && i > pairs.get(j).index) {
        ++j;
      }
      if (j < indexes.length && i == pairs.get(j).index && s.startsWith(pairs.get(j).source, i)) {
        final Pair pair = pairs.get(j);
        sb.append(pair.target);
        ++j;
        i += pair.source.length();
      } else {
        sb.append(s.charAt(i));
        ++i;
      }
    }
    return sb.toString();
  }

  private static final class Pair {
    private final int index;
    private final String source, target;

    private Pair(int index, String source, String target) {
      this.index = index;
      this.source = source;
      this.target = target;
    }

    @Override
    public String toString() {
      return "Pair{" +
          "index=" + index +
          ", source='" + source + '\'' +
          ", target='" + target + '\'' +
          '}';
    }
  }
}
