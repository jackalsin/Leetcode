package airbnb.menuCombinationSum;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/18/2019.
 */
public interface PriceSolution {

  /**
   * @param itemToPrice item to price (can be zero)
   * @param sum         target sum
   * @param delta       allowed precise bias
   * @return a list of combinations that satisfies sum of price whose bias less than or equals <tt>delta</tt>
   */
  List<List<Double>> combinationSum(List<Double> itemToPrice, final double sum, final double delta);
}
