package _1251_1300._1268_Search_Suggestions_System;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * @author jacka
 * @version 1.0 on 12/23/2019
 */
public final class BinarySearchSolution implements Solution {
  private static final String NEXT = String.valueOf((char) ('z' + 1));

  public List<List<String>> suggestedProducts(String[] products, String searchWord) {
    final TreeMap<String, Integer> map = new TreeMap<>();
    Arrays.sort(products);
    List<String> productsList = Arrays.asList(products);
    for (int i = 0; i < products.length; i++) {
      map.put(products[i], i);
    }
//    System.out.println(productsList);
    final List<List<String>> result = new ArrayList<>();
    String key = "";
    for (final char chr : searchWord.toCharArray()) {
      key += chr;
      final String ceiling = map.ceilingKey(key), // key = "m", find "ma..."
          floor = map.floorKey(key + NEXT);
      if (ceiling == null || floor == null) {
        break;
      }
      final int start = map.get(ceiling),
          end = Math.min(map.get(ceiling) + 3, map.get(floor) + 1);
//      System.out.println("key = " + key + ", ceiling = " + ceiling + ", start = " + start
//          + ", floor = " + floor + ", end = " + end);
      result.add(productsList.subList(start, end));
    }
    while (result.size() < searchWord.length()) {
      result.add(new ArrayList<>());
    }
    return result;
  }
}
