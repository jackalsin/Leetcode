package apple._460_LFU_Cache;

/**
 * @author jacka
 * @version 1.0 on 2/25/2021
 */
public interface LFUCache {
  int get(int key);

  void put(int key, int value);
}
