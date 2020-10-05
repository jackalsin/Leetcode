package airbnb.lowestCommonAncestors;

import definition.nAryTree.Node;

public interface LCANAryTree {
  Node getLowestCommonAncestor(final Node root, final Node p, final Node q);
}
