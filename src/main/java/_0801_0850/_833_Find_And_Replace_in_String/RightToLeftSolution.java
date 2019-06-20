package _0801_0850._833_Find_And_Replace_in_String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class RightToLeftSolution implements Solution {

  public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
    List<int[]> indexPairs = new ArrayList<>();
    for (int i = 0; i < indexes.length; ++i) {
      indexPairs.add(new int[]{indexes[i], i});
    }

    Collections.sort(indexPairs, new Comparator<int[]>() {
      @Override
      public int compare(final int[] i, int[] j) {
        return Integer.compare(j[0], i[0]);
      }
    });
    StringBuilder sb = new StringBuilder(S);

    for (int i = 0; i < indexPairs.size(); i++) {
      final int strIndex = indexPairs.get(i)[0], k = indexPairs.get(i)[1],
          end = Math.min(S.length(), strIndex + sources[k].length());
      if (!S.substring(strIndex, end).equals(sources[k])) continue;
      sb = new StringBuilder(sb.substring(0, strIndex)).append(targets[k]).append(sb.substring(strIndex + sources[k].length()));
    }
    return sb.toString();
  }

}
