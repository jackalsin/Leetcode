package doordash.inMemoryDatabase;

import java.util.HashMap;
import java.util.Map;

public final class SolutionI implements Solution {
  private final Map<String, Integer> persisted = new HashMap<>(),
      transaction = new HashMap<>();

  @Override
  public void set(String key, int value) {
    transaction.put(key, value);
  }

  @Override
  public int get(String key) {
    if (transaction.containsKey(key)) return transaction.get(key);
    if (persisted.containsKey(key)) return persisted.get(key);
    return -1;
  }

  @Override
  public void begin() {
    commit();
  }

  @Override
  public boolean rollback() {
    final boolean isEmpty = transaction.isEmpty();
    transaction.clear();
    return !isEmpty;
  }

  @Override
  public boolean commit() {
    persisted.putAll(transaction);
    final boolean result = !transaction.isEmpty();
    transaction.clear();
    return result;
  }

  @Override
  public void unset(String key) {
    transaction.remove(key);
    persisted.remove(key);
  }

}
