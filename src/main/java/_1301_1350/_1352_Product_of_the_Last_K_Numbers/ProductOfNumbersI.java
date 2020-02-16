package _1301_1350._1352_Product_of_the_Last_K_Numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/15/2020
 */
public final class ProductOfNumbersI implements ProductOfNumbers {

  private final List<Integer> cache = new ArrayList<>();

  {
    cache.add(1);
  }

  public void add(int num) {
    if (num > 0) {
      cache.add(cache.get(cache.size() - 1) * num);
    } else {
      cache.clear();
      cache.add(1);
    }
  }

  public int getProduct(int k) {
    final int n = cache.size();
    if (k < n) {
      return cache.get(n - 1) / cache.get(n - k - 1);
    }
    return 0;
  }
}
