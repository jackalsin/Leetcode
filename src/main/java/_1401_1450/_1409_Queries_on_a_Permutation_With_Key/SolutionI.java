package _1401_1450._1409_Queries_on_a_Permutation_With_Key;

public final class SolutionI implements Solution {
  @Override
  public int[] processQueries(int[] queries, int m) {
    final int n = queries.length;
    final int[] result = new int[n];
    final int[] vals = new int[m], valToIndex = new int[m + 1];
    for (int i = 0; i < m; i++) {
      vals[i] = i + 1;
      valToIndex[i + 1] = i;
    }
    for (int i = 0; i < n; ++i) {
      final int val = queries[i], index = valToIndex[val];
      result[i] = index;
      for (int j = index; j > 0; j--) {
        valToIndex[vals[j - 1]]++;
        vals[j] = vals[j - 1];
      }
      vals[0] = val;
      valToIndex[val] = 0;
    }
    return result;
  }
}
