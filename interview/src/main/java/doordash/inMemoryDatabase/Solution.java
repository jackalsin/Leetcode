package doordash.inMemoryDatabase;

public interface Solution {
  //把key的val设成value
  void set(String key, int value);

  // 返回key的val，如果没有返回-1
  int get(String key);

  // //cache之前的所有操作
  void begin();

  //  消除上次begin后的所有操作
  boolean rollback();

  //  把当前所有操作都写到memory里，也就是把memory的初始状态设成当前状态
  boolean commit();

  //  如果有key，那就把这个key踢了
  void unset(String key);
}
