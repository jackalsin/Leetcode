package _1551_1600._1600_ThroneInheritance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 4/15/2021
 */
public final class ThroneInheritanceI implements ThroneInheritance {

  private final String kingName;

  private final Map<String, List<String>> parentToChildren = new HashMap<>();
  private final Set<String> deads = new HashSet<>();

  public ThroneInheritanceI(String kingName) {
    this.kingName = kingName;
    parentToChildren.put(kingName, new ArrayList<>());
  }

  public void birth(String parentName, String childName) {
    parentToChildren.computeIfAbsent(parentName, k -> new ArrayList<>()).add(childName);
  }

  public void death(String name) {
    deads.add(name);
  }

  public List<String> getInheritanceOrder() {
    final List<String> result = new ArrayList<>();
    getInheritanceOrder(result, kingName);
    return new ArrayList<>(result);
  }

  private void getInheritanceOrder(final List<String> result, final String name) {
    if (!deads.contains(name)) {
      result.add(name);
    }
    final List<String> children = parentToChildren.getOrDefault(name, Collections.emptyList());
    for (final String child : children) {
      getInheritanceOrder(result, child);
    }
  }

}
