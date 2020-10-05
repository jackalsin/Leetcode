package google._833_Find_And_Replace_in_String;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/31/2020
 */
public final class SolutionI implements Solution {
  @Override
  public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
    final List<Pair> pairs = new ArrayList<>();
    for (int i = 0; i < indexes.length; ++i) {
      pairs.add(new Pair(indexes[i], sources[i], targets[i]));
    }
    pairs.sort(Comparator.comparingInt(x -> x.srcIndex));
    final StringBuilder sb = new StringBuilder();
    for (int srcIndex = 0, pairIndex = 0; srcIndex < S.length(); ) {
      while (pairIndex < pairs.size() && pairs.get(pairIndex).srcIndex < srcIndex) {
        pairIndex++;
      }
      if (pairIndex < pairs.size() && pairs.get(pairIndex).srcIndex == srcIndex
          && S.startsWith(pairs.get(pairIndex).source, srcIndex)) {
        final Pair p = pairs.get(pairIndex);
        sb.append(p.target);
        pairIndex++;
        srcIndex += p.source.length();
      } else {
        sb.append(S.charAt(srcIndex++));
      }
    }
    return sb.toString();
  }

  private static final class Pair {
    private final int srcIndex;
    private final String source, target;

    private Pair(int srcIndex, String source, String target) {
      this.srcIndex = srcIndex;
      this.source = source;
      this.target = target;
    }
  }
}
