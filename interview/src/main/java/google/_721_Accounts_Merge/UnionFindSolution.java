package google._721_Accounts_Merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author jacka
 * @version 1.0 on 5/10/2021
 */
public final class UnionFindSolution implements Solution {
  private static final int MAX_ACCOUNT = 1000, MAX_EMAIL_PER_ACCOUNT = 10;

  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    final UnionFind uf = new UnionFind(MAX_ACCOUNT * MAX_EMAIL_PER_ACCOUNT);
    int nextEmailId = 0;
    final Map<String, Integer> emailToEmailId = new HashMap<>();
    final Map<Integer, String> emailIdToName = new HashMap<>();
    for (final List<String> account : accounts) {
      final String name = account.get(0);
      for (int i = 1; i < account.size(); ++i) {
        final String email = account.get(i);
        if (!emailToEmailId.containsKey(email)) {
          emailIdToName.put(nextEmailId, name);
          emailToEmailId.put(email, nextEmailId++);
        }
        uf.union(emailToEmailId.get(account.get(1)), emailToEmailId.get(email));
      }
    }
    final Map<Integer, TreeSet<String>> idToEmails = new HashMap<>();
    for (final var e : emailToEmailId.entrySet()) {
      final String email = e.getKey();
      final int id = e.getValue(), rootId = uf.root(id);
      idToEmails.computeIfAbsent(rootId, k -> new TreeSet<>()).add(email);
    }

    final List<List<String>> result = new ArrayList<>();
    for (final var e : idToEmails.entrySet()) {
      final int id = e.getKey();
      final TreeSet<String> emails = e.getValue();
      final List<String> curList = new ArrayList<>();
      curList.add(emailIdToName.get(id));
      curList.addAll(emails);
      result.add(curList);
    }
    return result;
  }

  private static final class UnionFind {
    private final int[] roots, sizes;

    private UnionFind(final int n) {
      roots = new int[n];
      sizes = new int[n];
      Arrays.fill(sizes, 1);
      for (int i = 0; i < n; ++i) {
        roots[i] = i;
      }
    }

    private void union(final int p, final int q) {
      final int rootP = root(p), rootQ = root(q),
          sizeP = sizes[rootP], sizeQ = sizes[rootQ];
      if (sizeP < sizeQ) {
        roots[rootP] = rootQ;
        sizes[rootQ] += sizes[rootP];
      } else {
        roots[rootQ] = rootP;
        sizes[rootP] += sizes[rootQ];
      }
    }

    private int root(int p) {
      while (p != roots[p]) {
        roots[p] = roots[roots[p]];
        p = roots[p];
      }
      return p;
    }

    @Override
    public String toString() {
      return "UnionFind{" +
          "roots=" + Arrays.toString(roots) +
          ", sizes=" + Arrays.toString(sizes) +
          '}';
    }
  }
}
