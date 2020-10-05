package linkedin._833_Find_And_Replace_in_String;

import java.util.Map;
import java.util.TreeMap;

public final class SolutionI implements Solution {
  public String findReplaceString(String s, int[] indexes, String[] sources, String[] targets) {
    final TreeMap<Integer, Integer> indexToSrcIndex = new TreeMap<>();
    for (int i = 0; i < indexes.length; ++i) {
      indexToSrcIndex.put(indexes[i], i);
    }

    while (!indexToSrcIndex.isEmpty()) {
      final Map.Entry<Integer, Integer> entry = indexToSrcIndex.lastEntry();
      indexToSrcIndex.remove(entry.getKey());
      final int strIndex = entry.getKey(), srcIndex = entry.getValue();
      if (s.startsWith(sources[srcIndex], strIndex)) {

        s = s.substring(0, strIndex) + targets[srcIndex] + s.substring(strIndex + sources[srcIndex].length());
      }
    }
    return s;
  }


}
