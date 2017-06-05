package _051_100._089_Gray_Code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 5/29/2017.
 */
public class Solution {
  public List<Integer> grayCode(int n) {
    List<Integer> result = new ArrayList<>();
    for(int i = 0; i < (1 << n); i++) {
      result.add(i ^ (i >> 1));
    }
    return result;
  }
}
