package _1401_1450._1418_Display_Table_of_Food_Orders_in_a_Restaurant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class SolutionI implements Solution {
  private final Set<String> foodNames = new HashSet<>();

  public List<List<String>> displayTable(List<List<String>> orders) {
    final Map<Integer, Map<String, Integer>> tableToFoodToCount = new HashMap<>();
    for (final List<String> order : orders) {
      final String t = order.get(1), foodName = order.get(2);
      final int tableId = Integer.parseInt(t);
      tableToFoodToCount.putIfAbsent(tableId, new HashMap<>());
      final Map<String, Integer> tableFoods = tableToFoodToCount.get(tableId);
      tableFoods.put(foodName, tableFoods.getOrDefault(foodName, 0) + 1);
      foodNames.add(foodName);
    }
    final List<String> foodNames = new ArrayList<>(this.foodNames);
    Collections.sort(foodNames);
    final List<List<String>> result = new ArrayList<>();
    final List<String> first = new ArrayList<>() {{
      add("Table");
    }};
    first.addAll(foodNames);
    result.add(first);
    final List<Map.Entry<Integer, Map<String, Integer>>> entries = new ArrayList<>(tableToFoodToCount.entrySet());
    for (final var e : entries) {
      final int table = e.getKey();
      final List<String> curRow = new ArrayList<>() {{
        add(String.valueOf(table));
      }};
      result.add(curRow);
      final Map<String, Integer> food = e.getValue();
      for (int i = 1; i < first.size(); ++i) {
        final String count = String.valueOf(food.getOrDefault(first.get(i), 0));
        curRow.add(count);
      }
    }
    return result;
  }
}
