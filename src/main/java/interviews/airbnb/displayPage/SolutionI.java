package interviews.airbnb.displayPage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 2/28/2019.
 */
public final class SolutionI implements Solution {
  @Override
  public String[] pagination(int perPage, final String[] pages) {
    if (pages == null || pages.length == 0) {
      return new String[]{};
    }
    // init the result array
    final int pageNum = pages.length / perPage + (pages.length % perPage == 0 ? 0 : 1);
    final String[] result = new String[pages.length + pageNum - 1];

    // make the input linked list
    final LinkedList<String> input = new LinkedList<>(Arrays.asList(pages));
    Iterator<String> itr = input.iterator();
    int resIndex = 0;
    while (itr.hasNext() && resIndex != result.length) {
      final Set<String> visitedHosts = new HashSet<>();
      // get the right page
      while (itr.hasNext() && visitedHosts.size() < perPage) {
        final String entry = itr.next(), hostId = entry.split(",")[0];
        if (!visitedHosts.contains(hostId)) {
          result[resIndex++] = entry;
          itr.remove();
          visitedHosts.add(hostId);
        }
      }

      itr = input.iterator();
      for (int i = 0; itr.hasNext() && visitedHosts.size() + i < perPage; i++) {
        final String entry = itr.next();
        itr.remove();
        result[resIndex++] = entry;
      }

      if (!input.isEmpty()) {
        result[resIndex++] = " ";
      }

      itr = input.iterator();
    }
    return result;
  }
}
