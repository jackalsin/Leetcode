package airbnb.displayPage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class SolutionIII implements Solution {
  @Override
  public String[] pagination(int perPage, String[] pages) {
    if (pages == null || pages.length < perPage) {
      return pages;
    }
    final int totalPages = (pages.length / perPage + (pages.length % perPage == 0 ? 0 : 1)),
        size = pages.length + totalPages - 1; // 插入空行

    final String[] result = new String[size];
    final LinkedList<String> input = new LinkedList<>(Arrays.asList(pages));
    Iterator<String> iter = input.iterator();
    int resultIndex = 0;
    while (resultIndex < result.length) {
      final Set<String> curPageHostIds = new HashSet<>();
      int curCount = 0;
      // first loop;
      while (iter.hasNext()) {
        final String curLine = iter.next();
        final String[] items = curLine.split(",");
        final String hostId = items[0];
        if (curPageHostIds.contains(hostId)) continue;
        curPageHostIds.add(hostId);
        iter.remove();
        result[resultIndex++] = curLine;
        if (++curCount == perPage) break;
      }

      // reset iterator
      iter = input.iterator();

      for (int i = curCount; i < perPage && iter.hasNext(); i++) {
        final String curLine = iter.next();
        result[resultIndex++] = curLine;
        iter.remove();
      }
      if (resultIndex != result.length) {
        result[resultIndex++] = " ";
      }
    }
    return result;
  }
}
