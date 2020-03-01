package _0551_0600._558_Logical_OR_of_Two_Binary_Grids_Represented_as_Quad_Trees;

import utils._558_Logical_OR_of_Two_Binary_Grids_Represented_as_Quad_Trees.Node;

/**
 * @author jacka
 * @version 1.0 on 2/29/2020
 */
public interface Solution {
  /**
   * 这题可以问候出题人全家，如果四个children都是同一个value，且都是leaf，可以不用再分了，也就是children要设置成null
   */
  Node intersect(Node quadTree1, Node quadTree2);
}
