package interviews.pinterest._685_Redundant_Connection_II;

public class Solution { // TODO:

  public int[] findRedundantDirectedConnection(int[][] edges) {
    final int size = edges.length;
    final int[] parents = new int[size + 1];
    int[] candidateA = {-1, -1}, candidateB = {-1, -1};

    // check 2 parents
    for (int[] edge : edges) {
      final int parent = edge[0], v = edge[1];
      if (parents[v] == 0) {
        parents[v] = parent;
      } else {
        candidateA = new int[]{parents[edge[1]], edge[1]};
        candidateB = new int[]{edge[0], edge[1]};
        edge[1] = 0; // make invalid
      }
    }

    for (int i = 0; i < parents.length; i++) {
      parents[i] = i;
    }

    for (int[] edge : edges) {
      if (edge[1] == 0) {
        continue;
      }
      final int parent = edge[0], child = edge[1];
      if (root(parents, parent) == child) { // there is a cycle
        if (candidateA[0] == -1) { // there is a
          return edge;
        }
//        System.out.println("Return A");
        return candidateA;
      }
      parents[child] = parent;
    }
//    System.out.println("Return B");
    return candidateB;
  }

  private int root(int[] parents, int parent) {
    while (parent != parents[parent]) {
      parents[parent] = parents[parents[parent]];
      parent = parents[parent];
    }
    return parent;
  }
}
