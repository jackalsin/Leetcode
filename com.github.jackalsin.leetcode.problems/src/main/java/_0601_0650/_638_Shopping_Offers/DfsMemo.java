package _0601_0650._638_Shopping_Offers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DfsMemo implements Solution {
  private final Map<List<Integer>, Integer> cache = new HashMap<>();

  @Override
  public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
    for (int i = 0; i < price.size(); i++) {
      List<Integer> newOffer = new ArrayList<>(price);
      for (int j = 0; j < price.size(); j++) {
        newOffer.set(j, i == j ? 1 : 0);
      }
      newOffer.add(price.get(i));
      special.add(newOffer);
    }
//    System.out.println(special);
    return dfs(special, needs, 0);
  }

  private int dfs(final List<List<Integer>> special, final List<Integer> needs, final int specialIndex) {
    if (cache.containsKey(needs)) {
      return cache.get(needs);
    } else if (specialIndex == special.size()) {
      for (int need : needs) {
        if (need != 0) {
          return Integer.MAX_VALUE;
        }
      }
      return 0;
    } else {
      final List<Integer> curSpecial = special.get(specialIndex);
      int min = Integer.MAX_VALUE, singlePrice = curSpecial.get(curSpecial.size() - 1);
      final List<Integer> newNeeds = new ArrayList<>(needs);
      int offerCount = 0;
      while (isValid(newNeeds)) {
        int remainMin = dfs(special, newNeeds, specialIndex + 1);
        if (remainMin != Integer.MAX_VALUE) {
          int curMin = singlePrice * offerCount + remainMin;
          min = Math.min(min, curMin);
        }
        for (int i = 0; i < newNeeds.size(); i++) {
          newNeeds.set(i, newNeeds.get(i) - curSpecial.get(i));
        }
        offerCount++;
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
