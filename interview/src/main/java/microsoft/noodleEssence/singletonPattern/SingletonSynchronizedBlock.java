package microsoft.noodleEssence.singletonPattern;

/**
 * https://www.javamex.com/tutorials/double_checked_locking_fixing.shtml
 */
public final class SingletonSynchronizedBlock {
  private static long idCount = 0;
  private volatile long id;
  private static SingletonSynchronizedBlock target;

  private SingletonSynchronizedBlock() {
    id = idCount++;
  }

  public long getId() {
    return id;
  }

  public static SingletonSynchronizedBlock getInstance() {
    if (target == null) {
      synchronized (SingletonSynchronizedMethod.class) {
        if (target == null) {
          target = new SingletonSynchronizedBlock();
        }
      }
    }
    return target;
  }
}
