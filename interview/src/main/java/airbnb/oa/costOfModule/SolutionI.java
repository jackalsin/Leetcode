package airbnb.oa.costOfModule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 6/28/2021
 */
public final class SolutionI implements Solution {
  @Override
  public String[] costOfModule(String[][] srcToChildren) {
    final Map<String, List<String>> childToParents = new HashMap<>();
    final Map<String, Set<String>> cost = new HashMap<>();
    for (final String[] item : srcToChildren) {
      for (int i = 0; i < item.length; ++i) {
        childToParents.putIfAbsent(item[i], new ArrayList<>());
        if (i > 0) {
          childToParents.get(item[i]).add(item[0]);
        }
      }
    }
    System.out.println(childToParents);
    for (final String c : childToParents.keySet()) {
      dfs(cost, c, childToParents);
    }
    final List<String> result = new ArrayList<>();
    for (Map.Entry<String, Set<String>> entry : cost.entrySet()) {
      result.add(String.format("%s,%d", entry.getKey(), entry.getValue().size()));
    }
    System.out.println(cost);
    return result.toArray(String[]::new);
  }

  private Set<String> dfs(final Map<String, Set<String>> costs, final String c,
                          final Map<String, List<String>> childToParents) {
    if (costs.containsKey(c)) return costs.get(c);
    final Set<String> cost = new HashSet<>() {{
      add(c);
    }};
    for (final String p : childToParents.getOrDefault(c, Collections.emptyList())) {
      final Set<String> cur = dfs(costs, p, childToParents);
      cost.addAll(cur);
    }
    costs.put(c, cost);
    return cost;
  }

  @Override
  public void costOfModule() throws IOException {
    final String[][] parentToChildren = getInput();
    final String[] output = costOfModule(parentToChildren);
    Arrays.stream(output).forEach(System.out::println);
  }

  private static String[][] getInput() throws IOException {
    try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      final int lines = Integer.parseInt(br.readLine());
      final String[][] result = new String[lines][];
      for (int i = 0; i < lines; ++i) {
        result[i] = br.readLine().split(",");
      }
      return result;
    }
  }
}
