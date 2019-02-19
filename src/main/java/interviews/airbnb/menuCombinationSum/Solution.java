package interviews.airbnb.menuCombinationSum;

import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2/18/2019.
 */
public interface Solution {

  List<List<String>> combinationSum(final Map<String, Long> itemToPrice, long sum);
}
