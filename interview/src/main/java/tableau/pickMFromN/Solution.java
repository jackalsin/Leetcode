package tableau.pickMFromN;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/16/2020
 */
public interface Solution {
  //  Choose m from n items given a rand from a range
  List<Integer> getMFromRange(final int start, final int end, final int picked);
}
