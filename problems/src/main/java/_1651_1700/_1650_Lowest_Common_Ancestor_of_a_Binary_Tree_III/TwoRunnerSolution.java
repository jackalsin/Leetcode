package _1651_1700._1650_Lowest_Common_Ancestor_of_a_Binary_Tree_III;

import definition._1650_Lowest_Common_Ancestor_of_a_Binary_Tree_III.Node;

public final class TwoRunnerSolution implements Solution {
  @Override
  public Node lowestCommonAncestor(Node p, Node q) {
    Node a = p, b = q;
    while (a != b) {
      a = a == null ? q : a.parent;
      b = b == null ? p : b.parent;
    }
    return a;
  }
}
