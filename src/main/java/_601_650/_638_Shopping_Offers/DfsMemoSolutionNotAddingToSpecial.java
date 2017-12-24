package _601_650._638_Shopping_Offers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DfsMemoSolutionNotAddingToSpecial implements Solution {
  private final Map<List<Integer>, Integer> cache = new HashMap<>();

  @Override
  public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
    int res = dfs(special, needs, price);
//    System.out.println(cache);
    return res;
  }

  private int dfs(final List<List<Integer>> special, final List<Integer> needs, final List<Integer> price) {
    if (cache.containsKey(needs)) {
      return cache.get(needs);
    } else {
      int min = Integer.MAX_VALUE;

      for (final List<Integer> curSpecial : special) {
        final List<Integer> newNeeds = new ArrayList<>(needs);
        boolean isValidNeed = true;
        int singlePrice = curSpecial.get(curSpecial.size() - 1);
        for (int i = 0; i < newNeeds.size(); i++) {
          int curNeed = newNeeds.get(i) - curSpecial.get(i);
          if (curNeed < 0) {
            isValidNeed = false;
            break;
          } else {
            newNeeds.set(i, curNeed);
          }
        }
        if (!isValidNeed) continue;
        int remainMin = dfs(special, newNeeds, price);
        if (remainMin != Integer.MAX_VALUE) {
          int curMin = singlePrice + remainMin;
          min = Math.min(min, curMin);
        }
      }

      int noSpecialTotal = 0;
      for (int i = 0; i < needs.size(); i++) {
        noSpecialTotal += needs.get(i) * price.get(i);
      }
      min = Math.min(noSpecialTotal, min);
      cache.put(needs, min);
//      System.out.println("needs = " + needs + "\nmin = " + min);
      return min;
    }
  }

  private boolean isValid(final List<Integer> needs) {
    for (int need : needs) {
      if (need < 0) {
        return false;
      }
    }
    return true;
  }

}
