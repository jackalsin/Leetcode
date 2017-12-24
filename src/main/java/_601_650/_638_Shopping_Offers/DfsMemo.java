package _601_650._638_Shopping_Offers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DfsMemo implements Solution {
  private final Map<List<Integer>, Integer> cache = new HashMap<>();

  @Override
  public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
    final List<Integer> allZeros = new ArrayList<>();
    for (int i = 0; i < price.size(); i++) {
      allZeros.add(0);
    }
    cache.put(allZeros, 0);
//    System.out.println(special);
    return dfs(special, needs, price, 0);
  }

  private int dfs(final List<List<Integer>> special, final List<Integer> needs, final List<Integer> price,
                  final int specialIndex) {
    if (cache.containsKey(needs)) {
      return cache.get(needs);
    } else if (specialIndex == special.size()) {
      int res = 0;
      for (int i = 0; i < needs.size(); i++) {
        int need = needs.get(i);
        if (need < 0) {
          return Integer.MAX_VALUE;
        } else if (need > 0) {
          res += price.get(i) * need;
        }
      }
      cache.put(needs, res);
      return res;
    } else {
      final List<Integer> curSpecial = special.get(specialIndex);
      int min = Integer.MAX_VALUE, singlePrice = curSpecial.get(curSpecial.size() - 1);
      final List<Integer> newNeeds = new ArrayList<>(needs);
      int notUseOffer = dfs(special, newNeeds, price, specialIndex + 1);
      if (notUseOffer != Integer.MAX_VALUE) {
        min = Math.min(notUseOffer, min);
      }
      for (int i = 0; i < newNeeds.size(); i++) {
        newNeeds.set(i, newNeeds.get(i) - curSpecial.get(i));
      }
      if (isValid(newNeeds)) {
        int useOffer = dfs(special, newNeeds, price, specialIndex + 1);
        if (useOffer != Integer.MAX_VALUE) {
          min = Math.min(singlePrice + useOffer, min);
        }
      }
      cache.put(needs, min);
//      System.out.println("needs = " + needs+"\nmin = " + min);
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
