package facebook._1570_Dot_Product_of_Two_Sparse_Vectors;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 4/22/2021
 */
public final class SparseVector {
  private final Map<Integer, Integer> indexToVal = new HashMap<>();

  public SparseVector(final int[] nums) {
    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] != 0) indexToVal.put(i, nums[i]);
    }
  }

  public int dotProduct(SparseVector vec) {
    int res = 0;
    final int size1 = indexToVal.size(), size2 = vec.indexToVal.size();
    if (size1 > size2) {
      return vec.dotProduct(this);
    }
    for (final var e : indexToVal.entrySet()) {
      final int i = e.getKey(), val = e.getValue();
      res += vec.indexToVal.getOrDefault(i, 0) * val;
    }
    return res;
  }
}
