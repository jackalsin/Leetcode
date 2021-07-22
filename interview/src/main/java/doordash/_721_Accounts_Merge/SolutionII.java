package doordash._721_Accounts_Merge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public final class SolutionII implements Solution {
  private static final int ACCOUNTS = 1000, EMAIL_PER_ACCOUNT = 30;

  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    final Map<String, Integer> emailToEmailId = new HashMap<>();
    final Map<Integer, String> emailIdToName = new HashMap<>();
    int emailId = 0;
    final UnionFind uf = new UnionFind();
    for (final List<String> account : accounts) {
      final String name = account.get(0);
      for (int i = 1; i < account.size(); ++i) {
        final String email = account.get(i);
        if (!emailToEmailId.containsKey(email)) {
          emailToEmailId.put(email, emailId);
          emailIdToName.put(emailId, name);
          emailId++;
        }
        uf.union(emailToEmailId.get(account.get(1)), emailToEmailId.get(account.get(i)));
      }
    } // end for
    final Map<Integer, TreeSet<String>> idToEmails = new HashMap<>();
    for (final Map.Entry<String, Integer> e : emailToEmailId.entrySet()) {
      final int id = e.getValue(), rootId = uf.root(id);
      idToEmails.computeIfAbsent(rootId, k -> new TreeSet<>()).add(e.getKey());
    }
    final List<List<String>> result = new ArrayList<>();
    for (final Map.Entry<Integer, TreeSet<String>> e : idToEmails.entrySet()) {
      final List<String> cur = new ArrayList<>();
      result.add(cur);
      cur.add(emailIdToName.get(e.getKey()));
      cur.addAll(e.getValue());
    }
    return result;
  }

  private static final class UnionFind {
    private final Map<Integer, Integer> sizes = new HashMap<>(),
        roots = new HashMap<>();

    private void union(final int p, final int q) {
      final int rootP = root(p), rootQ = root(q),
          sizeP = sizes.getOrDefault(rootP, 1), sizeQ = sizes.getOrDefault(rootQ, 1);

      if (sizeP < sizeQ) {
        roots.put(rootP, rootQ);
        sizes.put(rootQ, sizeP + sizeQ);
      } else {
        roots.put(rootQ, rootP);
        sizes.put(rootQ, sizeP + sizeQ);
      }
    }

    private int root(int p) {
      while (p != roots.getOrDefault(p, p)) {
        roots.put(roots.getOrDefault(p, p), roots.getOrDefault(roots.getOrDefault(p, p), roots.getOrDefault(p, p)));
        p = roots.getOrDefault(p, p);
      }
      return p;
    }
  }

}
