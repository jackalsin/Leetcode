package doordash._721_Accounts_Merge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public final class SolutionIII implements Solution {
  @Override
  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    final Map<String, Integer> emailToEmailIds = new HashMap<>();
    final Map<Integer, String> emailIdsToName = new HashMap<>();
    int emailId = 0;
    final UnionFind uf = new UnionFind();

    for (final List<String> acc : accounts) {
      final String name = acc.get(0);
      for (int j = 1; j < acc.size(); ++j) {
        final String email = acc.get(j);
        if (!emailToEmailIds.containsKey(email)) {
          emailToEmailIds.put(email, emailId);
          emailIdsToName.put(emailId, name);
          emailId++;
        }
        uf.union(emailToEmailIds.get(acc.get(j)), emailToEmailIds.get(acc.get(1)));
      } // end of email
    }

    final Map<Integer, TreeSet<String>> emailIdToEmails = new HashMap<>();
    for (final var e : emailToEmailIds.entrySet()) {
      final String email = e.getKey();
      final int rootId = uf.root(e.getValue());
      emailIdToEmails.computeIfAbsent(rootId, k -> new TreeSet<>()).add(email);
    }

    final List<List<String>> result = new ArrayList<>();
    for (final var e : emailIdToEmails.entrySet()) {
      final String name = emailIdsToName.get(e.getKey());
      final List<String> cur = new ArrayList<>();
      cur.add(name);
      cur.addAll(e.getValue());
      result.add(cur);
    }
    return result;
  }

  private static final class UnionFind {
    private final Map<Integer, Integer> sizes = new HashMap<>();
    private final Map<Integer, Integer> roots = new HashMap<>();

    private int root(int p) {
      while (p != roots.getOrDefault(p, p)) {
        p = roots.getOrDefault(p, p);
      }
      return p;
    }

    private void union(final int p, final int q) {
      final int rootP = root(p), rootQ = root(q),
          sizeP = sizes.getOrDefault(rootP, 1),
          sizeQ = sizes.getOrDefault(rootQ, 1), total = sizeP + sizeQ;
      if (sizeP < sizeQ) {
        roots.put(rootP, rootQ);
        sizes.put(rootQ, total);
      } else {
        roots.put(rootQ, rootP);
        sizes.put(rootP, total);
      }
    }
  }
}
