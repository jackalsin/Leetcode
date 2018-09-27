package interviews.linkedin.mianjing.retainBestCache;

import java.util.*;

public class RetainBestCache<K, T extends Rankable> {
  private final DataSource<K, T> ds;
  private final Map<K, T> cache = new HashMap<>();
  private final TreeMap<Long, Set<K>> rankToKeys = new TreeMap<>();
  private final int size;

  public RetainBestCache(DataSource<K, T> ds, int size) {
    this.size = size;
    this.ds = ds;
  }

  /* Gets some data. If possible, retrieves it from cache to be fast. If the data is not cached,
   * retrieves it from the data source. If the cache is full, attempt to cache the returned data,
   * evicting the T with lowest rank among the ones that it has available. from: 1point3acres
   * If there is a tie, the cache may choose any T with lowest rank to evict.
   */
  public T get(K key) {
    if (size == 0) {
      return ds.get(key);
    }
    if (cache.containsKey(key)) {
      return cache.get(key);
    }

    if (size >= cache.size()) {
      removeTheOldest();
    }
    final T t = ds.get(key);
    cache.put(key, t);
    rankToKeys.computeIfAbsent(t.getRank(), k -> new HashSet<>()).add(key);
    return t;
  }

  private void removeTheOldest() {
    final Map.Entry<Long, Set<K>> entry = rankToKeys.firstEntry();
    final Set<K> keySet = entry.getValue();
    final K toRemove = keySet.iterator().next();
    if (keySet.size() == 1) {
      rankToKeys.remove(entry.getKey());
    } else {
      keySet.remove(toRemove);
    }

    cache.remove(toRemove);
  }

}
