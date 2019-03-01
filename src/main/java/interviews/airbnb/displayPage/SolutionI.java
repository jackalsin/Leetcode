package interviews.airbnb.displayPage;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

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
      final LinkedHashMap<String, String> curPage = new LinkedHashMap<>();
      // get the right page
      while (itr.hasNext() && curPage.size() < perPage) {
        final String entry = itr.next(), hostId = entry.split(",")[0];
        if (!curPage.containsKey(hostId)) {
          itr.remove();
          curPage.put(hostId, entry);
        }
      }

      for (Map.Entry<String, String> e : curPage.entrySet()) {
        result[resIndex++] = e.getValue();
      }

      itr = input.iterator();
      for (int i = 0; itr.hasNext() && curPage.size() + i < perPage; i++) {
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
