package _1551_1600._1570_Dot_Product_of_Two_Sparse_Vectors;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhixi
 * @version 1.0 on 2/9/2021
 */
public final class SparseVector {
  private final Map<Integer, Integer> indexToVal = new HashMap<>();
  private final int len;

  SparseVector(int[] nums) {
    assert nums != null && nums.length != 0;
    len = nums.length;
    for (int i = 0; i < len; ++i) {
      if (nums[i] != 0) {
        indexToVal.put(i, nums[i]);
      }
    }
  }

  public int dotProduct(SparseVector vec) {
    assert len == vec.len;
    if (indexToVal.size() > vec.indexToVal.size()) {
      return vec.dotProduct(this);
    }
    int res = 0;
    for (final Map.Entry<Integer, Integer> e : indexToVal.entrySet()) {
      final int key = e.getKey(), val = e.getValue();
      final Integer otherVal = vec.indexToVal.get(key);
      if (otherVal == null) continue;
      res += val * otherVal;
    }
    return res;
  }
}
