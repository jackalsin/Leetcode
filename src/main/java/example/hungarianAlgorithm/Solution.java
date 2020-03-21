package example.hungarianAlgorithm;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/16/2020
 */
public interface Solution {

  /**
   * 匈牙利算法的目的是求全局最小cost的完美匹配
   *
   * @param n     size of vertex
   * @param edges unweighted undirected edge, id starts from 0
   * @return matched result
   */
  List<Integer> match(final int n, final int[][] edges);
}
