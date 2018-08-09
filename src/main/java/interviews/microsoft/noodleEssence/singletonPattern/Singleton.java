package interviews.microsoft.noodleEssence.singletonPattern;

public final class Singleton {
  private static Target target;

  private Singleton() {
  }

  public static synchronized Target getInstance() {
    if (target == null) {
      target = new Target();
    }
    return target;
  }
}
