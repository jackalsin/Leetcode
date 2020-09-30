package _0951_1000._956_Tallest_Billboard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 9/28/2020
 */
public final class BruteForceSolution implements Solution {
  private final Map<State, Integer> cache = new HashMap<>();

  public int tallestBillboard(int[] rods) {
    return tallestBillboard(rods, 0, 0, new HashSet<>(), new HashSet<>(), 0);
  }

  private int tallestBillboard(final int[] rods, final int sum1, final int sum2,
                               final Set<Integer> list1, final Set<Integer> list2, final int i) {
    if (sum1 > 2500 || sum2 > 2500) return 0;
    if (i == rods.length) {
      if (sum1 == sum2) {
        return sum1;
      }
      return 0;
    }
    final State key = new State(list1, list2, i);
    if (cache.containsKey(key)) {
      return cache.get(key);
    }
    final int candidate0 = sum1 == sum2 ? sum1 : 0;
    list1.add(i);
    final int candidate1 = tallestBillboard(rods, sum1 + rods[i], sum2, list1, list2, i + 1);
    list1.remove(i);
    list2.add(i);
    final int candidate2 = tallestBillboard(rods, sum1, sum2 + rods[i], list1, list2, i + 1);
    list2.remove(i);
    final int candidate3 = tallestBillboard(rods, sum1, sum2, list1, list2, i + 1);
    final int result = max(candidate0, candidate1, candidate2, candidate3);
    cache.put(key, result);
    return result;
  }

  private static int max(int a, final int... b) {
    for (int c : b) {
      a = Math.max(a, c);
    }
    return a;
  }

  private static final class State {
    private final Set<Set<Integer>> combinations = new HashSet<>();
    private final int i;

    public State(final Set<Integer> set1, final Set<Integer> set2, final int i) {
      combinations.add(new HashSet<>(set1));
      combinations.add(new HashSet<>(set2));
      this.i = i;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof State)) return false;
      State state = (State) o;
      return i == state.i &&
          Objects.equals(combinations, state.combinations);
    }

    @Override
    public int hashCode() {
      return Objects.hash(combinations, i);
    }
  }
}
