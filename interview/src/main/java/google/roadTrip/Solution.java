package google.roadTrip;

/**
 * @author jacka
 * @version 1.0 on 5/6/2021
 */
public interface Solution {
  Cost getMinCost(final Cost[][] costs, final int start, final int end);
}
