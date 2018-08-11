package interviews.microsoft.noodleEssence.singletonPattern;

public final class SingletonSynchronizedMethod {
  private static long idCount = 0;
  private volatile long id;
  private static SingletonSynchronizedMethod target;

  private SingletonSynchronizedMethod() {
    id = idCount++;
  }

  public long getId() {
    return id;
  }

  public static synchronized SingletonSynchronizedMethod getInstance() {
    if (target == null) {
      target = new SingletonSynchronizedMethod();

    }
    return target;
  }

}
