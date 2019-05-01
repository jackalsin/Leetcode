package interviews.airbnb.menuCombinationSum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author jacka
 * @version 1.0 on 2/18/2019.
 */
public final class SolutionII implements MenuSolution {

  /**
   * @param itemToPrice item to price (can be zero)
   * @param sum         target sum
   * @param delta       allowed precise bias
   * @return a list of combinations that satisfies sum of price whose bias less than or equals <tt>delta</tt>
   */
  public List<List<String>> combinationSum(Map<String, Double> itemToPrice, final double sum, final double delta) {
    final List<List<String>> result = new ArrayList<>();
    final List<Entry> candidates = itemToPrice.entrySet().stream().map(kvp -> new Entry(kvp.getKey(), kvp.getValue())).sorted((a, b) -> {
      final int cmp = Double.compare(a.price, b.price);
      if (cmp == 0) {
        return a.name.compareTo(b.name);
      }
      return cmp;
    }).collect(Collectors.toList());
    dfs(result, candidates, delta, sum, new ArrayList<>(), 0);
    result.forEach(l -> l.sort(String::compareTo));
    return result;
  }

  private static void dfs(final List<List<String>> result, final List<Entry> candidates, final double delta, final double sum,
                          final List<String> curPath, final int startIndex) {
    if (sum + delta < 0) {
      return;
    } else if (Math.abs(sum) <= delta) {
      result.add(new ArrayList<>(curPath));
    }

    for (int i = startIndex; i < candidates.size(); i++) {
      final Entry e = candidates.get(i);
      if (sum - e.price + delta < 0) return;
      curPath.add(e.name);
      dfs(result, candidates, delta, sum - e.price, curPath, i + 1);
      curPath.remove(curPath.size() - 1);
    }

  }

  private static final class Entry {
    private final String name;
    private final double price;

    private Entry(String entry, double price) {
      this.name = entry;
      this.price = price;
    }
  }
}
