package airbnb.menuCombinationSum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2/18/2019.
 */
public final class SolutionI implements Solution {
  @Override
  public List<List<String>> combinationSum(Map<String, Long> itemToPrice, long sum) {
    if (sum <= 0) {
      return new ArrayList<>();
    }
    final List<Entry> candidates = new ArrayList<>();
    for (Map.Entry<String, Long> e : itemToPrice.entrySet()) {
      candidates.add(new Entry(e.getKey(), e.getValue()));
    }

    final List<List<String>> result = new ArrayList<>();
    candidates.sort((i, j) -> Long.compare(j.price, i.price));
    dfs(result, candidates, new ArrayList<>(), sum, 0);
    return result;
  }

  private static void dfs(final List<List<String>> result, final List<Entry> candidates, final List<String> curPath,
                          final long remain, final int start) {
    if (remain < 0) {
      return;
    } else if (remain == 0) {
      result.add(new ArrayList<>(curPath));
      return;
    } else if (start >= candidates.size()) {
      return;
    }

    for (int i = start; i < candidates.size(); i++) {
      final Entry e = candidates.get(i);
      curPath.add(e.item);
      dfs(result, candidates, curPath, remain - e.price, i + 1);
      curPath.remove(curPath.size() - 1);
    }
  }

  public static final class Entry {
    private final String item;
    private final long price;

    public Entry(String item, long price) {
      this.item = item;
      this.price = price;
    }

    @Override
    public String toString() {
      return "Entry{" +
          "item='" + item + '\'' +
          ", price=" + price +
          '}';
    }
  }
}
