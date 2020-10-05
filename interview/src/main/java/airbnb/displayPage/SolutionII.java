package airbnb.displayPage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 2/28/2019.
 */
public final class SolutionII implements Solution {
  private static final int ENTRY_PER_PAGE = 5;

  @Override
  public String[] pagination(int perPage, final String[] pages) {
    if (pages == null || pages.length == 0) {
      return new String[]{};
    }
    final int pageNum = (int) Math.ceil((double) pages.length / ENTRY_PER_PAGE),
        len = pageNum - 1 + pages.length;
    final LinkedList<String> input = new LinkedList<>(Arrays.asList(pages));

    final String[] result = new String[len];
    Iterator<String> itr = input.iterator();
    for (int resultIndex = 0; resultIndex != len; ) {
      final Set<String> hostIds = new HashSet<>();
      while (itr.hasNext() && resultIndex < len && resultIndex % (ENTRY_PER_PAGE + 1) != 5) {
        final String entry = itr.next();
        final String[] items = entry.split(",");
        final String hostId = items[0];
        if (hostIds.contains(hostId)) continue;
        itr.remove();
        hostIds.add(hostId);
        result[resultIndex++] = entry;
      }

      // fill up to 5
      itr = input.iterator();
      while (itr.hasNext() && resultIndex % (ENTRY_PER_PAGE + 1) != 5) {
        result[resultIndex++] = itr.next();
        itr.remove();
      }

      if (resultIndex != len) {
        assert resultIndex % (ENTRY_PER_PAGE + 1) == 5;
        result[resultIndex++] = " ";
      }
    }
    return result;
  }
}
